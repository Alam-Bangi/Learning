package tryouts.thread;

public class ThreadExamples {

    // 1. Extending Thread
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("1. Thread class");
        }
    }

    // 2. Implementing Runnable
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("2. Runnable");
        }
    }

    public static void main(String[] args) {

        // 1. Using Thread class
        MyThread t1 = new MyThread();
        t1.start();

        // 2. Using Runnable
        MyRunnable task = new MyRunnable();
        Thread t2 = new Thread(task);
        t2.start();

        // 3. Using Runnable with lambda
        Thread t3 = new Thread(() -> { System.out.println("3. Runnable with Lambda");
        });
        t3.start();

        // 4. Using lambda directly
        new Thread(() -> { System.out.println("4. Lambda Thread");
        }).start();
    }
}