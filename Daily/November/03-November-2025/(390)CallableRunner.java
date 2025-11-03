import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

class CallableRunner {
    public static void main(String[] args) {
        ExecutorService executorService = ExecutorService.newFixedThreadPool(1);
        Future<String> welcomeFuture= executorService.submit(new CallableTask("ABC"));
        String welcomeMessage = welcomeFuture.get();
        System.out.println(welcomeMessage);

        System.out.println("\n Main Completed");
    }
}
class CallableTask implements Callable<String> {
    private String name;
    public CallableTask(String name) }{
        this.name = name;
    }

    public String call() throws Exception {
        Thread.sleep(1000);
        return "Hello " +name;
    }
}