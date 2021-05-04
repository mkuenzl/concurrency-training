package copy;

import java.io.File;

public class CopyMain {

    public static File[] getFilesInFolder(String folderPath)
    {
        File folder = new File(folderPath);
        if(folder.isDirectory())
        {
            return folder.listFiles();
        }
        return null;
    }

    public static void main(String[] args)
    {
        String folder = "/Users/moritzkunzl/Documents/GitHub/kuenzl-concurrency-training/resources";
        File[] filesToCopy = getFilesInFolder(folder);

        Buffer[] buffers = new Buffer[filesToCopy.length];
        Thread[] writingThreads = new Thread[filesToCopy.length];
        Thread[] readingFirstThreads = new Thread[filesToCopy.length];
        Thread[] readingSecondThreads = new Thread[filesToCopy.length];


        for (int i = 0; i < filesToCopy.length; i++) {
            buffers[i] = new Buffer();
            File file = filesToCopy[i];

            String absolutePathOfFileToCopyFrom = file.getAbsolutePath();
            writingThreads[i] = new Thread(new WriterThread(absolutePathOfFileToCopyFrom, buffers[i]));

            String absolutPathOfFileToCopyTo = file.getParent().concat(File.separator).concat(file.getName()).concat("Copy");
            readingFirstThreads[i] = new Thread(new ReaderThread(absolutPathOfFileToCopyTo, buffers[i]));
            readingSecondThreads[i] = new Thread(new ReaderThread(absolutPathOfFileToCopyTo, buffers[i]));

            writingThreads[i].start();
            readingFirstThreads[i].start();
            readingSecondThreads[i].start();

        }

        //Wait some time...
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < filesToCopy.length; i++) {
            readingFirstThreads[i].interrupt();
            readingSecondThreads[i].interrupt();
        }

    }
}
