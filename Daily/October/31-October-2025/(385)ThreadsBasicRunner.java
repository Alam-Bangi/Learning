class ThreadsBasicRunner {
    public static void main(String[] args) throws InterruptedException {

        Task1 task1 = new Task1();
        // task.run(); //doesn't run in parallel but as normal task
        task1.setPriority(1);
        task1.start();

        Task2 task2 = new Task2();
        Thread task2Thread = new Thread(task2);
        task2Thread.setPriority(10);
        task2Thread.start();

        task1.join();
        task2Thread.join();

        System.out.print("\nTask3 Started");
        for( int i = 301; i<=309; i++) {
            System.out.print(i +" ");
        }
        System.out.print("\nTask3 Done");

        System.out.print("\nMain Done");
    }
}
class Task1 extends Thread {
    public void run() {
        System.out.print("\nTask1 Started");
        for( int i = 101; i<=109; i++) {
            System.out.print(i +" ");
        }
        System.out.print("\nTask1 Done");

    }
}
class Task2 implements Runnable {

    @Override
    public void run() {
        System.out.print("\nTask2 Started");
        for( int i = 201; i<=209; i++) {
            System.out.print(i +" ");
        }
        System.out.print("\nTask2 Done");
    }
    
}