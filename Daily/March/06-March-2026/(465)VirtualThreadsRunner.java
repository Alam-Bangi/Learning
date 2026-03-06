import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class PlatformThreadsRunner {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
        for (int i = 0; i < 1000000; i++) {
            System.out.println(i);
            // Thread.startVirtualThread(new SleepingThread());
            executor.execute(new SleepingThread());
        }
        executor.shutdown();
    }
}

class SleepingThread implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}