## 1. What is a thread in Java?

> “A thread is an independent unit of execution within a process. Multiple threads can execute concurrently and share the same heap memory. Threads are useful for performing multiple tasks concurrently, such as handling requests, background processing, or I/O operations.”

You can add:

> “Because threads share memory, we need synchronization mechanisms when multiple threads access shared mutable data.”

---

## 2. Process vs Thread?

| Process                               | Thread                                        |
| ------------------------------------- | --------------------------------------------- |
| Independent program in execution      | Unit of execution inside a process            |
| Has its own memory space              | Shares process memory                         |
| More expensive to create              | Cheaper to create                             |
| Communication is relatively expensive | Communication is easier through shared memory |
| Failure generally isolated            | A thread failure can affect the process       |

**Interview answer:**

> “A process has its own memory space, while threads within the same process share memory. Threads are lighter and faster to create, but shared memory introduces concurrency problems such as race conditions.”

---

## 3. How do you create a thread in Java?

There are several approaches.

### Extending `Thread`

```java
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Running");
    }
}

MyThread t = new MyThread();
t.start();
```

### Implementing `Runnable`

```java
Runnable task = () -> {
    System.out.println("Running");
};

Thread t = new Thread(task);
t.start();
```

### Using `ExecutorService` — preferred in most applications

```java
ExecutorService executor = Executors.newFixedThreadPool(5);

executor.submit(() -> {
    System.out.println("Running");
});

executor.shutdown();
```

**Interview answer:**

> “Traditionally we can extend `Thread` or implement `Runnable`, but in production code I generally prefer `ExecutorService` because it manages a pool of threads and separates task submission from thread management.”

---

## 4. `Runnable` vs `Callable`?

**`Runnable`:**

* Doesn't return a result.
* Cannot directly throw checked exceptions.

```java
Runnable task = () -> {
    System.out.println("Hello");
};
```

**`Callable`:**

* Returns a result.
* Can throw checked exceptions.
* Usually used with `Future`.

```java
Callable<Integer> task = () -> {
    return 10 + 20;
};

Future<Integer> future = executor.submit(task);

Integer result = future.get();
```

**Interview answer:**

> “Runnable is suitable when I don't need a return value. Callable is useful when the task needs to return a result or throw a checked exception. Callable works with Future to retrieve the result.”

---

## 5. `start()` vs `run()`?

This is a **very common interview question**.

```java
Thread t = new Thread(() -> {
    System.out.println("Hello");
});

t.start();
```

`start()` creates/schedules a new thread, which then executes `run()`.

But:

```java
t.run();
```

is simply a **normal method call**. It does not create a new thread.

**Interview answer:**

> “Calling `start()` causes the JVM to execute the thread's `run()` method on a new thread. Calling `run()` directly just executes the method on the current thread.”

---

# 6. Explain the thread lifecycle.

The important Java `Thread.State` values are:

* `NEW`
* `RUNNABLE`
* `BLOCKED`
* `WAITING`
* `TIMED_WAITING`
* `TERMINATED`

For example:

```text
NEW
 ↓
start()
 ↓
RUNNABLE
 ↓
running
 ↓
TERMINATED
```

A thread can enter `BLOCKED` when waiting to acquire a monitor lock.

It can enter `WAITING` through things such as `Object.wait()` or `Thread.join()` without a timeout.

It can enter `TIMED_WAITING` through things such as:

```java
Thread.sleep(1000);
```

or timed waits.

**Interview answer:**

> “A thread starts in NEW, becomes RUNNABLE after start(), and eventually becomes TERMINATED. During execution it can also enter BLOCKED, WAITING, or TIMED_WAITING depending on locks and waiting operations.”

---

# 7. What is synchronization?

Synchronization controls access to shared resources when multiple threads are involved.

Example:

```java
class Counter {
    private int count;

    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}
```

Without synchronization, multiple threads can interfere with each other.

**Interview answer:**

> “Synchronization ensures that multiple threads don't incorrectly access shared mutable state at the same time. In Java, synchronized provides mutual exclusion and also establishes visibility guarantees between threads.”

---

# 8. What is a race condition?

A race condition occurs when the result depends on the timing/interleaving of multiple threads accessing shared data.

For example:

