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