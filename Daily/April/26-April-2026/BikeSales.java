import java.time.LocalDate;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

class BikeSales {
    public static void main(String[] args) {
        Map<Bike, DateOfRegistration> bikes = new HashMap<>();
        bikes.put(new Bike("Duke 390", "White", 150000.00, true),
                new DateOfRegistration(23, 11, 2022));
        bikes.put(new Bike("Java Bobber", "Metallic Grey", 120000.00, true),
                new DateOfRegistration(12, 04, 2024));
        bikes.put(new Bike("NS 200", "Red", 70000.00, true),
                new DateOfRegistration(28, 01, 2019));
        bikes.put(new Bike("Access 125", "Off-White", 90000.00, false),
                new DateOfRegistration(16, 05, 2025));
        bikes.put(new Bike("Activa", "Blue", 35000.00, false),
                new DateOfRegistration(9, 8, 2017));

        Map<Bike, LocalDate> soldBikes = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n---- Welcome to the 2-Wheeler Store ----");
            System.out.println("1. View Bikes");
            System.out.println("2. Sell Bike");
            System.out.println("3. View Sold Bikes");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    for (Map.Entry<Bike, DateOfRegistration> bike : bikes.entrySet()) {
                        System.out.println(bike.getKey() + " " + bike.getValue());
                    }
                    break;
                case 2:
                    System.out.print("Enter Bike Name: ");
                    String bike = sc.nextLine();
                    System.out.println(bike);

                    List<Bike> bikeFound = bikes.keySet().stream().filter(a -> a.getName().equals(bike))
                            .collect(Collectors.toList());
                    if (!(bikeFound.isEmpty())) {
                        System.out.println("Bike Sold!!");
                        System.out.println(bikeFound);
                        soldBikes.put(bikeFound.get(0), LocalDate.now());
                        bikes.remove(bikeFound.get(0));
                    } else {
                        System.out.println("Bike not found.");
                    }
                    break;
                case 3:
                    if (soldBikes.isEmpty()) {
                        System.out.println("No Bikes sold yet!!!");
                    }
                    for (Map.Entry<Bike, LocalDate> sold : soldBikes.entrySet()) {
                        System.out.println(sold.getKey() + "\nSelling date: " + sold.getValue());
                    }
                    break;
                case 4:
                    System.out.println("Exiting...!!!");
                    sc.close();
                    break;
                default:
                    System.out.println("Invalid choice!!");
                    break;
            }
        } while (choice != 4);
    }
}

class Bike {
    String name;
    String colour;
    double price;
    boolean withGear;

    Bike(String name, String colour, double price, boolean withGear) {
        this.name = name;
        this.colour = colour;
        this.price = price;
        this.withGear = withGear;
    }

    public String getName() {
        return name;
    }

    public String getColour() {
        return colour;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        StringBuilder bikes = new StringBuilder();
        System.out.println();
        bikes.append("Name- ").append(name).append("\n").append("Color- ").append(colour).append("\n")
                .append("Price- ").append(price).append("\n");
        if (withGear) {
            bikes.append("Geared Vehicle");
        } else {
            bikes.append("Non-Geared Vehicle");
        }
        return bikes.toString();
    }
}

class DateOfRegistration {
    int day;
    int month;
    int year;

    DateOfRegistration(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String toString() {
        StringBuilder dor = new StringBuilder();
        dor.append("\nDate of registration- ").append(day).append("-").append(month).append("-").append(year);
        return dor.toString();
    }
}