```java
count++;
```

looks like one operation, but conceptually involves:

```text
read count
add 1
write count
```

Two threads can read the same value and overwrite each other's updates.

Example:

```text
Initial count = 0

Thread A: reads 0
Thread B: reads 0
Thread A: writes 1
Thread B: writes 1

Expected = 2
Actual   = 1
```

**Interview answer:**

> “A race condition occurs when multiple threads access shared mutable state concurrently and the result depends on the timing of their execution. We can prevent it using synchronization, locks, atomic classes, or by avoiding shared mutable state.”

---

# 9. What is `volatile`?

`volatile` primarily provides **visibility** guarantees.

```java
private volatile boolean running = true;
```

If one thread changes:

```java
running = false;
```

other threads reading `running` can observe the updated value according to Java's memory model.

But:

```java
volatile int count;
count++;
```

is **not thread-safe**.

Why?

Because `count++` is a read-modify-write operation.

**Interview answer:**

> “Volatile guarantees visibility of changes to a variable across threads and imposes ordering constraints, but it doesn't make compound operations like `count++` atomic. For atomic updates, I'd use synchronization or an atomic class such as AtomicInteger.”

That's an excellent distinction to make.

---

# 10. `synchronized` vs `Lock`?

### `synchronized`

```java
public synchronized void update() {
    // critical section
}
```

Simple and automatically releases the monitor when leaving the synchronized block/method.

### `Lock`

```java
Lock lock = new ReentrantLock();

lock.lock();

try {
    // critical section
} finally {
    lock.unlock();
}
```

`Lock` gives you additional capabilities such as:

* `tryLock()`
* timed lock acquisition
* interruptible lock acquisition
* more flexible locking strategies

**Interview answer:**

> “Synchronized is simpler and should be my default when its semantics are sufficient. ReentrantLock provides more control, such as tryLock, timed acquisition, and interruptible locking. With explicit locks, I must make sure unlock happens in a finally block.”

---

# 11. What is deadlock?

Deadlock occurs when threads wait indefinitely for resources held by each other.

Example:

```text
Thread A:
locks A
waits for B

Thread B:
locks B
waits for A
```

Neither can proceed.

### How can you prevent it?

* Acquire locks in a consistent order.
* Avoid unnecessary nested locks.
* Use `tryLock()` with timeouts where appropriate.
* Keep critical sections small.

**Interview answer:**

> “Deadlock occurs when two or more threads wait indefinitely for locks held by each other. A common prevention technique is consistent lock ordering. With ReentrantLock, tryLock with a timeout can also help detect or avoid indefinite waiting.”

---

# 12. How do you avoid deadlock?

Suppose:

```java
Thread A: lock(account1) → lock(account2)

Thread B: lock(account2) → lock(account1)
```

Potential deadlock.

Instead, establish an ordering:

```java
lock(lowerAccountId);
lock(higherAccountId);
```

Now every thread acquires locks in the same order.

**Interview answer:**

> “The most straightforward approach is consistent lock ordering. I also try to minimize nested locks, keep lock scopes small, and use timed tryLock when appropriate.”

---

# 13. What is `ExecutorService`?

`ExecutorService` manages a pool of threads and allows you to submit tasks without manually creating threads.

```java
ExecutorService executor =
        Executors.newFixedThreadPool(5);

executor.submit(() -> {
    System.out.println("Task running");
});

executor.shutdown();
```

Instead of:

```java
new Thread(...).start();
new Thread(...).start();
new Thread(...).start();
```

you submit tasks to the executor.

**Interview answer:**

> “ExecutorService separates task submission from thread management. It can maintain a thread pool, queue tasks, execute them, and provide lifecycle management. This is generally preferable to creating a new thread for every task.”

---

# 14. What is a thread pool?

A thread pool maintains a collection of reusable worker threads.

For example:

```java
ExecutorService executor =
    Executors.newFixedThreadPool(10);
```

You might have:

```text
       Tasks
         ↓
     ┌───────┐
     │ Queue │
     └───┬───┘
         ↓
   ┌─────────────┐
   │ Thread Pool │
   │ T1 T2 ...T10│
   └─────────────┘
```

Benefits:

* Avoids repeatedly creating threads.
* Controls concurrency.
* Can improve resource utilization.
* Allows task queuing.

