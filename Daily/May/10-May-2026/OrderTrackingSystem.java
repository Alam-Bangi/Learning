import java.util.List;
import java.util.concurrent.*;

class OrderTrackingSystem {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Callable<String>> services = List.of(new Warehouse(), new Delivery(), new Payment());

        try {
            List<Future<String>> results = executor.invokeAll(services);

            System.out.println("Order Status Report:");

            for (Future<String> f : results) {
                System.out.println(f.get());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}

class Warehouse implements Callable<String> {

    public String call() throws Exception {
        Thread.sleep(1000);
        return "Warehouse: Order Packed";
    }
}

class Delivery implements Callable<String> {

    public String call() throws Exception {
        Thread.sleep(1500);
        return "Delivery: Out for Delivery";
    }
}

class Payment implements Callable<String> {

    public String call() throws Exception {
        Thread.sleep(800);
        return "Payment: Completed";
    }
}