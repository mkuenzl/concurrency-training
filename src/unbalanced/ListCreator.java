package unbalanced;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ListCreator
{
    private ListCreator(){};

    public static List<Integer> buildRandomList(int size)
    {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int random = ThreadLocalRandom.current().nextInt(1, 1000+1);
            numbers.add(random);
        }

        return numbers;
    }
}
