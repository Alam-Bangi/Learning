import java.util.concurrent.*;

class CallCenter {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 30; i++) {

            int callId = i;

            executor.submit(() -> {

                System.out.println(
                        Thread.currentThread().getName()
                                + " handling call "
                                + callId);

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("Error in system!!");
                }

                System.out.println(
                        "Call "
                                + callId
                                + " completed");
            });
        }
        executor.shutdown();
    }
}