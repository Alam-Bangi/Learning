import java.util.*;
import java.util.concurrent.*;

class FlightBookingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Passenger Name: ");
        String passenger = sc.nextLine();

        System.out.print("Enter Flight Number: ");
        String flightNo = sc.nextLine();

        System.out.print("Enter Seat Preference (Window/Aisle): ");
        String seatPref = sc.nextLine();

        System.out.println("\nProcessing booking request...\n");

        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Callable<String>> tasks = List.of(new Validation(passenger, flightNo),
                new PreferredSeat(flightNo, seatPref), new PaymentService(passenger));

        try {

            List<Future<String>> results = executor.invokeAll(tasks);

            System.out.println("===== FINAL BOOKING RESPONSE =====\n");

            for (Future<String> f : results) {
                System.out.println(f.get());
            }

        } catch (Exception e) {
            System.out.println("System error during booking.");
        }

        executor.shutdown();
        sc.close();
    }
}

class Validation implements Callable<String> {

    String passenger, flightNo;

    Validation(String passenger, String flightNo) {
        this.passenger = passenger;
        this.flightNo = flightNo;
    }

    public String call() throws Exception {
        Thread.sleep(1000);

        if (passenger == null || passenger.trim().isEmpty()) {
            return "Validation: FAILED (Invalid Passenger)";
        }

        return "Passenger " + passenger + " verified for flight " + flightNo;
    }
}

class PreferredSeat implements Callable<String> {

    String flightNo, seatPref;

    PreferredSeat(String flightNo, String seatPref) {
        this.flightNo = flightNo;
        this.seatPref = seatPref;
    }

    public String call() throws Exception {
        Thread.sleep(1200);

        String seat = seatPref.equalsIgnoreCase("Window") ? "12A" : "14C";

        return "Seat " + seat + " confirmed on flight " + flightNo;
    }
}

class PaymentService implements Callable<String> {

    String passenger;

    PaymentService(String passenger) {
        this.passenger = passenger;
    }

    public String call() throws Exception {
        Thread.sleep(800);

        if (passenger.equalsIgnoreCase("test")) {
            return "Payment Service: FAILED (Test user not allowed)";
        }

        return "Payment successful for " + passenger;
    }
}