**Interview answer:**

> “A thread pool reuses a fixed or dynamically managed set of worker threads. Instead of creating a thread for every task, tasks are submitted to the pool. This reduces thread-creation overhead and lets us control the amount of concurrency.”

---

# 15. `execute()` vs `submit()`?

Both can submit tasks to an executor.

### `execute()`

```java
executor.execute(() -> {
    System.out.println("Hello");
});
```

Takes a `Runnable` and doesn't return a result.

### `submit()`

```java
Future<?> future = executor.submit(() -> {
    System.out.println("Hello");
});
```

Returns a `Future`.

It can be used to:

* Get the result.
* Check completion.
* Cancel the task.
* Handle exceptions through the `Future`.

**Interview answer:**

> “execute is generally used for fire-and-forget Runnable tasks, while submit returns a Future and supports retrieving results, cancellation, and tracking task completion.”

---

# 16. What are `Future` and `CompletableFuture`?

### Future

A `Future` represents the result of an asynchronous computation.

```java
Future<Integer> future =
    executor.submit(() -> 100);

Integer result = future.get();
```

The problem is that `get()` can block.

### CompletableFuture

`CompletableFuture` provides a more composable asynchronous programming model.

```java
CompletableFuture
    .supplyAsync(() -> 10)
    .thenApply(x -> x * 2)
    .thenAccept(System.out::println);
```

You can chain operations:

```text
Task A
  ↓
Task B
  ↓
Task C
```

and handle errors:

```java
.exceptionally(ex -> {
    return 0;
});
```

**Interview answer:**

> “Future represents an asynchronous result, but operations such as get can be blocking and it isn't very composable. CompletableFuture provides non-blocking-style composition through methods such as thenApply, thenCompose, thenCombine, and exceptionally.”

---

# 17. What are atomic classes?

Java provides atomic classes in `java.util.concurrent.atomic`.

Examples:

```java
AtomicInteger
AtomicLong
AtomicBoolean
AtomicReference
```

Example:

```java
AtomicInteger counter = new AtomicInteger();

counter.incrementAndGet();
```

This is safe for concurrent increments without using `synchronized`.

**Interview answer:**

> “Atomic classes provide thread-safe operations on individual variables using atomic operations, typically based on compare-and-set mechanisms. They're useful for simple shared state such as counters without requiring a traditional lock.”

A useful distinction:

```java
count++;
```

❌ Not atomic.

```java
counter.incrementAndGet();
```

✅ Atomic.

---

# 18. What is `ConcurrentHashMap`?

`HashMap` isn't designed for concurrent modification by multiple threads.

`ConcurrentHashMap` is designed for concurrent access.

```java
ConcurrentHashMap<String, Integer> map =
        new ConcurrentHashMap<>();

map.put("A", 100);
```

It allows multiple threads to access the map concurrently while maintaining thread-safety.

A particularly useful operation is:

```java
map.computeIfAbsent("A", key -> calculateValue(key));
```

**Interview answer:**

> “ConcurrentHashMap is a thread-safe map designed for concurrent access. It provides better concurrency than synchronizing an entire HashMap, because operations can proceed concurrently where possible. It also provides useful atomic compound operations such as computeIfAbsent.”

---

# 19. What are `wait()`, `notify()`, and `notifyAll()`?

These methods belong to `Object`.

They are used for thread coordination around a monitor.

Example conceptually:

```java
synchronized (lock) {
    while (!condition) {
        lock.wait();
    }

    // continue
}
```

Another thread can do:

```java
synchronized (lock) {
    condition = true;
    lock.notifyAll();
}
```

Important:

`wait()` releases the monitor while waiting.

`Thread.sleep()` **does not release locks** held by the thread.

Also, prefer:

```java
while (!condition) {
    lock.wait();
}
```

rather than:

```java
if (!condition) {
    lock.wait();
}
```

because a thread should re-check the condition after waking.

**Interview answer:**

> “wait, notify, and notifyAll are mechanisms for coordinating threads using an object's monitor. A thread calling wait releases the monitor and waits until it is notified or otherwise awakened. notify wakes one waiting thread, while notifyAll wakes all waiting threads. These methods must be used while owning the object's monitor.”

