package tryouts.vehicle_rental_system;

import java.util.ArrayList;

public class RentalSystem {
    private ArrayList<Vehicle> vehicles;
    private ArrayList<String> rentalDetails;

    public RentalSystem() {
        vehicles = new ArrayList<>();
        rentalDetails = new ArrayList<>();

        addVehicles();
    }

    private void addVehicles() {
        vehicles.add( new Car("MH12AB1234", "Toyota", 2000, 5));
        vehicles.add(new Car("MH12CD5678", "Honda", 1800, 5));
        vehicles.add(new Bike("MH12EF1234", "Royal Enfield", 800, 350));
        vehicles.add(new Bike("MH12GH5678", "Honda", 500, 150));
    }

    public void viewVehicles() {
        System.out.println("\n----- ALL VEHICLES -----");
        for (Vehicle v : vehicles) {
            v.displayDetails();
        }
    }

    public void viewAvailableVehicles() {
        System.out.println("\n----- AVAILABLE VEHICLES -----");
        for (Vehicle v : vehicles) {
            if (v.isAvailable()) {
                v.displayDetails();
            }
        }
    }

    public void rentVehicle(String number, String customer, int days) {
        if (days <= 0) {
            System.out.println("Invalid rental days!");
            return;
        }
        for (Vehicle v : vehicles) {
            if (v.getVehicleNumber().equalsIgnoreCase(number)) {
                if (!v.isAvailable()) {
                    System.out.println("Vehicle already rented!");
                    return;
                }
                double total = v.calculateRent(days);
                v.setAvailable(false);
                rentalDetails.add(customer + " | " + number + " | " + days + " days | Rs." + total);

                System.out.println("Vehicle rented successfully!");
                System.out.println("Customer: " + customer);
                System.out.println("Vehicle: " + v.getBrand());
                System.out.println("Total rent: Rs." + total);

                return;
            }
        }
        System.out.println("Vehicle not found!");
    }

    public void returnVehicle(String number) {
        for (Vehicle v : vehicles) {
            if (v.getVehicleNumber().equalsIgnoreCase(number)) {
                if (!v.isAvailable()) {
                    v.setAvailable(true);

                    System.out.println("Vehicle returned successfully!");
                } else {
                    System.out.println("Vehicle was not rented!");
                }
                return;
            }
        }
        System.out.println("Vehicle not found!");
    }

    public void viewRentalDetails() {
        System.out.println("\n----- RENTAL DETAILS -----");
        if (rentalDetails.isEmpty()) {
            System.out.println("No rental records found.");
            return;
        }
        for (String details : rentalDetails) {
            System.out.println(details);
        }
    }
}
