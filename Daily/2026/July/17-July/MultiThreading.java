import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreading {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new Task1());
        executorService.execute(new Thread(new Task2()));
        executorService.execute(new Task3());
        executorService.execute(new Task4());

        System.out.println("Task 5 starts");
        for (int i = 501; i < 599; i++) {
            System.out.print(i + " ");
        }
        System.out.println("Task 5 ends");

        executorService.shutdown();
    }
}

class Task1 extends Thread {
    public void run() {
        System.out.println("Task 1 starts");
        for (int i = 101; i < 199; i++) {
            System.out.print(i + " ");
        }
        System.out.println("Task 1 ends");
    }
}

class Task2 implements Runnable {
    public void run() {
        System.out.println("Task 2 starts");
        for (int i = 201; i < 299; i++) {
            System.out.print(i + " ");
        }
        System.out.println("Task 2 ends");
    }
}

class Task3 extends Thread {
    public void run() {
        System.out.println("Task 3 starts");
        for (int i = 301; i < 399; i++) {
            System.out.print(i + " ");
        }
        System.out.println("Task 3 ends");
    }
}

class Task4 extends Thread {
    public void run() {
        System.out.println("Task 4 starts");
        for (int i = 401; i < 499; i++) {
            System.out.print(i + " ");
        }
        System.out.println("Task 4 ends");
    }
}