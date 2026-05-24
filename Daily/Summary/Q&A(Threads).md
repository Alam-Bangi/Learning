- [Threads & Concurrency Notes](https://interview.in28minutes.com/interview-guides/java/threads-and-concurrency-in-java/)
```
🧠 Advanced / Rare Java Thread Q&A
🔹 1. Why is Thread.stop() deprecated?
    Because it can leave objects in an inconsistent state.
    👉 If a thread is stopped while updating shared data:
        Half-written data remains
        Locks may not be released properly
    ✔️ Safer alternative:
        Use interrupt() + flag checking

🔹 2. Can start() be called twice on the same thread?
    ❌ No.
    Calling it again throws:
        IllegalThreadStateException
    👉 Reason:
        A thread is a one-time execution unit.

🔹 3. Does sleep() release the lock?
    ❌ No.
    Even while sleeping:
        Thread keeps the lock
    👉 This is a common mistake:
        People assume other threads can enter synchronized block during sleep.

🔹 4. Does wait() release the lock?
    ✅ Yes.
    👉 Difference:
        sleep() → keeps lock
        wait() → releases lock
    This is crucial in interview questions.

🔹 5. Why must wait() be inside a synchronized block?
    Because:
        It depends on the object’s monitor (lock)
    Without synchronization:
        👉 JVM throws IllegalMonitorStateException

🔹 6. What happens if notify() is called before wait()?
    👉 The signal is lost ❌
    Thread will wait forever.
    ✔️ Solution:
    Use condition checks (while loop)

🔹 7. Why use while instead of if with wait()?
    Because of spurious wakeups.
    👉 Threads can wake up without notify().
    ✔️ Correct pattern:
    synchronized(obj) {
        while(conditionNotMet) {
            obj.wait();
        }
    }

🔹 8. Is volatile enough for thread safety?
    ❌ No.
    It only guarantees:
        visibility
    It does NOT guarantee:
        atomicity
    👉 Example:
        volatile int count;
        count++; // NOT safe

🔹 9. What is false sharing?
    A performance issue where:
    Threads modify different variables
    But those variables share same CPU cache line
    👉 Result:
    Unexpected slowdown

🔹 10. Can two threads execute the same synchronized method at the same time?
    👉 Depends:
    Same object → ❌ No
    Different objects → ✅ Yes
    👉 Lock is tied to object, not method.

🔹 11. Why is double-checked locking tricky?
    Without volatile, it may break due to:
    👉 instruction reordering
    ✔️ Correct:
    private static volatile Instance instance;

🔹 12. What is thread confinement?
    Instead of sharing data:
    👉 Give each thread its own copy
    ✔️ Example:
    Local variables
    ThreadLocal
    👉 Avoids synchronization completely

🔹 13. What is ThreadLocal?
    Provides separate values per thread.
    👉 Even though variable is shared:
    Each thread sees its own copy.

🔹 14. Why is final useful in multithreading?
Because:
    👉 Final fields are guaranteed to be visible after construction
    ✔️ Helps avoid synchronization in some cases

🔹 15. What is happens-before relationship?
    A core rule in Java Memory Model.
    👉 Guarantees visibility:
        If A happens-before B → B sees A’s changes
    Examples:
        start()
        join()
        volatile write → read

🔹 16. Why is synchronized sometimes faster than locks?
    Surprising but true in modern JVMs.
👉 JVM optimizations:
    biased locking
    lightweight locking

🔹 17. What is lock striping?
    Instead of one lock:
    👉 Use multiple locks
    ✔️ Improves concurrency
    Example:
    ConcurrentHashMap

🔹 18. Why avoid creating too many threads?
Because:
    Each thread uses memory (stack)
    Context switching cost is high
👉 Solution:
    Use thread pools

🔹 19. What is priority inversion?
    Low-priority thread holds lock
    High-priority thread waits
    👉 Medium-priority thread runs instead
Result:
    High-priority thread is blocked unexpectedly

🔹 20. What is busy waiting?
        Thread continuously checks condition:
        while(!flag) {}
        ❌ Wastes CPU
    ✔️ Better:
        wait/notify
        blocking queues

🔹 21. Why is interrupt() better than stopping thread?
    Because:
        👉 It allows graceful shutdown
    Thread decides:
        when to stop
        how to clean up

🔹 22. Can a constructor start a thread?
    Technically yes—but ❌ dangerous.
    👉 Reason:
    Object may not be fully constructed when thread runs.

🔹 23. What is safe publication?
        Making object visible to other threads safely.
    ✔️ Ways:
        final fields
        volatile reference
        synchronized block

🔹 24. Why is immutable object thread-safe?
    Because:
        👉 State never changes
    Example:
        String
        No synchronization needed.

🔹 25. Why is System.out.println() thread-safe?
    Because:
    👉 It internally uses synchronization

🔹 26. What is work stealing?
    Used in ForkJoinPool.
    👉 Idle threads steal tasks from busy threads
    ✔️ Improves performance

🔹 27. Why is blocking queue better than wait/notify?
    Because:
    Simpler
    Less error-prone
    Handles synchronization internally

🔹 28. Can a thread run without run()?
    No meaningful execution.
    👉 run() defines task logic.

🔹 29. What is memory consistency error?
    When:
        👉 Threads see different values of same variable
    Caused by:
        caching
        reordering

🔹 30. Why is concurrency hard?
    Because of:
    timing issues
    non-deterministic behavior
    hard-to-reproduce bugs
    👉 Bugs may appear only sometimes → hardest to debug

🔥 Reality Check (What Most People Won’t Tell You)
    Multithreading doesn’t always improve performance
    Poor synchronization can make programs slower than single-threaded
    Most real-world apps use:
    ExecutorService
    Concurrent collections
    NOT raw threads
```
# More Learning
```
Execution Types

Execution Type	    How It Works	                                        Real-World Example
Sequential	        One task at a time	                            Single chef, one dish at a time
Concurrent	        Switches from one task to another when waiting	Chef multitasking (chopping while boiling)
Parallel	        Multiple tasks at the same time	                Multiple chefs cooking different dishes
MIX OF BOTH	        Multiple tasks run at same time. If any tasks	Restaurant with multiple chefs multitasking
                    is waiting, switch to other task immediately.

What if we make use of both Concurrency and Parallelism?
    Multiple CPU cores handle tasks simultaneously (parallelism).
    If a task is waiting, CPU switches to another task (concurrency).
    Best of both worlds!
        Fast execution + Efficient resource usage.

Comparison
Features            	Extend Thread Class	                Implement Runnable Interface
Extend Another Class?	❌ No (Single inheritance limit)	✅ Yes
Recommended?	        ❌ No	✅                         Yes (Preferred approach)

- When should you use Callable instead of Runnable?
    Runnable can’t return values, but Callable can!

- Thread Methods - join() vs sleep() vs yield()
join() – Waiting for a Thread to Finish
    What? Makes one thread wait for another to complete execution before continuing.
    Why? Useful when a thread must complete before another can proceed.
    Overloaded Method? join(time) waits only for a specific time before continuing.
yield() – Suggesting CPU Time Release
    What? Hints to the scheduler that the current thread can pause execution to let other threads run.
    Why? Allows other threads with the same or higher priority to execute first.
    Does the scheduler always listen? No, it’s just a hint, and the scheduler may ignore it.
sleep(ms) – Pausing Execution for Some Time
    What? Puts the current thread to sleep for a given time (milliseconds).
    Why? Useful for delays, avoiding busy-waiting, and simulating real-world delays.
    Throws? InterruptedException if another thread interrupts it while sleeping.

- How to change Thread priority?
    Thread priority determines how important a thread is for CPU scheduling. 
    Priority is represented by an integer value from 1 to 10. 
    Threads with higher priority get preference over lower-priority threads.
    It is a hint to the scheduler but does not guarantee execution order.
Thread.MIN_PRIORITY     1	Lowest priority
Thread.NORM_PRIORITY	5	Default priority
Thread.MAX_PRIORITY	    10	Highest priority

- What is the difference between Operating System Processes and Operating System Threads?
    Process: Full application (e.g., Google Chrome).
    Thread: A smaller unit inside a process (e.g., Each Each Google Chrome Tab).

Feature	    OS Process	                                        OS Thread
Definition	Independent program execution	                    A lightweight process inside a program
Memory	    Each process has its own separate memory space      Shared memory within a process (Threads share memory
            (used by all of its threads)                        with other threads of the same process)
Speed	    Slow to start	                                    Faster to start (comparatively)
Example	    Google Chrome	                                    Each Google Chrome Tab

- What are Virtual Threads?
    Virtual threads run thousands (or millions) of threads on top of a small pool of OS threads.
    You can run millions of lightweight threads without high memory usage.

Advantages
Feature	            Virtual Threads
Memory Usage	    Low
Context Switching	Cheap
Scalability	        Very high

Comparison: Traditional Java Threads vs Virtual Threads
Feature	            Platform Threads	                        Virtual Threads
Thread Creation	    Expensive	                                Very cheap
Max                 Threads	Few thousand	                    Millions
Best Used In	    CPU-Bound Tasks with Low Number of Threads	High concurrency apps (Web servers)

- When to Use Virtual Threads?
    Lots of IO-Bound Tasks – Database queries, API calls, file reads.
    Massive Concurrency – Thousands or millions of tasks (e.g., handling web requests).
    Efficient Resource Usage – No wasted OS threads waiting for IO.
    ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

- # How to choose between different options of creating an ExecutorService?
1. Single Thread Executor
    Executors.newSingleThreadExecutor() creates an executor with a single worker thread that executes 
    submitted tasks sequentially, one at a time.
     ExecutorService executor = Executors.newSingleThreadExecutor();

2. Fixed Thread Pool
    Executors.newFixedThreadPool(int n) creates a thread pool with a fixed number of threads to execute tasks concurrently,
    reusing threads for improved performance.
    ExecutorService executor = Executors.newFixedThreadPool(5);

3. Single Thread Scheduled Executor
    newSingleThreadScheduledExecutor() creates a scheduler with a single background thread that executes tasks sequentially,
    supporting delayed and periodic task execution using scheduling methods.
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        // 1. Run once after 24 hours
        scheduler.schedule(() ->
                System.out.println("Running DB 1 Cleanup Once after 24 hours"), 24, TimeUnit.HOURS);
        // 2. Run every 24 hours (fixed rate)
        scheduler.scheduleAtFixedRate(() ->
                System.out.println("Running DB 2 Cleanup - Every 24 hours"), 0, 24, TimeUnit.HOURS);
        // 3. Run 24 hours 
        //    after previous task ends (fixed delay)
        scheduler.scheduleWithFixedDelay(() ->
                System.out.println("Running DB 3 Cleanup - Every 24 hours"), 0, 24, TimeUnit.HOURS);

4. Scheduled Thread Pool
    Executors.newScheduledThreadPool(int corePoolSize) creates a thread pool that can schedule commands 
    to run after a delay or periodically using a thread pool with configurable number of threads.
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);
        // 1. Run once after 10 seconds
        scheduler.schedule(() ->
                System.out.println("Health Check 1 - One-time after 10 seconds"), 10, TimeUnit.SECONDS);
        // 2. Run every 10 seconds (fixed rate)
        scheduler.scheduleAtFixedRate(() ->
                System.out.println("Health Check 2 - Every 10 seconds"), 0, 10, TimeUnit.SECONDS);
        // 3. Run 10 seconds 
        //    after previous task ends (fixed delay)
        scheduler.scheduleWithFixedDelay(() ->
                System.out.println("Health Check 3 - Every 10 seconds"), 0, 10, TimeUnit.SECONDS);

5. Virtual Thread Per Task Executor
    Creates a new virtual thread per task, ideal for massively concurrent workloads 
    (e.g., handling millions of requests).
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            executor.submit( () -> System.out.println("Running virtual thread task") );
        }

Key Takeaways
Single Thread Executor: Executes tasks one by one using a single thread, ensuring sequential processing. Ideal for logging etc...

Fixed Thread Pool: Uses a fixed number of threads to handle multiple tasks in parallel. Great for managing concurrent workloads like file uploads.

Single Thread Scheduled Executor: Schedules tasks to run after a delay or periodically with one thread. Perfect for serialized tasks like daily database cleanup or report generation.

Scheduled Thread Pool: Runs tasks repeatedly at fixed intervals using multiple threads. Useful for recurring jobs like health checks or system monitoring.

Virtual Thread Per Task Executor: Creates a lightweight virtual thread for each task, enabling massive concurrency.
```
# Advanced Concepts
```
- What is a Race Condition?
    A race condition occurs when two or more threads access shared data at the same time, and the program’s outcome depends on the sequence or timing of their execution.

Race Condition vs Thread Safety
    Race condition: Happens when multiple threads access shared data simultaneously, causing unpredictable results due to timing issues.
    Thread safety: Ensures code behaves correctly when accessed by multiple threads, preventing race conditions.
    Thread-safe code: Uses techniques to control access to shared data. Ensures correct behavior in multithreaded environments.

- Solving Race Conditions in Java
📌 1. Using synchronized methods and blocks
    What does synchronized do?
        synchronized locks the increment() method
        Only one thread can enter increment() at a time
        Prevents two threads from changing count together
        Ensures thread-safe update of shared variable
    What are the problems with synchronized?
        OLD synchronized collections: A few old Collection classes use synchronized methods
        Example: Vector – Thread-safe version of ArrayList using synchronized methods
    Another Example: Hashtable – Thread-safe version of HashMap
    Example Methods in Vector class:
        public synchronized E get(int index)
        public synchronized E set(int index, E element)
        public synchronized boolean add(E e)
        public synchronized void removeAllElements()
        All of the above example methods are synchronized
    Problem: What is the problem with these synchronized methods?
        They lock the entire object, even for small operations
        Only one thread can access any method at a time
        Other threads must wait, even for simple reads
        Can become a bottleneck when many threads are used

📌 2. ReentrantLock – More Flexible Locking
    What? Explicitly locks and unlocks
    Why? Allows more control
        private ReentrantLock lock = new ReentrantLock();
        public void increment() {
            lock.lock();
            try {
                count++;
            } finally {
                lock.unlock();
            }
        }

📌 3. ReadWriteLock – Optimized Locking for Read-Heavy Operations
    What? Allows multiple readers but only one writer.
    Why? Improves performance in read-heavy applications.
    When? Best when reads are more frequent than writes.
        private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        public void write(int value) {
            lock.writeLock().lock();
            try {
                data = value;
            } finally {
                lock.writeLock().unlock();
            }
        }
        public int read() {
            lock.readLock().lock();
            try {
                return data;
            } finally {
                lock.readLock().unlock();
            }
        }

📌 4. Atomic Variable Classes (AtomicInteger, AtomicBoolean, AtomicLong)
    Atomic operation: Sequence of instructions that executes as a single, indivisible unit (thread-safe)
    What? Provides atomic operations to ensure thread safety.
    When? Best for counters and simple numeric operations
        private AtomicInteger count = new AtomicInteger(0);
        public void increment() {
            count.incrementAndGet(); // Atomic operation 
        }
        public void decrement() {
            count.decrementAndGet(); // Atomic operation 
        }
        public int getCount() {
            return count.get();
        }
Useful Atomic Operation Methods in Typical Atomic Variable Classes
    get() – Reads the current value safely
    set(value) – Updates the value directly
    incrementAndGet() – Adds 1 and returns new value
    getAndIncrement() – Returns current value, then adds 1
    decrementAndGet() – Subtracts 1 and returns new value
    addAndGet(n) – Adds n and returns result
    compareAndSet(expected, newValue) – Updates value only if it matches expected
    getAndSet(newValue) – Replaces with new value and returns old value

📌 5. Concurrent Collections (ConcurrentHashMap,..)
    A few old Collection classes use synchronized
    Example: Vector – Thread-safe version of ArrayList using synchronized methods
    Another Example: Hashtable – Thread-safe version of HashMap
    Example Methods in Vector class
        public synchronized E get(int index)
        public synchronized E set(int index, E element)
        public synchronized boolean add(E e)
        public synchronized void removeAllElements()
    What is the problem with these thread safe methods?
        They lock the entire object, even for small operations
        Only one thread can access any method at a time
        Other threads must wait, even for simple reads
        Can become a bottleneck when many threads are used
    What is the solution?
        Java provides built-in thread-safe high performant concurrent collections.
        These collections are called Concurrent Collections

Examples of Concurrent      Collections
Concurrent Collection	    Replaces
ConcurrentHashMap	        Hashtable / HashMap
CopyOnWriteArrayList	    Vector / ArrayList
ConcurrentLinkedQueue	    LinkedList

📌 Summary

Technique	                Best Used For
synchronized	            Protecting shared resources from concurrent modification.
ReentrantLock	            Fine-grained locking, tryLock() for timeouts.
ReadWriteLock	            Read-heavy applications where writes are rare.
Atomic Variable Classes	    Thread safe numeric operations like counters (AtomicInteger).
Concurrent Collections	    Thread safe high performant collections.

- Synchronized vs Locks
1. synchronized (Simple Version)
    Easy to write
    Blocks all other synchronized methods on the same object
    Good for low-concurrency or simple logic
2. Object Locks (synchronized (lock))
    More fine-grained control
    Allows incrementI() and incrementJ() to run at same time
3. ReentrantLock
    Full control with lock(), unlock(), tryLock(), timeouts
    lock() – Manually lock a critical section
    unlock() – Manually release the lock (always required!)
    tryLock() – Try to get the lock without waiting forever
    tryLock(timeout, unit) – Wait for a while, give up if not acquired
    Great for advanced concurrency needs

- When do you use ThreadLocal?
    What? Each thread gets its own separate instance of a variable.
    Why? Eliminates race conditions because there is no shared data between threads.
    When? Best for caching per-thread data (e.g., user sessions).

- When do you use a Semaphore?
    What? Semaphore allows a limited number of threads to access a resource.
    Why? Prevents too many threads from accessing a shared resource at the same time.
    When? Best for controlling concurrent access to databases or APIs.

- When do you use a CountDownLatch?
    What? A thread waits for a set number of threads to finish before proceeding.
    Why? Prevents race conditions by ensuring dependent tasks complete first.
    When? Best for waiting for multiple tasks to complete before continuing.
        CountDownLatch latch = new CountDownLatch(2);
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new Worker(latch));
            t.start();
        }
        latch.await(); 
        System.out.println("At least 2 workers finished execution.");

- Which Object Methods Are Used for Inter-Thread Communication?
Method	        Description                                         When to Use?
wait()	        Makes a thread wait until another thread 	        When a thread needs to pause execution until some 
                calls notify() or notifyAll().                      condition is met.
notify()	    Wakes up one waiting thread that previously 	    When a thread completes a task and notifies another 
                called wait().                                      thread to continue.
notifyAll()	    Wakes up all threads waiting on the same object.	When multiple threads are waiting, and all need to be resumed.
Note: These methods must be called inside a synchronized block to avoid IllegalMonitorStateException.

Why are these rarely used?
    Requires synchronized - Hard to use and blocks all other synchronized methods/blocks on the same object.
    Risk of Missed Signals – If notify() is called before wait(), the thread may wait forever.
    Better Alternatives Exist – ReentrantLock, Semaphore, CountDownLatch ...

- What is a Deadlock?
    A deadlock occurs when two or more threads wait for each other indefinitely, preventing further execution.
Example: Deadlock Situation
    Thread-1 locks Resource A and waits for Resource B.
    Thread-2 locks Resource B and waits for Resource A.
    Since neither thread can proceed, the program freezes forever (Deadlock!).

- Discuss an option to solve above deadlock
One Option: Lock Resources in the Same Order
    Lock resources in the same order, ensuring a consistent locking hierarchy.
How?
    Sort resources by unique identifiers (e.g., object hash, resource ID).
    Always lock the lower ID first before the higher ID

- Other Options to Prevent or Handle Deadlocks
    Use Try-Lock with Timeout: Replace synchronized with ReentrantLock.tryLock(timeout) to avoid waiting forever. 
    If a lock can’t be acquired within the timeout, retry or exit gracefully.

    Coarse-Grained Locking: Use a single global lock instead of multiple fine-grained ones. 
    This reduces concurrency but guarantees that threads won’t compete for multiple resources simultaneously.

    Avoid Nested Locks: Design code so that threads acquire only one lock at a time. This simple discipline 
    removes the possibility of circular waits and eliminates deadlocks entirely.

- ForkJoinPool
    When? Best for divide-and-conquer tasks like sorting, searching.
    Why? Efficiently splits tasks across multiple CPU cores.
Comparison
Feature	    ExecutorService	                            ForkJoinPool
Best For?	Independent tasks	                        Recursive tasks (divide-and-conquer algorithms)
Example 	Running 100 different tasks in parallel	    Addition of 10 Million numbers

- How can you enhance parallelization of code using Streams?
    Multi-core CPUs: 
        Modern processors have multiple cores for better performance
    Parallelization: 
        Run Multiple Tasks at Same Time (one in each core)
    Functional code can easily be parallelized:
        parallel() or parallelStream(): Enables parallel execution
        .parallel() is useful if you start with sequential stream, then decide to switch to parallel.
        .parallelStream() is cleaner and more direct for starting in parallel.
How does it work?
    Stream is split into multiple parts
    Each part runs on a different core
    Finally, the results are combined

List<Integer> numbers = IntStream.rangeClosed(1, 1_000_000)
             .boxed().collect(Collectors.toList());

long count1 = numbers.stream()
                     .parallel()
                     .filter(n -> n % 2 == 0).count();

long count2 = numbers.parallelStream()
                     .filter(n -> n % 2 == 0).count();
```