import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MultiThreadingWithInvokeAny {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Callable<String>> shopApps = List.of(new Amazon(), new Flipkart(), new Myntra());

        String result = "";

        try {
            result = executorService.invokeAny(shopApps);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(result);

        executorService.shutdown();
    }
}

class Amazon implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1900);
        return "Amazon has the product";
    }
}

class Flipkart implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1900);
        return "Flipkart has the product";
    }
}

class Myntra implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1900);
        return "Myntra has the product";
    }
}