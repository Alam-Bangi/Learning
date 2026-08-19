package tryouts.thread;


public class ThreadClass {
    public static void main(String[] args) {
        // Creating threads
        OrderThread orderThread = new OrderThread("Jogging");
        OrderThread paymentThread = new OrderThread("Running");
        OrderThread emailThread = new OrderThread("Walking");

        // Starting threads
        orderThread.start();
        paymentThread.start();
        emailThread.start();

        System.out.println("Main thread is running...");
    }
}