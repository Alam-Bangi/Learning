

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
    int i = 0;
    
    synchronized public void increament() {
        i++;
    }

    public int getI() {
        return i;
    }
}