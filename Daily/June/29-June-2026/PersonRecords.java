import java.util.*;
import java.util.List;

class PersonRecords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();
        int choice;

        do {
            System.out.println();
            System.out.println("------------------------------------------------");
            System.out.println("Welcome to the Person Records Management System");
            System.out.println("1. Add Person Record");
            System.out.println("2. Search Person Record");
            System.out.println("3. View All Person Records");
            System.out.println("4. Exit");
            System.out.println("------------------------------------------------");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter details for person: ");
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Contact Number: ");
                    long contactNumber = sc.nextLong();
                    if (String.valueOf(contactNumber).length() != 10) {
                        System.out.println("Invalid contact number.");
                        System.out.print("Contact Number: ");
                        contactNumber = sc.nextLong();
                        break;
                    }
                    sc.nextLine();
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
                    break;

                case 2:
                    if (personList.isEmpty()) {
                        System.out.println("No records available to search.");
                        break;
                    }
                    System.out.print("Enter the name to search: ");
                    String searchName = sc.nextLine();
                    boolean found = false;
                    for (Person pers : personList) {
                        if (pers.getName().equalsIgnoreCase(searchName)) {
                            System.out.println("Record found:");
                            System.out.println(pers.toString());
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("No record found for the name: " + searchName);
                    }
                    break;

                case 3:
                    if (personList.isEmpty()) {
                        System.out.println("No records added.");
                    } else {
                        System.out.println("All Person Records:");
                        for (Person pers : personList) {
                            System.out.println(pers.toString());
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting the program.");
                    break;
            }
        } while (choice != 4);
    }
}

class Person {
    private String name;
    private long contactNumber;
    private String birthLocation;
    private Address address;

    public Person(String name, long contactNumber, String birthLocation, Address address) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.birthLocation = birthLocation;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public String getBirthLocation() {
        return birthLocation;
    }

    public Address getAddress() {
        return address;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append("\n");
        sb.append("Contact Number: ").append(contactNumber).append("\n");
        sb.append("Birth Location: ").append(birthLocation).append("\n");
        sb.append("Address: ").append(address.toString()).append("\n");
        return sb.toString();
    }
}

class Address {
    int flatNo;
    String streetName;
    String city;
    String state;
    int pincode;

    public Address(int flatNo, String streetName, String city, String state, int pincode) {
        this.flatNo = flatNo;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    public String toString() {
        StringBuilder ad = new StringBuilder();
        ad.append(flatNo).append(", ").append(streetName).append(", ").append(city).append("-").append(pincode);
        return ad.toString();
    }
}