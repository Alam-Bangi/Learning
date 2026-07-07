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
            System.out.println("1. Add book");
            System.out.println("2. Search book");
            System.out.println("3. Display all books");
            System.out.println("4. Delete book");
            System.out.println("5. Add book at specific index");
            System.out.println("6. Update book");
            System.out.println("7. Clear all books");
            System.out.println("8. Exit");
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
                    break;
                case 5:
                    int line = inputData.getLineNumber();
                    bookStorage.addAtSpecificIndex(inputData.getInput(), line);
                    break;
                case 6:
                    System.out.println("Enter name you want to update");
                    searchName = inputData.search();
                    System.out.println("Enter name to replace");
                    String replacement = inputData.search();
                    bookStorage.update(searchName, replacement);
                    break;
                case 7:
                    bookStorage.clearFile();
                    break;
                case 8:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice!= 8);
    }
}
