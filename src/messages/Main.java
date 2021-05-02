package messages;

public class Main {
    public static void main(String[] args) {
        Message message = new Message("hi, this is a notify test");

        Waiter waiter = new Waiter(message);
        Notifier notifier = new Notifier(message);

        new Thread(waiter, "waiter1").start();
        new Thread(waiter, "waiter2").start();

        new Thread(notifier, "notifier").start();

        System.out.println("All threads started.");
    }
}
