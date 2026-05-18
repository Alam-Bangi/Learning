import java.util.Scanner;

class CabBookingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("~~~~~ CAB DETAILS MENU ~~~~~");
            System.out.println("1. View Cab Types");
            System.out.println("2. Book Cab");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    for (CabType cab : CabType.values()) {
                        cab.showDetails();
                    }
                    break;

                case 2:
                    System.out.println("Select Cab Type:");
                    for (CabType cab : CabType.values()) {
                        System.out.println(cab.ordinal() + 1 + ". " + cab.name());
                    }

                    int cabChoice = sc.nextInt();
                    CabType selectedCab = CabType.values()[cabChoice - 1];

                    System.out.print("Enter distance (km): ");
                    double distance = sc.nextDouble();

                    double fare = selectedCab.calculateFare(distance);

                    selectedCab.showDetails();
                    System.out.println("Total Fare   : " + fare);
                    break;

                case 3:
                    System.out.println("Thank you for using Cab Details System!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

            System.out.println();
        }
    }
}

enum CabType {

    MINI(100, 4, false),
    SEDAN(200, 4, true),
    SUV(350, 7, true);

    int baseFare;
    int seatingCapacity;
    boolean acAvailable;

    CabType(int baseFare,
            int seatingCapacity,
            boolean acAvailable) {

        this.baseFare = baseFare;
        this.seatingCapacity = seatingCapacity;
        this.acAvailable = acAvailable;
    }

    double calculateFare(double distance) {

        if (distance > 0 && distance <= 6) {
            return baseFare;
        } else {
            return baseFare + (distance - 6) * 15;
        }
    }

    void showDetails() {

        System.out.println("\nCab Type     : " + this.name());
        System.out.println("Base Fare    : " + baseFare);
        System.out.println("Seats        : " + seatingCapacity);
        System.out.println("AC Available : " + (acAvailable ? "Yes" : "No"));
    }
}
