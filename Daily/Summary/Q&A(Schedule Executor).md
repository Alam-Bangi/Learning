```
1. What is ScheduledExecutorService?
    ScheduledExecutorService is an interface used to:
    schedule tasks after delay
    execute periodic tasks
    It extends:
    ExecutorService

2. Which package contains it?
    import java.util.concurrent.*;

3. Why do we use ScheduledExecutorService?
    To:
        execute delayed tasks
        run recurring background jobs
        replace old Timer
    Examples:
        cache cleanup
        heartbeat monitoring
        cron-like tasks
        retry systems

4. How do we create it?
    Usually:
    ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(2);

5. Which class implements it internally?
    ScheduledThreadPoolExecutor

6. What does newScheduledThreadPool(2) mean?
    Pool contains:
    2 worker threads
    At most:
    2 scheduled tasks run simultaneously

7. Which interface hierarchy does it follow?
    Executor
    ↓
    ExecutorService
    ↓
    ScheduledExecutorService

8. Main methods in ScheduledExecutorService?
Method	                    Purpose
schedule()	                execute once after delay
scheduleAtFixedRate()	    repeated execution at fixed rate
scheduleWithFixedDelay()	repeated execution with delay

9. What does schedule() do?
    Executes task once after delay.
    Example:
    scheduler.schedule(task, 5, TimeUnit.SECONDS);

10. Syntax of schedule()?
    schedule(task, delay, unit)

11. Example of schedule()?
    scheduler.schedule(() -> {
        System.out.println("Hello");
    }, 3, TimeUnit.SECONDS);

12. What does scheduleAtFixedRate() do?
    Executes repeatedly at fixed intervals.
    Example:
    scheduler.scheduleAtFixedRate(
        task,
        1,
        5,
        TimeUnit.SECONDS
    );

13. Meaning of parameters?
    (task, initialDelay, period, unit)
    Means:
    wait initially
    execute repeatedly every period

14. What does scheduleWithFixedDelay() do?
    Executes repeatedly with delay AFTER previous execution finishes.
    Example:
    scheduler.scheduleWithFixedDelay(
        task,
        1,
        3,
        TimeUnit.SECONDS
    );

15. Difference between fixed rate and fixed delay?
Fixed Rate	            Fixed Delay
based on start time	    based on completion
maintains schedule	    waits after completion
can drift under load	safer for long tasks

16. Which queue is used internally?
    DelayedWorkQueue

17. What is DelayedWorkQueue?
    A queue that:
    stores scheduled tasks
    releases tasks only after delay expires

18. Does it reuse threads?
    Yes.
    Worker threads are reused.

19. Can multiple scheduled tasks run simultaneously?
    Yes.
    Depends on:
    pool size

20. What happens if pool size = 1?
    Tasks execute sequentially.

21. Example of pool size 1?
    Executors.newScheduledThreadPool(1);
    Only one task executes at a time.

22. What happens if task execution is slow?
    Slow tasks may:
    delay other scheduled tasks
    reduce timing accuracy

23. Does scheduleAtFixedRate() overlap same task executions?
    No.
    Same periodic task does not overlap itself.

24. What happens if periodic task throws exception?
    Future executions stop.
    Very important interview point.

25. Example?
    scheduler.scheduleAtFixedRate(() -> {
        throw new RuntimeException();
    }, 0, 1, TimeUnit.SECONDS);
    Runs once then stops.

26. Best practice for periodic tasks?
    Always handle exceptions:
    try {
    // logic
    } catch(Exception e) {
    e.printStackTrace();
    }

27. Is timing perfectly accurate?
    No.
    Depends on:
    OS scheduler
    CPU load
    JVM pauses
    garbage collection

28. What is scheduling drift?
    When actual execution time differs from expected timing.

29. Why does scheduling drift happen?
    Reasons:
    long tasks
    GC pause
    thread starvation
    CPU contention

30. Which is safer in production?
    Usually:
    scheduleWithFixedDelay()
    because it provides natural backpressure.

31. Why is fixed delay safer?
    Because:
    next execution waits for previous completion
    Avoids aggressive catch-up behavior.

32. What happens after shutdown()?
    Scheduler:
    stops accepting new tasks
    executes already submitted tasks

33. Difference between shutdown() and shutdownNow()?
Method	        Behavior
shutdown()	    graceful stop
shutdownNow()	attempts immediate stop

34. Can scheduled tasks be cancelled?
    Yes.
    Using:
    ScheduledFuture.cancel()

35. What is ScheduledFuture?
    Represents:
    scheduled task
    task result
    cancellation control

36. Example of cancellation?
    ScheduledFuture<?> future =
        scheduler.schedule(task, 10, TimeUnit.SECONDS);
    future.cancel(true);

37. Does it support Callable?
    Yes.
    Example:
    scheduler.schedule(callableTask,
                    5,
                    TimeUnit.SECONDS);

38. Can it return values?
    Yes.
    Using:
    Future.get()

39. What are common use cases?
    periodic monitoring
    cleanup jobs
    token refresh
    cache refresh
    retry systems
    heartbeat tasks

40. Why is it better than Timer?
    Advantages:
    multiple threads
    better scalability
    exception isolation
    flexible scheduling

41. What is a hidden production problem?
    Scheduler starvation.
    If:
    pool too small
    tasks too slow
    then scheduled timings become inaccurate.

42. Another hidden issue?
    Cancelled tasks may remain in queue.
    Fix:
    setRemoveOnCancelPolicy(true)

43. Should scheduler threads perform blocking work?
    Avoid it.
    Blocking calls:
    reduce scheduler accuracy
    delay other tasks

44. Better architecture?
    Scheduler should:
    trigger jobs
    delegate heavy work elsewhere

45. Internal execution flow?
    Task submitted
    ↓
    Stored in DelayedWorkQueue
    ↓
    Delay expires
    ↓
    Worker thread executes task
    ↓
    Thread reused

46. Main advantages?
    Advantages:
    delayed execution
    periodic execution
    reusable threads
    scalable scheduling

47. Main disadvantages?
    Disadvantages:
    timing drift
    starvation risk
    poor handling of blocking tasks
    possible backlog growth

48. Interview trap question
Which is better?
    scheduleAtFixedRate() OR scheduleWithFixedDelay()
    Correct answer:
    depends on use case

49. Production recommendation?
    Use:
    scheduleWithFixedDelay() for:
        cleanup
        retries
        maintenance
    scheduleAtFixedRate() for:
        metrics
        clocks
        heartbeat

50. One-line interview definition
    ScheduledExecutorService is a concurrency framework interface that schedules delayed and periodic task execution using reusable worker threads.
```
### Example Code
```
import java.util.concurrent.*;

public class ScheduledExecutorFullDemo {

    public static void main(String[] args) {

        ScheduledExecutorService scheduler =
                Executors.newScheduledThreadPool(3);

        // 1. One-time delayed task (e.g., retry API call)
        scheduler.schedule(() -> {

            System.out.println("🔁 Retrying failed API call at: "
                    + System.currentTimeMillis());

        }, 5, TimeUnit.SECONDS);


        // 2. Fixed Rate task (e.g., heartbeat / monitoring)
        scheduler.scheduleAtFixedRate(() -> {

            System.out.println("💓 Heartbeat sent at: "
                    + System.currentTimeMillis());

        }, 0, 3, TimeUnit.SECONDS);


        // 3. Fixed Delay task (e.g., cache cleanup / batch job)
        scheduler.scheduleWithFixedDelay(() -> {

            System.out.println("🧹 Cleaning cache at: "
                    + System.currentTimeMillis());

            try {
                Thread.sleep(2000); // simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, 0, 5, TimeUnit.SECONDS);


        // 4. Graceful shutdown after some time (demo purpose)
        scheduler.schedule(() -> {

            System.out.println("🛑 Shutting down scheduler...");
            scheduler.shutdown();

        }, 30, TimeUnit.SECONDS);
    }
}
```