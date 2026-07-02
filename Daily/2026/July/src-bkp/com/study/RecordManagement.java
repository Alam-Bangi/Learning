package com.study;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class RecordManagement {
    Scanner sc = new Scanner(System.in);
    static List<Person> personList = new ArrayList<>();

    public static boolean isRecordExists() {
        Path filePath = Paths.get("record.txt");

        if (Files.exists(filePath)) {
            return true;
        }
        return false;
    }

    public static boolean isFileEmpty(String name) throws IOException {
        Path filePath = Paths.get(name);
        if (Files.exists(filePath) && Files.size(filePath) == 0) {
            System.out.println("No records found.");
            return true;
        }
        return false;
    }

    public boolean isContactNumberValid(long contactNumber) {
        String contactNumberStr = String.valueOf(contactNumber);
        return contactNumberStr.length() == 10;
    }

    public static void addRecordsToList() {
        Path filePath = Paths.get("record.txt");

        if (Files.exists(filePath)) {
            try {
                // List<Person> personList = new ArrayList<>();
                List<String> pastRecords = Files.readAllLines(filePath);
                int count = pastRecords.size();
                int counter = 1;
                Person p = new Person();
                Address address = new Address();
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
                        String[] addressParts = addressStr.split(",");
                        int flatNo = Integer.parseInt(addressParts[0].trim());
                        String streetName = addressParts[1].trim();
                        String city = addressParts[2].trim();
                        String state = addressParts[3].trim();
                        int pincode = Integer.parseInt(addressParts[4].trim());
                        // Address address = new Address(flatNo, streetName, city, state, pincode);
                        address.setFlatNo(flatNo);
                        address.setStreetName(streetName);
                        address.setCity(city);
                        address.setState(state);
                        address.setPincode(pincode);
                    }
                    if (record.equals(" ")) {
                        // Do nothing
                    }
                    if (counter % 5 == 0) {
                        p.setAddress(address);
                        personList.add(p);
                        p = new Person();
                        address = new Address();
                    }
                    counter++;
                }

//                System.out.println("\nAll Person Records:\n" + personList);
            } catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
            }
        } else {
            System.out.println("No records found.");
        }
    }
    public void displayRecords() {
        Path filePath = Paths.get("record.txt");

        if (Files.exists(filePath)) {
            try {
                // List<Person> personList = new ArrayList<>();
                List<String> pastRecords = Files.readAllLines(filePath);
                if(pastRecords.isEmpty()) {
                    System.out.println("Records not found.");
                }
                for(String rec : pastRecords) {
                    System.out.println(rec);
                }
            }  catch (IOException e) {
                System.out.println("No Record found");
            }
        }
    }

    public static void searchRecord(String searchName) throws IOException {
        Path filePath = Paths.get("record.txt");

        if (isRecordExists() && !isFileEmpty("record.txt")) {
            for (Person pers : personList) {
                if (pers.toString().toLowerCase().contains(searchName.toLowerCase())) {
                    System.out.println("Record found:");
                    System.out.println(pers);
                    System.out.println();
                }
            }
        } else {
            System.out.println("No records found.");
        }
    }

    public void addPersonRecord() {
        System.out.println("\nEnter Person Details");

        System.out.print("Name: ");
        String name = sc.nextLine();

        long contactNumber;
        while (true) {

            System.out.print("Contact Number (10 digits): ");
            contactNumber = sc.nextLong();
            sc.nextLine();
            if (isContactNumberValid(contactNumber)) {
                break;
            } else {
                System.out.println("Invalid contact number. Please enter a 10-digit number.");
            }
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

        try {
            List<String> lines = Arrays.asList(person.toString());

            Files.write(
                    Paths.get("record.txt"), // Which file to write to
                    lines, // What to write
                    StandardOpenOption.CREATE, // Create file if it doesn't exist
                    StandardOpenOption.APPEND // Add to the end instead of replacing
            );

            System.out.println("Record added successfully.");

        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }
}
