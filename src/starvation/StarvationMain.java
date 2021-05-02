package starvation;

public class StarvationMain extends Thread{
// Java program to illustrate Starvation concept
    static int threadcount = 1;

    public void run()
    {
        System.out.println(threadcount + "st Child" +
                " Thread execution starts");

        for (int i = 0; i < 1000; i++) {
            int beta = 42;
        }

        threadcount++;

        System.out.println("Child thread execution completes");
    }

    public static void main(String[] args)
            throws InterruptedException
    {
        System.out.println("Main thread execution starts");

        // Thread priorities are set in a way that thread5
        // gets least priority.
        StarvationMain thread1 = new StarvationMain();
        thread1.setPriority(10);
        StarvationMain thread2 = new StarvationMain();
        thread2.setPriority(9);
        StarvationMain thread3 = new StarvationMain();
        thread3.setPriority(8);
        StarvationMain thread4 = new StarvationMain();
        thread4.setPriority(1);
        StarvationMain thread5 = new StarvationMain();
        thread5.setPriority(1);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        // Here thread5 have to wait because of the
        // other thread. But after waiting for some
        // interval, thread5 will get the chance of
        // execution. It is known as Starvation

        thread5.start();

        System.out.println("Main thread execution completes");
    }
}
