package com.study;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class InputData {

    private Scanner sc = new Scanner(System.in);

    public Person getInput(){
        System.out.println("\nEnter Person Details");

        System.out.print("Name: ");
        String name = sc.nextLine();

        long contactNumber;
        while (true) {

            System.out.print("Contact Number (10 digits): ");
            contactNumber = sc.nextLong();
            sc.nextLine();
            if (Person.isContactNumberValid(contactNumber)) {
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
        return person;
    }

    public String search() {
        String searchName;
        System.out.print("Enter the name to search: ");
        searchName = sc.nextLine();
        return searchName;
    }

    public void displaySearchPerson(List<Person> searchPerson) {
        if(searchPerson.isEmpty()) {
            System.out.println("No Records Found");
        } else {
            for(Person p : searchPerson) {
                System.out.println(p);
            }
        }
    }

    public void displayRecord(List<Person> persons){
        for (Person person: persons){
            System.out.println(person);
        }
    }

    public void displayDeletion(boolean delete) {
//        if(delete == false) {
//            System.out.println("No record found");
//        } else {
//            System.out.println("Record deleted successfully");
//        }
//        String result = delete ? "Record deleted successfully" : "No record found" ;
//        System.out.println(result);

        System.out.println((delete) ? "Record deleted successfully" : "No record found");
    }
}
