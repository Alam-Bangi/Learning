import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ExecutorServiceRunner {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Task1());
        executorService.execute(new Thread(new Task2()));

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