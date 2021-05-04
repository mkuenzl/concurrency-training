package textart;

public class Main {
    public static void main(String[] args)
    {
        //TextArt.loadPicture("resources/bart-picture.txt");
        TextArt.loadPicture("resources/woman-picture.txt");

        int artistNumber = 10;

        Thread[] threads = new Thread[artistNumber];
        Object lock = new Object();

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new ArtistThread(lock));
            threads[i].setName("Artist-" + i);
            threads[i].start();
        }

//        for (int j = 0; j < threads.length; j++) {
//            threads[j].interrupt();
//        }
    }
}
