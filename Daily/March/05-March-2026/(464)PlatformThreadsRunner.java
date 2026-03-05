import java.util.concurrent.TimeUnit;

class PlatformThreadsRunner {
    public static void main(String[] args) {

        for (int i = 0; i < 1000000; i++) {
            System.out.println(i);
            new Thread(new SleepingThread()).start();
        }
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