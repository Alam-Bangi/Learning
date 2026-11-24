package tryouts.vehicle_rental_system;

public abstract class Vehicle {
    private String vehicleNumber;
    private String brand;
    private double rentPerDay;
    private boolean available;

    public Vehicle(String vehicleNumber, String brand, double rentPerDay) {
        this.vehicleNumber = vehicleNumber;
        this.brand = brand;
        this.rentPerDay = rentPerDay;
        this.available = true;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getBrand() {
        return brand;
    }

    public double getRentPerDay() {
        return rentPerDay;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public abstract double calculateRent(int days);

    public abstract String getType();

    public void displayDetails() {
        System.out.println(getType() + " | Number: " + vehicleNumber + " | Brand: " + brand + " | Rent/Day: Rs." + rentPerDay + " | Status: " + (available ? "Available" : "Rented"));
    }
}
