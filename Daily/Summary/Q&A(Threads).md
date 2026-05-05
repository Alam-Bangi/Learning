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