package unbalanced;

import java.util.List;

public class UnbalancedMain {
    public static void main(String[] args)
    {
        int multiplierNumber = 10;

        for (int i = 1; i <= multiplierNumber; i++) {
            int size = i * 100_000;
            List<Integer> randomList = ListCreator.buildRandomList(size);
            MultiplierThread multiplierThread = new MultiplierThread(randomList);
            multiplierThread.run();
        }
    }
}
