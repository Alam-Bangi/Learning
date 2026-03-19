class AbstractRevision {
    public static void main(String[] args) {
        Car Volvo = new Car("Volvo", "XC90", 2020, 4);
        System.out.println(Volvo);
        Volvo.start();
        System.out.println();

        Bike Yamaha = new Bike("Yamaha", "YZF-R3", 2021, true);
        System.out.println(Yamaha);
        Yamaha.start();
        System.out.println();

        Truck Ford = new Truck("Ford", "F-150", 2019, 10000);
        System.out.println(Ford);
        Ford.start();

    }
}

abstract class AbstractVehicle {
    String brand;
    String model;
    int year;

    public AbstractVehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    abstract void start();
}

class Car extends AbstractVehicle {
    int numberOfDoors;

    public Car(String brand, String model, int year, int numberOfDoors) {
        super(brand, model, year);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    void start() {
        System.out.println("The car is starting.");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Brand: ").append(brand).append("\n")
                .append("Model: ").append(model).append("\n")
                .append("Year: ").append(year).append("\n")
                .append("Number of Doors: ").append(numberOfDoors);
        return sb.toString();
    }
}

class Bike extends AbstractVehicle {
    boolean hasCarrier;

    public Bike(String brand, String model, int year, boolean hasCarrier) {
        super(brand, model, year);
        this.hasCarrier = hasCarrier;
    }

    @Override
    void start() {
        System.out.println("The bike is starting.");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Brand: ").append(brand).append("\n")
                .append("Model: ").append(model).append("\n")
                .append("Year: ").append(year).append("\n")
                .append("Has Carrier: ").append(hasCarrier);
        return sb.toString();
    }
}

class Truck extends AbstractVehicle {
    double loadCapacity;

    public Truck(String brand, String model, int year, double loadCapacity) {
        super(brand, model, year);
        this.loadCapacity = loadCapacity;
    }

    @Override
    void start() {
        System.out.println("The truck is starting.");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Brand: ").append(brand).append("\n")
                .append("Model: ").append(model).append("\n")
                .append("Year: ").append(year).append("\n")
                .append("Load Capacity: ").append(loadCapacity).append(" kgs");
        return sb.toString();
    }
}