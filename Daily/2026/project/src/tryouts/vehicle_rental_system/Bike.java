package tryouts.vehicle_rental_system;

public class Bike extends Vehicle {
    private int engineCC;

    public Bike(String number, String brand, double rent, int engineCC) {
        super(number, brand, rent);
        this.engineCC = engineCC;
    }

    @Override
    public double calculateRent(int days) {
        return getRentPerDay() * days;
    }

    @Override
    public String getType() {
        return "Bike";
    }

    public int getEngineCC() {
        return engineCC;
    }
}
