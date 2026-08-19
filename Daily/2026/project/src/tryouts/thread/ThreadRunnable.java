package tryouts.thread;

public class ThreadRunnable {
    public static void main(String[] args) throws InterruptedException {
        // Creating threads
        Thread orderThread = new Thread(new OrderTask("Processing Order"));
        Thread paymentThread = new Thread(new OrderTask("Processing Payment"));
        Thread emailThread = new Thread(new OrderTask("Sending Email"));

        // Starting threads
        orderThread.start();
        paymentThread.join();
        paymentThread.start();
        emailThread.start();

        System.out.println("Main thread is running...");
    }
}