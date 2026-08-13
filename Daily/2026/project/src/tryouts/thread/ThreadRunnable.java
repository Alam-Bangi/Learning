package tryouts.thread;

class OrderTask implements Runnable {
    private String taskName;

    OrderTask(String taskName) {
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