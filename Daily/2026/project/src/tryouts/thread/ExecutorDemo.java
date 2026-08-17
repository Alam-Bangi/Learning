package tryouts.thread;

import java.util.concurrent.*;

public class ExecutorDemo {
    public static void main(String[] args) throws Exception {

//         1. Single Thread - Executes only one thread at a time
        ExecutorService single = Executors.newSingleThreadExecutor();

        single.submit(() -> { System.out.println("newSingleThreadExecutor - Task 1"); });
        single.submit(() -> { System.out.println("newSingleThreadExecutor - Task 2"); });

        single.shutdown();


//        2. Fixed Thread Pool - Executes fixed number of threads at a time
//        if threads are more than fixed threads then other threads are executed after a thread in pool gets free
        ExecutorService fixed = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            int task = i;
            fixed.submit(() -> { System.out.println("newFixedThreadPool -  " + task + " - " +
                    Thread.currentThread().getName());
            });
        }

        fixed.shutdown();

//         3. Cached Thread Pool - Creates threads when needed and reuses idle threads.
        ExecutorService cached = Executors.newCachedThreadPool();

        for (int i = 1; i <= 5; i++) {
            int task = i;
            cached.submit(() -> { System.out.println("newCachedThreadPool - "+ task); });
        }

        cached.shutdown();

//         4. Scheduled Thread Pool - Schedules a thread to be executed
//        runs a threads after defined time period
        ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(2);

        scheduled.schedule(() -> { System.out.println("newScheduledThreadPool - Run after 3 seconds"); }, 3, TimeUnit.SECONDS);

//         Run every 2 seconds
        scheduled.scheduleAtFixedRate(() -> { System.out.println("newScheduledThreadPool.fixedRate - Running every 2 seconds"); }, 0, 2, TimeUnit.SECONDS);

//         Let scheduled tasks run for 7 seconds
        Thread.sleep(7000);

        scheduled.shutdown();

//         5. Single Scheduled Thread - executes a single thread after scheduled time
        ScheduledExecutorService singleScheduled = Executors.newSingleThreadScheduledExecutor();

        singleScheduled.schedule(() -> { System.out.println("newSingleThreadScheduledExecutor - Single scheduled task"); }, 2, TimeUnit.SECONDS);

        Thread.sleep(3000);

        singleScheduled.shutdown();
    }
}