

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