package counting;

public class Main {
    public static void main(String[] args)
    {
        int threadCount = 5;

        Thread upCountingThreads[] = new Thread[threadCount];

        for (int i = 0; i < upCountingThreads.length; i++)
        {
            upCountingThreads[i] = new Thread(new UpCountingThread());
            upCountingThreads[i].setName("UpCounter-" + i);
            upCountingThreads[i].start();
        }

        Thread downCountingThreads[] = new Thread[threadCount];

        for (int i = 0; i < downCountingThreads.length; i++)
        {
            downCountingThreads[i] = new Thread(new DownCountingThread());
            downCountingThreads[i].setName("DownCounter-" + i);
            downCountingThreads[i].start();
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int j = 0; j < threadCount; j++)
        {
            downCountingThreads[j].interrupt();
            upCountingThreads[j].interrupt();
        }
    }
}
