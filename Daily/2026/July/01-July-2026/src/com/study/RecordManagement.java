package com.study;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

class RecordManagement {

    public static void main(String[] args) throws IOException {
        PersonRecords personRecords = new PersonRecords();
        InputData inputData = new InputData();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--------------------------------------------");
            System.out.println("Person Records Management System");
            System.out.println("1. Add Person Record");
            System.out.println("2. Search Person Record");
            System.out.println("3. View All Person Records");
            System.out.println("4. Delete Record");
            System.out.println("5. Exit");
            System.out.println("--------------------------------------------");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    Person person = inputData.getInput();
                    personRecords.add(person);
                    break;
                case 2:
                    String searchName = inputData.search();
                    List<Person> searchPerson = personRecords.searchRecord(searchName);
                    inputData.displaySearchPerson(searchPerson);
                    break;
                case 3:
                    inputData.displayRecord(personRecords.getData());
                    break;
                case 4:
                    searchName = inputData.search();
                    inputData.displayDeletion(personRecords.delete(searchName));
                    break;
                case 5:
                    System.out.println("Thank You!");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 5);
        sc.close();
    }

}
