import java.util.List;
import java.util.concurrent.*;

class RideBookingSystem {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Callable<String>> cabApps = List.of(new Uber(), new Ola(), new Rapido());

        try {
            List<Future<String>> results = executorService.invokeAll(cabApps);

            System.out.println("Availability responses:");

            for (Future<String> f : results) {
                System.out.println(f.get());
            }

            // String result = executorService.invokeAny(cabApps);
            // System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}

class Uber implements Callable<String> {

    public String call() throws Exception {
        Thread.sleep(1500);
        return "Uber: 2 cabs available near you";
    }
}

class Ola implements Callable<String> {

    public String call() throws Exception {
        Thread.sleep(1500);
        return "Ola: 1 cab available near you";
    }
}

class Rapido implements Callable<String> {

    public String call() throws Exception {
        Thread.sleep(1500);
        return "Rapido: 3 auto available near you";
    }
}
