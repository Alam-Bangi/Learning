package tryouts.vehicle_rental_system;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        RentalSystem rentalSystem = new RentalSystem();
        int choice = 0;
        do {
            System.out.println("\n==============================");
            System.out.println("   VEHICLE RENTAL SYSTEM");
            System.out.println("==============================");

            System.out.println("1. View All Vehicles");
            System.out.println("2. View Available Vehicles");
            System.out.println("3. Rent a Vehicle");
            System.out.println("4. Return a Vehicle");
            System.out.println("5. View Rental Details");
            System.out.println("6. Exit");

            System.out.print("\nEnter your choice: ");
            if (!sc.hasNextInt()) {
                System.out.println("Enter a valid number!");
                sc.nextLine();
                continue;
            }
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    rentalSystem.viewVehicles();
                    break;
                case 2:
                    rentalSystem.viewAvailableVehicles();
                    break;
                case 3:
                    System.out.print("Enter vehicle number: ");
                    String number = sc.nextLine();

                    System.out.print("Enter customer name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter rental days: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid number of days!");
                        sc.nextLine();
                        break;
                    }
                    int days = sc.nextInt();
                    sc.nextLine();

                    rentalSystem.rentVehicle(number, name, days);
                    break;
                case 4:
                    System.out.print("Enter vehicle number: ");
                    String returnNumber = sc.nextLine();

                    rentalSystem.returnVehicle(returnNumber);
                    break;
                case 5:
                    rentalSystem.viewRentalDetails();
                    break;
                case 6:
                    System.out.println("Thank you for using our system!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 6);
        sc.close();
    }
}
