package tryouts.map_implementations.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;

public class GamingCenter {

    public static void main(String[] args) {
        LinkedHashMap<Integer, String> bookings = new LinkedHashMap<>();
        LinkedHashMap<Integer, Integer> bookingHours = new LinkedHashMap<>();

        int pricePerHour = 100;

        bookings.put(1, "Rahul");
        bookingHours.put(1, 2);

        bookings.put(2, "Amit");
        bookingHours.put(2, 3);

        bookings.put(3, "Priya");
        bookingHours.put(3, 1);

        System.out.println("=== Gaming PC Bookings ===");
        for (Map.Entry<Integer, String> entry : bookings.entrySet()) {

            int pc = entry.getKey();
            String customer = entry.getValue();
            int hours = bookingHours.get(pc);
            int total = hours * pricePerHour;

            System.out.println("\nPC Number: " + pc);
            System.out.println("Customer: " + customer);
            System.out.println("Booking Hours: " + hours);
            System.out.println("Total Cost: Rs." + total);
        }

        int searchPC = 2;

        if (bookings.containsKey(searchPC)) {
            System.out.println("\nPC " + searchPC + " is booked by " + bookings.get(searchPC));
        }

        bookings.remove(1);
        bookingHours.remove(1);

        System.out.println("\nPC 1 booking cancelled.");

        System.out.println("\n=== Updated Bookings ===");
        for (Map.Entry<Integer, String> entry : bookings.entrySet()) {
            int pc = entry.getKey();

            System.out.println( "PC " + pc + " - " + entry.getValue() + " - " + bookingHours.get(pc) + " hours");
        }
    }
}