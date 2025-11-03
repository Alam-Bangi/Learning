class ThreadsBasicRunner {
    public static void main(String[] args) {

        Task1 task = new Task1();
        // task.run(); //doesn't run in parallel but as normal task
        task.start();

        for( int i = 201; i<=209; i++) {
            System.out.print(i +" ");
        }
        System.out.print("\nTask2 Done");

        for( int i = 301; i<=309; i++) {
            System.out.print(i +" ");
        }
        System.out.print("\nTask3 Done");

        System.out.print("\nMain Done");
    }
}
class Task1 extends Thread {
    public void run() {
        for( int i = 101; i<=109; i++) {
            System.out.print(i +" ");
        }
        System.out.print("\nTask1 Done");

    }
}