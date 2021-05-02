package textart;

public class ArtistThread implements Runnable
{
    private int printCount;

    @Override
    public void run() {
        while (!Thread.interrupted())
        {
            if (TextArt.printed)
            {
                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread().getName() + ": " + printCount);
                return;
            }

            //printLine();
            printCharacter();
            printCount++;

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void printLine()
    {
        synchronized (ArtistThread.class)
        {
            String nextLine = TextArt.getNextLine();
            System.out.println(Thread.currentThread().getName() + " " + nextLine);
        }
    }

    void printCharacter()
    {
        synchronized (ArtistThread.class)
        {
            String charToPrint = TextArt.getNextCharacter();
            System.out.print(charToPrint);
        }
    }
}
