package deadlock;

public class DeadLockMain{

    public static void main(String[] args)
    {
        Thread mainThread = Thread.currentThread();
        BlockingThread blockingThread = new BlockingThread(mainThread);

        blockingThread.start();

        try {
            blockingThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Done everything!");
    }
}
