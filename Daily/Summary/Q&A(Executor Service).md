```
🔹 Q1: What is a Thread in Java?
    Answer:
    A thread is the smallest unit of execution within a process. Java allows multiple threads to run concurrently to improve CPU utilization.

🔹 Q2: What is Multithreading?
    Answer:
    Multithreading is the concurrent execution of two or more threads to maximize CPU usage.

🔹 Q3: Why use multithreading?
    Better performance
    Efficient CPU utilization
    Parallel task execution
    Responsive applications (UI, servers)

🔹 Q4: How to create a thread in Java?
1. Extending Thread class
    class MyThread extends Thread {
        public void run() {
            System.out.println("Thread running");
        }
    }
2. Implementing Runnable
    class MyTask implements Runnable {
        public void run() {
            System.out.println("Task running");
        }
    }

    👉 Preferred: Runnable (better design)

🔹 Q5: Difference between Runnable and Thread?
Thread	                        Runnable
Class	                        Interface
Cannot extend another class	    Can extend other classes
Tight coupling	                Loose coupling

🔹 Q6: What is Thread lifecycle?
    States:
    New
    Runnable
    Running
    Waiting/Blocked
    Terminated

🔹 Q7: Difference between start() and run()?
    👉 Trick question
    start() → creates new thread
    run() → executes like normal method

🔹 Q8: What is Thread Scheduler?
    Answer:
    Part of JVM that decides which thread runs. Uses priority and OS scheduling.

🔹 Q9: What is Thread Priority?
    Range: 1 to 10
    Default: 5
    👉 But not guaranteed execution order

🔹 Q10: What is sleep() method?
    Thread.sleep(1000);
    Pauses thread execution
    Does NOT release lock

🔹 Q11: What is join()?
    t1.join();
    Waits for thread to finish

🔹 Q12: What is yield()?
    Hints scheduler to give chance to other threads
    Not guaranteed

🔹 Q13: What is daemon thread?
    Background thread
    JVM exits when only daemon threads remain
    t.setDaemon(true);

🔹 Q14: What is synchronization?
    Answer:
    Mechanism to control access to shared resources.
    synchronized void method() {}

🔹 Q15: What is race condition?
    Multiple threads access shared data
    Result depends on execution order

🔹 Q16: What is deadlock?
    👉 Two threads waiting for each other forever

🔹 Q17: What is inter-thread communication?
    Methods:
    wait()
    notify()
    notifyAll()

🔹 Q18: Difference between wait() and sleep()?
wait()	            sleep()
Releases lock	    Does not release lock
Used in sync block	Anywhere

🔹 Q19: What is volatile keyword?
    Ensures variable visibility across threads
    Prevents caching issues

🔹 Q20: What is thread safety?
    Code that works correctly in multithreaded environment

🔹 Q21: What is synchronized block vs method?
    synchronized(this) {}
    Block → specific section
    Method → entire method

🔹 Q22: What is Reentrant Lock?
    From java.util.concurrent.locks
    Advanced alternative to synchronized
    More control (tryLock, fairness)

🔹 Q23: What is ThreadLocal?
    Creates thread-specific variables
    Each thread has its own copy

🔹 Q24: What is context switching?
    CPU switching between threads
    Has overhead

🔹 Q25: What is starvation?
    Thread never gets CPU time

🔹 Q26: What is livelock?
    Threads active but not progressing

🔹 Q27: What is blocking vs non-blocking?
    Blocking → thread waits
    Non-blocking → continues execution

🔹 Q28: What is Executor framework?
    From java.util.concurrent
    Manages thread pools
    Simplifies multithreading

🔹 Q29: What is atomic operation?
    Executed completely or not at all
    No interruption
    Example:
    AtomicInteger count = new AtomicInteger(0);

🔹 Q30: What is CAS (Compare And Swap)?
    Lock-free technique
    Used in atomic classes

🔥 Tricky / Advanced Questions

🔥 Q31: Why is String immutable helpful in multithreading?
    Thread-safe by default

🔥 Q32: Why is HashMap not thread-safe?
    Can cause infinite loop during resize
    👉 Use:
    ConcurrentHashMap

🔥 Q33: What happens if two threads call synchronized method?
    One waits until other finishes

🔥 Q34: Can we synchronize constructor?
    ❌ No

🔥 Q35: Can static methods be synchronized?
    ✔️ Yes (locks class object)

🔥 Q36: What is double-checked locking?
    Used in Singleton:
    if (instance == null) {
        synchronized (Class.class) {
            if (instance == null) {
                instance = new Class();
            }
        }
    }

🔥 Q37: What is happens-before relationship?
    Guarantees memory visibility

🔥 Q38: Why not stop() method?
    Unsafe, deprecated

🔥 Q39: Difference between synchronized and volatile?
synchronized	    volatile
Locking	            No locking
Mutual exclusion	Only visibility

🔥 Q40: What is ForkJoin framework?
    Parallel processing using divide & conquer

💡 Best Practices
    Avoid shared mutable data
    Prefer immutable objects
    Use thread pools instead of manual threads
    Always handle exceptions
    Avoid deadlocks (lock ordering)

🎯 Mini Example
    class Counter {
        private int count = 0;

        public synchronized void increment() {
            count++;
        }
    }
```
# newCachedThreadPool
```
1. What is newCachedThreadPool()?
    newCachedThreadPool() creates a thread pool that:
        creates new threads when needed
        reuses idle threads
        removes idle threads after 60 seconds
    ExecutorService executor =
            Executors.newCachedThreadPool();

2. Which class provides newCachedThreadPool()?
    Executors class.
    Executors.newCachedThreadPool();

3. What is the return type?
    ExecutorService

4. What is the internal implementation?
    Internally:
        new ThreadPoolExecutor(
            0,
            Integer.MAX_VALUE,
            60L,
            TimeUnit.SECONDS,
            new SynchronousQueue<Runnable>()
        );

5. Why is it called a “cached” thread pool?
    Because idle threads are cached/reused for future tasks instead of creating new threads every time.

6. What is the core pool size?
    0
    Initially no threads exist.

7. What is the maximum pool size?
    Integer.MAX_VALUE
    Meaning:
    theoretically unlimited threads

8. Which queue does it use internally?
    SynchronousQueue

9. What is SynchronousQueue?
    A queue that:
        does not store tasks
        directly hands tasks to threads
    If no free thread exists:
        new thread is created

10. Does newCachedThreadPool() queue tasks?
    No.
    Tasks are either:
    immediately assigned to idle thread
    OR
    new thread is created

11. When does it create new threads?
    When:
        a task arrives
        no idle thread is available

12. When are threads removed?
    Idle threads are removed after:
    60 seconds

13. What are the advantages of cached thread pool?
    Advantages:
        automatic scaling
        thread reuse
        good for short async tasks
        improves performance

14. What are the disadvantages?
    Disadvantages:
        unlimited thread creation
        high memory usage
        CPU overload risk
        possible OutOfMemoryError

15. Why is it considered risky in production?
    Because:
    maxPoolSize = Integer.MAX_VALUE
    Heavy load can create thousands of threads.

16. What type of tasks are suitable?
    Suitable for:
        short-lived
        lightweight
        non-blocking tasks
    Examples:
        API calls
        quick background jobs

17. What type of tasks are NOT suitable?
    Avoid for:
        database waits
        file IO
        blocking operations
        long-running tasks

18. Difference between cached pool and fixed pool?
Cached Pool	            Fixed Pool
dynamic threads	        fixed thread count
no task queue	        uses queue
unlimited max threads	limited threads
scalable	            controlled

19. What happens if all threads are busy?
    Cached pool:
        creates new thread immediately
    Fixed pool:
        queues task

20. Why does cached pool perform well for small tasks?
    Because threads are reused instead of recreated.

21. Can thread count shrink automatically?
    Yes.
    Idle threads terminate after 60 seconds.

22. Is execution order guaranteed?
    No.
    Tasks execute concurrently.

23. What happens after shutdown()?
    Pool:
        stops accepting new tasks
        completes submitted tasks

24. Difference between shutdown() and shutdownNow()?
    shutdown()
        Graceful shutdown.
        executor.shutdown();
    shutdownNow()
        Attempts immediate stop.
        executor.shutdownNow();

25. What happens if tasks are very fast?
    Same thread may execute many tasks because it becomes idle quickly.

26. What happens if tasks contain Thread.sleep()?
    Threads stay busy longer.
    Pool creates additional threads.

27. Can newCachedThreadPool() create memory issues?
    Yes.
    Too many threads consume:
    stack memory
    CPU resources

28. What exception can occur under heavy load?
    OutOfMemoryError

29. What is the main purpose of cached thread pool?
    To handle:
    many short asynchronous tasks efficiently

30. What is the lifecycle of a thread in cached pool?
    Task arrives
    ↓
    Reuse idle thread?
    ↓ yes → execute
    ↓ no
    Create new thread
    ↓
    Task completes
    ↓
    Thread becomes idle
    ↓
    Idle for 60 sec
    ↓
    Thread destroyed

Most Important Interview Answer
    newCachedThreadPool() is a dynamically scalable thread pool that creates threads as needed, reuses idle threads, uses SynchronousQueue internally, and removes idle threads after 60 seconds. It is efficient for short-lived asynchronous tasks but risky for long blocking workloads because it allows unlimited thread creation.
```
# newScheduledThreadPool
```
1. What is newScheduledThreadPool()?
    newScheduledThreadPool() creates a thread pool that can:
    execute tasks after a delay
    execute tasks periodically
    ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(2);

2. Which package contains it?
    import java.util.concurrent.*;

3. Which class provides this method?
    Executors

4. What is the return type?
    ScheduledExecutorService

5. Why do we use newScheduledThreadPool()?
    To:
    schedule delayed tasks
    execute recurring tasks
    replace old Timer class

6. What is the syntax?
    ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(3);

7. What does the number represent?
    newScheduledThreadPool(3)
    means:
    pool has 3 worker threads
    At most:
    3 tasks can run simultaneously

8. Internal implementation?
    Internally uses:
    ScheduledThreadPoolExecutor

9. Main methods supported?
Method	                    Purpose
schedule()	                execute once after delay
scheduleAtFixedRate()	    periodic execution
scheduleWithFixedDelay()	periodic execution with delay after completion

10. What does schedule() do?
    Runs task once after delay.
    Example:
    scheduler.schedule(task, 5, TimeUnit.SECONDS);

11. What does scheduleAtFixedRate() do?
    Runs task repeatedly at fixed intervals.
    Example:
    scheduler.scheduleAtFixedRate(
        task,
        1,
        3,
        TimeUnit.SECONDS
    );

12. Meaning of parameters in scheduleAtFixedRate()?
    (task, initialDelay, period, unit)
    Example:
    (task, 1, 3, SECONDS)
    Means:
    wait 1 sec initially
    execute every 3 sec

13. What does scheduleWithFixedDelay() do?
    Runs repeatedly after previous execution finishes.
    Example:
    scheduler.scheduleWithFixedDelay(
        task,
        1,
        3,
        TimeUnit.SECONDS
    );

14. Difference between fixed rate and fixed delay?
Fixed Rate	                Fixed Delay
based on start time	        based on completion time
maintains constant rate	    waits after task completion
suitable for timers	        suitable for background jobs

15. Explain fixed rate visually.
    0s   3s   6s   9s
    |----|----|----|
    Start Start Start

16. Explain fixed delay visually.
    Start -> Finish -> wait -> Start

17. What queue does scheduled pool use internally?
    DelayedWorkQueue

18. What is DelayedWorkQueue?
    A special queue that:
    stores delayed tasks
    releases tasks only after delay expires

19. Does it reuse threads?
    Yes.
    Worker threads are reused.

20. Can multiple tasks run simultaneously?
    Yes.
    Depends on pool size.

21. What happens if pool size is 1?
    Tasks execute sequentially.
    Example:
    Executors.newScheduledThreadPool(1)

22. What happens if task execution takes longer than period in fixed rate?
    Next execution may start immediately after previous one finishes.
    Scheduler tries maintaining timing.

23. Does scheduleAtFixedRate() overlap executions?
    No for same task instance.
    If one execution is still running:
    next execution waits

24. Best use cases?
    cron jobs
    heartbeat systems
    periodic monitoring
    cleanup tasks
    retries
    cache refresh

25. Why is it better than Timer?
    Advantages over Timer:
    multiple threads
    better exception handling
    more flexible
    improved scalability

26. What happens if scheduled task throws exception?
    Periodic execution may stop.

27. Best practice for exceptions?
    Handle exceptions inside task.
    Example:
    try {
    // logic
    } catch(Exception e) {
    e.printStackTrace();
    }

28. What happens after shutdown()?
    Pool:
    stops accepting new tasks
    completes existing tasks

29. Difference between shutdown() and shutdownNow()?
Method	        Behavior
shutdown()	    graceful stop
shutdownNow()	immediate stop attempt

30. Can delayed tasks still execute after shutdown?
    Yes, already submitted tasks may execute.

31. Is task execution order guaranteed?
    No.
    Depends on thread scheduling.

32. Can scheduled tasks be cancelled?
    Yes.
    Using:
    ScheduledFuture.cancel()

33. Example of cancellation?
    ScheduledFuture<?> future =
        scheduler.schedule(task, 10, TimeUnit.SECONDS);
    future.cancel(true);

34. What does ScheduledFuture represent?
Represents:
    delayed task result
    task status
    cancellation control

35. Does scheduled pool support Callable?
    Yes.
    Example:
    scheduler.schedule(callableTask,
                    5,
                    TimeUnit.SECONDS);

36. Can we get return values?
    Yes.
    Using:
    Future.get()

37. Is newScheduledThreadPool() thread-safe?
    Yes.
    It is designed for concurrent use.

38. What is the internal lifecycle?
    Task submitted
    ↓
    Stored in delayed queue
    ↓
    Delay expires
    ↓
    Thread picked from pool
    ↓
    Task executes
    ↓
    Thread reused

39. What are advantages?
    Advantages:
        delayed execution
        periodic execution
        reusable threads
        scalable
        flexible scheduling

40. What are disadvantages?
    Disadvantages:
        bad configuration may delay tasks
        long-running tasks can block threads
        exceptions may stop recurring tasks

41. Difference between newCachedThreadPool() and newScheduledThreadPool()?
Cached Pool	                Scheduled Pool
executes immediately	    supports delayed execution
dynamic thread creation	    scheduled execution
no scheduling support	    periodic scheduling support

42. Difference between ExecutorService and ScheduledExecutorService?
ExecutorService	        ScheduledExecutorService
executes tasks	        executes scheduled tasks
no delay support	    delay support
no periodic support	    periodic support

43. Main interview keywords
Important keywords:
    delayed execution
    periodic execution
    reusable worker threads
    delayed queue
    fixed rate
    fixed delay
    scheduler

44. One-line interview definition
    newScheduledThreadPool() creates a thread pool capable of executing tasks after a delay or periodically using reusable worker threads.
```
