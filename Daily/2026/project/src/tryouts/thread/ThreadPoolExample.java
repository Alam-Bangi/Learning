package tryouts.thread;

import java.util.concurrent.*;

public class ThreadPoolExample {

    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,                      // Core pool size
                4,                      // Maximum pool size
                60,                     // Keep-alive time
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10)
        );

        // Submit some tasks
        for (int i = 1; i <= 6; i++) {
            final int taskNumber = i;

            executor.submit(() -> {
                System.out.println(
                        "Task " + taskNumber +
                        " running on " +
                        Thread.currentThread().getName()
                );

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                System.out.println("Task " + taskNumber + " completed");
            });
        }

        // Give tasks a moment to start
        Thread.sleep(500);

        // Monitor the ThreadPoolExecutor
        System.out.println("\n--- Thread Pool Statistics ---");

        System.out.println("Pool Size: "
                + executor.getPoolSize());

        System.out.println("Active Count: "
                + executor.getActiveCount());

        System.out.println("Core Pool Size: "
                + executor.getCorePoolSize());

        System.out.println("Maximum Pool Size: "
                + executor.getMaximumPoolSize());

        System.out.println("Queue Size: "
                + executor.getQueue().size());

        System.out.println("Task Count: "
                + executor.getTaskCount());

        System.out.println("Completed Task Count: "
                + executor.getCompletedTaskCount());

        // Stop accepting new tasks
        executor.shutdown();

        // Wait for existing tasks to finish
        executor.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("\n--- Final Statistics ---");

        System.out.println("Pool Size: "
                + executor.getPoolSize());

        System.out.println("Task Count: "
                + executor.getTaskCount());

        System.out.println("Completed Task Count: "
                + executor.getCompletedTaskCount());
    }
}