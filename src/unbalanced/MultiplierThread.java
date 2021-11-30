package unbalanced;

import java.util.List;

public class MultiplierThread implements Runnable
{
    private List<Integer> numbers;

    public MultiplierThread(List<Integer> numbers)
    {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            for (Integer number : numbers) {
                number = number * number;
            }
            break;
        }
    }
}
