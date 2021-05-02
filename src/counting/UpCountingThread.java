package counting;

public class UpCountingThread implements Runnable
{

    public UpCountingThread() {

    }

    @Override
    public void run() {
        while(!Thread.interrupted())
        {
            //counter++;
            //System.out.println("The current Thread " + " counter is at: " + counter);
            increaseCounter();
        }
    }

//    private synchronized void increaseCounter()
//    {
//        counter++;
//        System.out.println("The current Thread " + " counter is at: " + counter);
//    }

    private void increaseCounter()
    {
        synchronized (UpCountingThread.class)
        {
            Counter.counter++;
            System.out.println("The current Thread " + Thread.currentThread().getName() + " counter is at: " + Counter.counter);
        }
    }
}
