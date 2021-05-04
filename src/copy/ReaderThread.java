package copy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderThread implements Runnable{

    private final Buffer buffer;
    private final String destinationFilePath;

    public ReaderThread(String destinationPath, Buffer buffer)
    {
        this.buffer = buffer;
        this.destinationFilePath = destinationPath;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted())
        {
            String fromBuffer = buffer.readFromBuffer();
            if (fromBuffer != null)
                System.out.print(fromBuffer);
        }
    }
}
