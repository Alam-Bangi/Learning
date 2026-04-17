class TransportFareCalculator {
    public static void main(String[] args) {
        Transport auto = new Auto("MH 12 AB 7890", 25.0);
        Transport train = new Train("T-12110", 15.0);

        System.out.println("----Auto Details----");
        auto.displayDetails();
        System.out.println("Total Fare = " + auto.calculateFare(12.7));

        System.out.println("----Train Details----");
        train.displayDetails();
        System.out.println("Total Fare = " + train.calculateFare(70));
    }
}

abstract class Transport {
    private String vehicleNumber;
    private double baseFare;

    public Transport(String vehicleNumber, double baseFare) {
        this.vehicleNumber = vehicleNumber;
        this.baseFare = baseFare;
    }

    public abstract double calculateFare(double distance);

    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Base Fare: " + baseFare);
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public double getBaseFare() {
        return baseFare;
    }
}

class Auto extends Transport {
    private final double ratePerKm = 25.0;

    public Auto(String vehicleNumber, double baseFare) {
        super(vehicleNumber, baseFare);
    }

    public double calculateFare(double distance) {
        return getBaseFare() + (distance * ratePerKm);
    }
}

class Train extends Transport {
    private final double ratePerKm = 3.0;

    public Train(String vehicleNumber, double baseFare) {
        super(vehicleNumber, baseFare);
    }

    public double calculateFare(double distance) {
        return getBaseFare() + (distance * ratePerKm);
    }
}