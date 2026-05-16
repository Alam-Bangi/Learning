import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class LockTicketBooking {

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

    private final Set<Integer> availableSeats;
    private final Lock lock = new ReentrantLock(); // 🔐 added lock

    public TicketBookingSystem(int totalSeats) {
        availableSeats = new HashSet<>();
        for (int i = 1; i <= totalSeats; i++) {
            availableSeats.add(i);
        }
    }

    public boolean bookSeats(String user, List<Integer> requestedSeats) {

        lock.lock(); // 🔐 acquire lock

        try {
            System.out.println(user + " trying to book seats: " + requestedSeats);

            if (requestedSeats == null || requestedSeats.isEmpty()) {
                System.out.println(user + " provided invalid seat list");
                return false;
            }

            if (availableSeats.containsAll(requestedSeats)) {

                for (int seat : requestedSeats) {
                    availableSeats.remove(seat);
                }

                System.out.println(user + " successfully booked: " + requestedSeats);
                printRemainingSeats();
                return true;

            } else {
                System.out.println(user + " failed. Some seats not available.");
                printRemainingSeats();
                return false;
            }

        } finally {
            lock.unlock(); // 🔐 always release lock
        }
    }

    private void printRemainingSeats() {
        System.out.println("Remaining seats: " + availableSeats);
        System.out.println("------------------------------------------------");
    }
}