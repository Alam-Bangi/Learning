package com.study;

import java.util.List;
import java.util.Scanner;

public class LibraryManagement {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BookStorage bookStorage = new BookStorage();
        InputData inputData = new InputData();

        int choice;
        do {
            System.out.println("-----------------------------------");
            System.out.println("Welcome to Library Management");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book");
            System.out.println("3. Display All Books");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");
            System.out.println("-----------------------------------");

            System.out.println("Enter your choice: ");
            choice = sc. nextInt();

            switch(choice) {
                case 1:
                    Book book = inputData.getInput();
                    bookStorage.add(book);
                    break;
                case 2:
                    String searchName = inputData.search();
                    List<Book> searchBook = bookStorage.search(searchName);
                    inputData.displaySearchBook(searchBook);
                    break;
                case 3:
                    inputData.displayBook(bookStorage.get());
                    break;
                case 4:
                    searchName = inputData.search();
                    bookStorage.delete(searchName);
                case 5:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice!= 5);
    }
}