---

# 20. What are virtual threads?

This is an **important modern Java interview question**.

Virtual threads were introduced as a final feature in **Java 21**.

Traditional platform threads are closely associated with operating-system threads.

Virtual threads are lightweight threads managed by the JVM.

You can create one with:

```java
Thread.startVirtualThread(() -> {
    System.out.println("Hello");
});
```

Or use an executor:

```java
try (var executor =
         Executors.newVirtualThreadPerTaskExecutor()) {

    executor.submit(() -> {
        // task
    });
}
```

They're particularly useful for applications with **large numbers of concurrent I/O-bound tasks**.

For example:

```text
100,000 requests

Platform threads:
expensive → limited number

Virtual threads:
lightweight → potentially very large concurrency
```

But they don't magically make CPU-bound work faster.

**Interview answer:**

> “Virtual threads are lightweight JVM-managed threads introduced in Java 21. They make it practical to represent large numbers of concurrent tasks, particularly blocking I/O operations, without requiring a large number of platform threads. They improve scalability rather than making CPU-bound code execute faster.”

---

# ⭐ Bonus: The questions I'd expect after this

If you're preparing seriously for a Java interview, these are **very likely follow-ups**:

### 21. What is the difference between concurrency and parallelism?

> “Concurrency means multiple tasks are in progress during overlapping periods, while parallelism means multiple tasks are actually executing simultaneously, typically on different CPU cores.”

---

### 22. What happens internally when you call `start()`?

> “The JVM creates or schedules the underlying execution context for the new thread, and that thread eventually invokes its `run()` method. Calling `run()` directly doesn't create a new thread.”

---

### 23. Why isn't `count++` thread-safe?

Because:

```text
read
 ↓
modify
 ↓
write
```

isn't one atomic operation.

Use:

```java
AtomicInteger count = new AtomicInteger();

count.incrementAndGet();
```

or synchronization.

---

### 24. What is thread safety?

> “Code is thread-safe when it behaves correctly when accessed concurrently by multiple threads, according to its intended contract. We can achieve thread safety through synchronization, immutable objects, atomic operations, concurrent collections, thread confinement, or avoiding shared mutable state.”

---

### 25. What is immutability and why does it help with threads?

An immutable object cannot change after construction.

```java
String name = "John";
```

`String` is immutable.

If multiple threads read immutable data, they don't need synchronization merely to protect that data from mutation.

> “Immutability reduces concurrency problems because shared state cannot be modified after creation.”

---

### 26. What is a monitor?

Every Java object can be associated with a monitor.

When you do:

```java
synchronized (obj) {
    // code
}
```

the thread must acquire `obj`'s monitor before entering the block.

> “A monitor provides mutual exclusion and coordination around an object's intrinsic lock. synchronized uses this mechanism.”

---

### 27. What is `ThreadLocal`?

`ThreadLocal` gives each thread its **own independent value**.

```java
ThreadLocal<Integer> value =
        ThreadLocal.withInitial(() -> 0);

value.set(10);
```

Thread A:

```text
value = 10
```

Thread B:

```text
value = 20
```

They don't share that value.

> “ThreadLocal is useful when each thread needs its own isolated state. However, with thread pools, I need to be careful to clean up ThreadLocal values because threads are reused.”

---

# 🎯 How I'd structure your interview answer

If the interviewer simply says:

**“Tell me about multithreading in Java.”**

Don't dump all 27 answers.

Give this structure:

> **“Java multithreading is about executing multiple tasks concurrently. A thread is an independent execution path within a process, and threads share heap memory.**
>
> **Traditionally we can create threads using Thread or Runnable, but in production applications we generally use ExecutorService and thread pools to manage threads efficiently.**
>
> **Because threads can share mutable state, we need to handle concurrency issues such as race conditions, visibility problems, and deadlocks. Java provides synchronized, Lock, volatile, atomic classes, and concurrent collections for this.**
>
> **For asynchronous programming, Java also provides Future and CompletableFuture. And in modern Java, virtual threads allow us to efficiently handle very large numbers of concurrent I/O-bound tasks.”**

Then **stop and let the interviewer choose where to go deeper**.

That answer makes you sound much stronger than simply saying *“A thread is a lightweight process.”*
