import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ConcurrencyRunner {
    public static void main(String[] args) {
        Counter counter = new Counter();
        counter.increament();
        counter.increament();
        counter.increament();
        System.out.println(counter.getI());
    }
}

class Counter {
    private int i = 0;

    synchronized public void increament() {
        i++;
    }

    public int getI() {
        return i;
    }
}

class BiCounter {
    private int i = 0;
    private int j = 0;

    synchronized public void increamentI() {
        i++;
    }

    public int getI() {
        return i;
    }

    synchronized public void increamentJ() {
        j++;
    }

    public int getJ() {
        return j;
    }
}

class BiCounterWithLock {
    private int i = 0;
    private int j = 0;

    Lock lockI = new ReentrantLock();
    Lock lockJ = new ReentrantLock();

    public void increamentI() {
        lockI.lock();
        i++;
        lockI.unlock();
    }

    public int getI() {
        return i;
    }

    public void increamentJ() {
        lockJ.lock();
        j++;
        lockJ.unlock();
    }

    public int getJ() {
        return j;
    }
}

class BiCounterWithAtomicInteger {
    private AtomicInteger i = new AtomicInteger();
    private AtomicInteger j = new AtomicInteger();

    public void increamentI() {
        i.incrementAndGet();
    }

    public int getI() {
        return i.get();
    }

    public void increamentJ() {
        j.incrementAndGet();
    }

    public int getJ() {
        return j.get();
    }
}