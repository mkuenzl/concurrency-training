/*
 * Author Sir Clexalot, 2021
 */

package textart;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextArt {

    private final List<Character> textArtCharacters;
    private int characterPointer = 0;

    public TextArt(String fileName)
    {
        textArtCharacters = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {

            String line;
            while ((line = br.readLine()) != null)
            {
                char[] chars = line.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    textArtCharacters.add(chars[i]);
                }
                textArtCharacters.add('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private final Object pointerLock = new Object();

    private void incrementCharacterPointer()
    {
        synchronized (pointerLock)
        {
            characterPointer++;
        }
    }

    private int getCharacterPointer()
    {
        synchronized (pointerLock)
        {
            return characterPointer;
        }
    }

    public char getNextCharacter()
    {
        if (!isDone()) {
            char character = textArtCharacters.get(getCharacterPointer());
            incrementCharacterPointer();
            return character;
        }
        return '\0';
    }

    public boolean isDone() {
        return getCharacterPointer() >= textArtCharacters.size();
    }
}
