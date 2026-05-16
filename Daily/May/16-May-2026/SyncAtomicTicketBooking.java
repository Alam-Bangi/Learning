import java.util.*;
import java.util.concurrent.*;

class SyncAtomicTicketBooking {

    public static void main(String[] args) {

        TicketBookingSystem seats = new TicketBookingSystem(10);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(() -> seats.bookSeats("Alam", Arrays.asList(1, 2, 3, 8)));
        executor.submit(() -> seats.bookSeats("Bob", Arrays.asList(3, 4)));
        executor.submit(() -> seats.bookSeats("Charlie", Arrays.asList(5, 6)));
        executor.submit(() -> seats.bookSeats("David", Arrays.asList(7, 9, 10)));
        executor.submit(() -> seats.bookSeats("Eve", Arrays.asList(2, 8)));
        executor.submit(() -> seats.bookSeats("Alam", Arrays.asList(4, 5)));

        executor.shutdown();
    }
}

class TicketBookingSystem {

    private final ConcurrentHashMap<Integer, String> seats = new ConcurrentHashMap<>();

    public TicketBookingSystem(int totalSeats) {
        for (int i = 1; i <= totalSeats; i++) {
            seats.put(i, "FREE");
        }
    }

    public synchronized boolean bookSeats(String user, List<Integer> requestedSeats) {

        System.out.println("\n" + user + " trying: " + requestedSeats);

        if (user == null || requestedSeats == null || requestedSeats.isEmpty()) {
            System.out.println(user + " invalid input");
            return false;
        }

        // STEP 1: check ALL seats first
        for (Integer seat : requestedSeats) {

            if (seat == null || !seats.containsKey(seat)) {
                System.out.println(user + " invalid seat: " + seat);
                return false;
            }

            if (!"FREE".equals(seats.get(seat))) {
                System.out.println(user + " failed (seat already booked): " + requestedSeats);
                return false;
            }
        }

        // STEP 2: book ALL seats
        for (Integer seat : requestedSeats) {
            seats.put(seat, user);
        }

        System.out.println(user + " SUCCESS booked: " + requestedSeats);
        printRemainingSeats();
        return true;
    }

    private void printRemainingSeats() {

        List<Integer> available = new ArrayList<>();

        for (Map.Entry<Integer, String> entry : seats.entrySet()) {
            if ("FREE".equals(entry.getValue())) {
                available.add(entry.getKey());
            }
        }

        Collections.sort(available);

        System.out.println("Remaining seats: " + available);
        System.out.println("------------------------------------------------");
    }
}