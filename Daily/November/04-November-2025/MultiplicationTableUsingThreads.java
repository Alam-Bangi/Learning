public class MultiplicationTableUsingThreads {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MultiplicationTask(1));
        Thread t2 = new Thread(new MultiplicationTask(2));
        Thread t3 = new Thread(new MultiplicationTask(3));
        Thread t4 = new Thread(new MultiplicationTask(4));
        Thread t5 = new Thread(new MultiplicationTask(5));
        Thread t6 = new Thread(new MultiplicationTask(6));
        Thread t7 = new Thread(new MultiplicationTask(7));
        Thread t8 = new Thread(new MultiplicationTask(8));
        Thread t9 = new Thread(new MultiplicationTask(9));
        Thread t10 = new Thread(new MultiplicationTask(10));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
    }
}

class MultiplicationTask implements Runnable {
    private int multiplier;

    public MultiplicationTask(int multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public void run() {
        int result = 5 * multiplier;
        System.out.println("5 x " + multiplier + " = " + result);
    }
}