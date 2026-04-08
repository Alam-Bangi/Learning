import java.util.ArrayList;
import java.util.Scanner;

class MovieBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> bookedSeats = new ArrayList<Integer>();
        int totalSeats = 10;

        int choice;

        do {
            System.out.println("\n-----Booking Centre-----");
            System.out.println("1. Book Seat");
            System.out.println("2. Cancel Seat");
            System.out.println("3. Show Available Seats");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter seat number (1-10): ");
                    int seat = sc.nextInt();

                    if (seat < 1 || seat > totalSeats) {
                        System.out.println("Invalid seat number");
                    } else if (bookedSeats.contains(seat)) {
                        System.out.println("Seat already booked");
                    } else {
                        bookedSeats.add(seat);
                        System.out.println("Seat " + seat + " booked successfully");
                    }
                    break;

                case 2:
                    System.out.print("Enter seat number to cancel (1-10): ");
                    int seatCancel = sc.nextInt();

                    if (bookedSeats.contains(seatCancel)) {
                        bookedSeats.remove(Integer.valueOf(seatCancel));
                        System.out.println("Seat " + seatCancel + " cancelled successfully");
                    } else {
                        System.out.println("Seat not booked");
                    }
                    break;

                case 3:
                    System.out.println("Available seats:");
                    for (int i = 1; i <= totalSeats; i++) {
                        if (!bookedSeats.contains(i)) {
                            System.out.print(i + " ");
                        }
                    }
                    System.out.println();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 4);
    }
}
