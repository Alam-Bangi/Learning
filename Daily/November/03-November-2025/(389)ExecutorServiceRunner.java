import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ExecutorServiceRunner {
    public static void main(String[] args) {
        // ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new Task(1));
        executorService.execute(new Task(2));
        executorService.execute(new Task(3));
        
        executorService.shutdown();
    }
}
class Task extends Thread {
    private int number;
    public Task(int number) {
        this.number = number;
    }

    public void run() {
        System.out.print("\nTask "+number+ " Started");
        for( int i = number*100; i<=number*100+99; i++) {
            System.out.print(i +" ");
        }
        System.out.print("\nTask "+number+"Done");

    }
}
class Task2 implements Runnable {

    @Override
    public void run() {
        System.out.print("\nTask2 Started");
        for( int i = 201; i<=209; i++) {
            System.out.print(i +" ");
        }
        System.out.print("\nTask2  Done");
    }
    
}