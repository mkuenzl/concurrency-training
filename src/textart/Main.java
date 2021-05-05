/*
 * Author Sir Clexalot, 2021
 */

package textart;

public class Main {
    public static void main(String[] args)
    {
        TextArt textArt = new TextArt("resources/mario-picture.txt");

        int artistNumber = 10;

        Thread[] threads = new Thread[artistNumber];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new ArtistThread(textArt));
            threads[i].setName("Artist-" + i);
            threads[i].start();
        }
    }
}
