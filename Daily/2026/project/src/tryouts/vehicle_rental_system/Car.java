package tryouts.vehicle_rental_system;

public class Car extends Vehicle {
    private int seatingCapacity;

    public Car(String number, String brand, double rent, int seats) {
        super(number, brand, rent);
        this.seatingCapacity = seats;
    }

    @Override
    public double calculateRent(int days) {
        return getRentPerDay() * days;
    }

    @Override
    public String getType() {
        return "Car";
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }
}
