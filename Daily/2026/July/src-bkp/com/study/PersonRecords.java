package com.study;

import java.util.*;
import java.util.List;
import java.io.IOException;
import java.nio.file.*;

class PersonRecords {

    private static final String FILE_NAME = "record.txt";

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();
        RecordManagement recordManagement = new RecordManagement();
        recordManagement.addRecordsToList();

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
                    recordManagement.addPersonRecord();

                    break;
                case 2:

                    recordManagement.isRecordExists();
                    recordManagement.isFileEmpty("record.txt");
                    String searchName;
//                    System.out.println(personList);
                    System.out.print("Enter the name to search: ");
                    searchName = sc.nextLine();
                    recordManagement.searchRecord(searchName);

                    break;

                case 3:

                    recordManagement.displayRecords();
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

}
