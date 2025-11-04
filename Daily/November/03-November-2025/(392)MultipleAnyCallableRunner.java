import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

class MultipleCallableRunner{
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = ExecutorService.newFixedThreadPool(1);
        List<CallableTask> tasks= List.of(new CallableTask("ABC"), new CallableTask("DEF"), new CallableTask("GHI"));
        
        String result = executorService.invokeAny(tasks);
        System.out.println(result.get());
        
        executorService.shutdown();
    }
}
class CallableTask implements Callable<String> {
    private String name;
    public CallableTask(String name) {
        this.name = name;
    }

    public String call() throws Exception {
        Thread.sleep(1000);
        return "Hello " +name;
    }
}