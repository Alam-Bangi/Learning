### Run once after delay
```
import java.util.concurrent.*;

public class ScheduleDemo {

    public static void main(String[] args) {

        ScheduledExecutorService scheduler =
                Executors.newScheduledThreadPool(2);

        System.out.println("Program started");

        scheduler.schedule(() -> {

            System.out.println(
                "Task executed by: " +
                Thread.currentThread().getName()
            );

        }, 5, TimeUnit.SECONDS);

        System.out.println("Task scheduled");

        scheduler.shutdown();
    }
}
```
### scheduleAtFixedRate() — Repeat at Fixed Intervals
```
import java.util.concurrent.*;

public class FixedRateDemo {

    public static void main(String[] args) {

        ScheduledExecutorService scheduler =
                Executors.newScheduledThreadPool(1);

        scheduler.scheduleAtFixedRate(() -> {

            System.out.println(
                "Running at: " +
                System.currentTimeMillis() +
                " by " +
                Thread.currentThread().getName()
            );

        }, 2, 3, TimeUnit.SECONDS);
    }
}
```
### scheduleWithFixedDelay() — Delay After Completion
```
import java.util.concurrent.*;

public class FixedDelayDemo {

    public static void main(String[] args) {

        ScheduledExecutorService scheduler =
                Executors.newScheduledThreadPool(1);

        scheduler.scheduleWithFixedDelay(() -> {

            System.out.println(
                "Started: " +
                System.currentTimeMillis()
            );

            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println(
                "Finished: " +
                System.currentTimeMillis()
            );

        }, 1, 3, TimeUnit.SECONDS);
    }
}
```
### Multiple Threads Demo
```
import java.util.concurrent.*;

public class MultiThreadDemo {

    public static void main(String[] args) {

        ScheduledExecutorService scheduler =
                Executors.newScheduledThreadPool(3);

        for (int i = 1; i <= 5; i++) {

            int taskId = i;

            scheduler.schedule(() -> {

                System.out.println(
                    "Task " + taskId +
                    " executed by " +
                    Thread.currentThread().getName()
                );

            }, 2, TimeUnit.SECONDS);
        }

        scheduler.shutdown();
    }
}
```