package textart;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextArt {

    static List<String> textLines;
    static List<String> textCharacters;
    static int counter = 0;
    static boolean printed = false;

    public static void loadPicture(String fileName)
    {
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);

            textLines = new ArrayList<>();
            textCharacters = new ArrayList<>();

            String line;
            while ((line = br.readLine()) != null)
            {
                textLines.add(line);

                char[] chars = line.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    textCharacters.add(String.valueOf(chars[i]));
                }
                textCharacters.add("\n");
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

    private static void incCounter()
    {
        counter++;
    }

    public static String getNextCharacter()
    {
        String character;

        synchronized (TextArt.class)
        {
            if (counter == textCharacters.size()) {
                printed = true;
                return " ";
            }
            character = textCharacters.get(counter);
        }

        incCounter();
        return character;
    }

    public static String getNextLine()
    {
        if (counter >= textLines.size()) {
            printed = true;
            return " ";
        }
        String lineToPrint = textLines.get(counter);
        incCounter();
        return lineToPrint;
    }
}
