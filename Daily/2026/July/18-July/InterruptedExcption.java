class InterruptedExcption {
    public static void main(String[] args) {

        MyThread t = new MyThread();
        t.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted while sleeping!");
        }

        t.interrupt();
        System.out.println("Main thread interrupted child thread");
    }
}

class MyThread extends Thread {
    public void run() {
        try {
            System.out.println("Thread is going to sleep...");

            Thread.sleep(5000);

            System.out.println("Thread woke up normally");
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted while sleeping!");
        }
    }
}