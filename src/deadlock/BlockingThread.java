package deadlock;

public class BlockingThread extends Thread
{
    Thread t;

    public BlockingThread(Thread toWaitFor)
    {
        t = toWaitFor;
    }

    @Override
    public void run()
    {
        System.out.println("Do something!");

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Done something!");
    }
}