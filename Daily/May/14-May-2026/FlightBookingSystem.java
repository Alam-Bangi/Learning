import java.util.ArrayList;
import java.util.Scanner;

class FlightBookingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> boardedPassengers = new ArrayList<>();

        while (true) {

            System.out.println("\n--- Welcome to Flight Counter ---");
            System.out.println("1. Book Flight Ticket");
            System.out.println("2. Show Boarded Passengers");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {

                sc.nextLine();

                System.out.print("\nEnter passenger name: ");
                String name = sc.nextLine();

                System.out.println("Choose Class:");
                System.out.println("1. Economy");
                System.out.println("2. Business");
                System.out.print("Enter choice: ");
                int type = sc.nextInt();

                CheckIn checkIn;

                if (type == 1) {
                    checkIn = new EconomyCheckIn(name);
                } else {
                    checkIn = new BusinessCheckIn(name);
                }

                checkIn.startCheckIn();
                checkIn.assignSeat();

                System.out.println("\nSelect Payment Method:");
                System.out.println("1. UPI");
                System.out.println("2. CARD");
                System.out.print("Enter choice: ");
                int payChoice = sc.nextInt();

                System.out.print("Enter amount: ");
                double amount = sc.nextDouble();

                Payment payment;

                if (payChoice == 1) {
                    payment = new UpiPayment();
                } else {
                    payment = new CardPayment();
                }

                boolean success = payment.pay(amount);

                if (success) {
                    checkIn.generateBoardingPass();
                    boardedPassengers.add(name);
                    System.out.println("Booking Successful!");
                } else {
                    System.out.println("Payment Failed. Booking Cancelled.");
                }

            } else if (choice == 2) {

                System.out.println("\n--- Boarded Passengers List ---");

                if (boardedPassengers.isEmpty()) {
                    System.out.println("No passengers have boarded yet.");
                } else {
                    for (int i = 0; i < boardedPassengers.size(); i++) {
                        System.out.println((i + 1) + ". " + boardedPassengers.get(i));
                    }
                }

            } else if (choice == 3) {

                System.out.println("Exiting system...");
                break;

            } else {
                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}

abstract class CheckIn {

    String name;

    CheckIn(String name) {
        this.name = name;
    }

    void startCheckIn() {
        System.out.println("\nCheck-in started for " + name);
    }

    abstract void assignSeat();

    void generateBoardingPass() {
        System.out.println("Boarding pass generated for " + name);
    }
}

class EconomyCheckIn extends CheckIn {

    EconomyCheckIn(String name) {
        super(name);
    }

    void assignSeat() {
        System.out.println("Seat assigned: Economy class (standard seat)");
    }
}

class BusinessCheckIn extends CheckIn {

    BusinessCheckIn(String name) {
        super(name);
    }

    void assignSeat() {
        System.out.println("Seat assigned: Business class (window priority)");
    }
}

interface Payment {
    boolean pay(double amount);
}

class UpiPayment implements Payment {

    public boolean pay(double amount) {

        System.out.println("\nProcessing UPI payment of " + amount);

        if (amount <= 0) {
            System.out.println("UPI Payment Failed");
            return false;
        }

        System.out.println("UPI Payment Successful");
        return true;
    }
}

class CardPayment implements Payment {

    public boolean pay(double amount) {

        System.out.println("\nProcessing CARD payment of " + amount);

        if (amount < 100) {
            System.out.println("Card Payment Failed (Minimum 100 required)");
            return false;
        }

        System.out.println("Card Payment Successful");
        return true;
    }
}