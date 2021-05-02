package counting;

public class DownCountingThread implements Runnable
{
    @Override
    public void run() {
        while(!Thread.interrupted())
        {
            //counter++;
            //System.out.println("The current Thread " + " counter is at: " + counter);
            decreaseCounter();
        }
    }

    private void decreaseCounter() {
        synchronized (DownCountingThread.class)
        {
            Counter.counter--;
            System.out.println("The current Thread " + Thread.currentThread().getName() + " counter is at: " + Counter.counter);
        }
    }
}
