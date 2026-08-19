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
