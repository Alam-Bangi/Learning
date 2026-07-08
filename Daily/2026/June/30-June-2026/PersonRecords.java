import java.util.*;
import java.util.List;
import java.io.IOException;
import java.nio.file.*;

class PersonRecords {

    private static final String FILE_NAME = "record.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n--------------------------------------------");
            System.out.println("Person Records Management System");
            System.out.println("1. Add Person Record");
            System.out.println("2. Search Person Record");
            System.out.println("3. View All Person Records");
            System.out.println("4. Exit");
            System.out.println("--------------------------------------------");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("\nEnter Person Details");

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    long contactNumber;
                    while (true) {
                        System.out.print("Contact Number (10 digits): ");
                        contactNumber = sc.nextLong();
                        sc.nextLine();

                        if (String.valueOf(contactNumber).length() == 10)
                            break;

                        System.out.println("Invalid Contact Number! Please enter exactly 10 digits.");
                    }

                    System.out.print("Birth Location: ");
                    String birthLocation = sc.nextLine();

                    System.out.print("Flat No: ");
                    int flatNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Street Name: ");
                    String streetName = sc.nextLine();

                    System.out.print("City: ");
                    String city = sc.nextLine();

                    System.out.print("State: ");
                    String state = sc.nextLine();

                    System.out.print("Pincode: ");
                    int pincode = sc.nextInt();
                    sc.nextLine();

                    Address address = new Address(flatNo, streetName, city, state, pincode);
                    Person person = new Person(name, contactNumber, birthLocation, address);

                    personList.add(person);

                    try {
                        List<String> lines = Arrays.asList(person.toString());

                        Files.write(
                                Paths.get(FILE_NAME), // Which file to write to
                                lines, // What to write
                                StandardOpenOption.CREATE, // Create file if it doesn't exist
                                StandardOpenOption.APPEND // Add to the end instead of replacing
                        );

                        System.out.println("Record added successfully.");
                        // System.out.println("Record saved to " + FILE_NAME);

                    } catch (IOException e) {
                        System.out.println("Error writing to file.");
                        // e.printStackTrace();
                    }

                    break;

                case 2:

                    Path filePath = Paths
                            .get(FILE_NAME);

                    if (Files.exists(filePath)) {
                        try {
                            List<String> pastRecords = Files.readAllLines(filePath);
                            System.out.print("Enter what you want to search: ");
                            String searchName = sc.nextLine();
                            boolean found = false;

                            for (String record : pastRecords) {
                                if (record.contains(searchName)
                                        || record.toLowerCase().contains(searchName.toLowerCase())) {
                                    System.out.println("Record found:");
                                    System.out.println(record);
                                    found = true;
                                    // break;
                                }
                            }
                        } catch (IOException e) {
                            System.out.println("Error reading the file: " + e.getMessage());
                        }
                    } else {
                        System.out.println("No records found.");
                    }

                    break;

                case 3:

                    // filePath = Paths
                    // .get(FILE_NAME);

                    // if (Files.exists(filePath)) {
                    // try {
                    // List<String> pastRecords = Files.readAllLines(filePath);

                    // for (String record : pastRecords) {
                    // System.out.println(record);
                    // }
                    // } catch (IOException e) {
                    // System.out.println("Error reading the file: " + e.getMessage());
                    // }
                    // } else {
                    // System.out.println("No records found.");
                    // }
                    displayRecords();
                    break;

                case 4:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);

        sc.close();
    }

    public static void displayRecords() {
        Path filePath = Paths.get(FILE_NAME);

        if (Files.exists(filePath)) {
            try {
                List<Person> personList = new ArrayList<>();
                List<String> pastRecords = Files.readAllLines(filePath);
                int count = pastRecords.size();
                int counter = 1;
                Person p = new Person();
                for (String record : pastRecords) {
                    if (record.contains("Name : ")) {
                        String name = record.substring(7);
                        p.setName(name);
                    }
                    if (record.contains("Contact Number : ")) {
                        String contactNumberStr = record.substring(17);
                        long contactNumber = Long.parseLong(contactNumberStr);
                        p.setContactNumber(contactNumber);
                    }
                    if (record.contains("Birth Location : ")) {
                        String birthLocation = record.substring(17);
                        p.setBirthLocation(birthLocation);
                    }
                    if (record.contains("Address : ")) {
                        String addressStr = record.substring(10);
                        Address address = new Address();
                        p.setAddress(address);
                    }
                    if (record.equals("----------------------------------------")) {
                        // Do nothing
                    }
                    if (counter % 5 == 0) {
                        personList.add(p);
                        p = new Person();
                    }
                    counter++;
                }

                System.out.println("\nAll Person Records:" + personList);
            } catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
            }
        } else {
            System.out.println("No records found.");
        }
    }
}

class Person {

    private String name;
    private long contactNumber;
    private String birthLocation;
    private Address address;

    public Person() {
    }

    public Person(String name, long contactNumber, String birthLocation, Address address) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.birthLocation = birthLocation;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getBirthLocation() {
        return birthLocation;
    }

    public void setBirthLocation(String birthLocation) {
        this.birthLocation = birthLocation;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Name : " + name +
                "\nContact Number : " + contactNumber +
                "\nBirth Location : " + birthLocation +
                "\nAddress : " + address +
                "\n";
    }
}

class Address {

    private int flatNo;
    private String streetName;
    private String city;
    private String state;
    private int pincode;

    public Address() {
    }

    public Address(int flatNo, String streetName, String city, String state, int pincode) {
        this.flatNo = flatNo;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return flatNo + ", " + streetName + ", " + city + ", " + state + " - " + pincode;
    }
}