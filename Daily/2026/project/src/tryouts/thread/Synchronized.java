package tryouts.thread;

class Counter {
    private int count = 0;
    private static int staticCount = 0;

    synchronized void incrementMethod() {
        count++;
        System.out.println(
            Thread.currentThread().getName()
            + " - Instance Method: " + count
        );
    }

    void incrementThisBlock() {
        synchronized (this) {
            count++;
            System.out.println(
                Thread.currentThread().getName()
                + " - synchronized(this): " + count
            );
        }
    }

    private final Object lock = new Object();
    void incrementLockBlock() {
        synchronized (lock) {
            count++;
            System.out.println(
                Thread.currentThread().getName()
                + " - synchronized(lock): " + count
            );
        }
    }

    static synchronized void incrementStaticMethod() {
        staticCount++;
        System.out.println(Thread.currentThread().getName() + " - Static Method: " + staticCount);
    }
}

class Synchronized {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            counter.incrementMethod();
            counter.incrementThisBlock();
            counter.incrementLockBlock();
            Counter.incrementStaticMethod();
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            counter.incrementMethod();
            counter.incrementThisBlock();
            counter.incrementLockBlock();
            Counter.incrementStaticMethod();
        }, "Thread-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("\nBoth threads completed.");
    }
}