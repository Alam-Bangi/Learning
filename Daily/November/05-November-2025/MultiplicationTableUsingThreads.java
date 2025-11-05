class MultiplicationTableUsingThreads {
    public static void main(String[] args) throws InterruptedException {

        // Using For-Loop and maintaining order

        for (int i =1; i<11; i++) {
            Thread thread = new Thread(new MultiplicationTask(i));
            thread.start();
            thread.join();
        }
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