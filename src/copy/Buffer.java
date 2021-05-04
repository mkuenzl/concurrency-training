package copy;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class Buffer {
    public LinkedList<String> queue;
    public AtomicInteger counter;

    public Buffer()
    {
        this.queue = new LinkedList();
        this.counter = new AtomicInteger(0);
    }

    public void writeToBuffer(String data)
    {
        queue.offer(data);
        incrementCounter();
    }

    public String readFromBuffer()
    {
        String data = queue.poll();
        decrementCounter();
        return data;
    }

    private void incrementCounter()
    {
        counter.incrementAndGet();
    }

    private void decrementCounter()
    {
        counter.decrementAndGet();
    }

    public Boolean isEmpty()
    {
        int condition = counter.get();
        if (condition <= 0)
        {
            return true;
        }
        return false;
    }

    public void print() {
        while (!queue.isEmpty())
        {
            System.out.print(queue.remove());
        }
    }
}