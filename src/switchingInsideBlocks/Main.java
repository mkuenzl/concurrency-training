package switchingInsideBlocks;

import java.util.concurrent.CountDownLatch;

public class Main {

    volatile int v1 = 0;
    volatile int v2 = 0;
    CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) {
        new Main().startThreads();
    }

    void startThreads()
    {
        new SetterThread().start();
        new CheckerThread().start();
    }

    class SetterThread extends Thread
    {
        @Override
        public void run(){
            countDownLatch.countDown();
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 100; i++) {
                v2 = i;
                v1 = i;
                System.out.println(i);
            }
        }
    }

    class CheckerThread extends Thread
    {
        @Override
        public void run(){
            countDownLatch.countDown();
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 100; i++) {
                System.out.println(v1 == v2);
            }
        }
    }
}
