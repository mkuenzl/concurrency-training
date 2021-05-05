/*
* Author Sir Clexalot, 2021
*/

package textart;

public class ArtistThread implements Runnable
{
    private final TextArt textArt;

    public ArtistThread(TextArt textArt){
        this.textArt = textArt;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted())
        {
            if (textArt.isDone())
            {
                break;
            }

            printCharacter();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    void printCharacter()
    {
        synchronized (textArt)
        {
            char nextCharacter = textArt.getNextCharacter();
            System.out.print(nextCharacter);
        }
    }
}
