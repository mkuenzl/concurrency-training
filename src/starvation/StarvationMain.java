package starvation;

import java.util.concurrent.CountDownLatch;

public class StarvationMain extends Thread{
// Java program to illustrate Starvation concept
    static int threadCount = 10;
    static CountDownLatch latch = new CountDownLatch(threadCount);

    public void run()
    {
//        System.out.println(Thread.currentThread().getName() + " execution starts with priority: " + Thread.currentThread().getPriority());

//        latch.countDown();
//
//        try {
//            latch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        for (int i = 0; i < 100; i++) {
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + " execution completes with priority: " + Thread.currentThread().getPriority());
    }

    public static void main(String[] args)
            throws InterruptedException
    {
        System.out.println("Main thread execution starts");

        // Thread priorities are set in a way that thread5
        // gets least priority.
        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            threads[i] = new StarvationMain();
            threads[i].setPriority((int) (Math.floor(Math.random() * 10) + 1));
            System.out.println(threads[i].getName() + " execution starts with priority: " + threads[i].getPriority());
            threads[i].start();
        }

        System.out.println("Main thread execution completes");
    }
}
