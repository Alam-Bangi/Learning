package tryouts.thread;

class OrderThread extends Thread {
    private String taskName;

    OrderThread(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(taskName + " started");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(taskName + " completed");
    }
}

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