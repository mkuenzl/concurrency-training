package copy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class WriterThread implements Runnable
{
    private final Buffer buffer;
    private final File targetFile;

    public WriterThread(String pathToFile, Buffer buffer)
    {
        this.buffer = buffer;
        this.targetFile = new File(pathToFile);
    }

    private void writeLine(String line)
    {
        char[] chars = line.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            buffer.writeToBuffer(String.valueOf(chars[i]));
        }
        buffer.writeToBuffer("\n");
    }

    @Override
    public void run()
    {
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(targetFile);
            br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null)
            {
                writeLine(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null)
            {
                try {
                    fr.close();
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
