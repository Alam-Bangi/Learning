package com.study;

import java.util.List;
import java.util.Scanner;

public class InputData {
    Scanner sc = new Scanner(System.in);

    public Book getInput() {
        System.out.println("Enter Book Details: ");

        System.out.println("Enter Book Name: ");
        String name = sc.nextLine();

        System.out.println("Enter author name: ");
        String authorName = sc.nextLine();

        System.out.println("Enter publication name: ");
        String publication = sc.nextLine();

        return new Book(name, authorName, publication);
    }
    public String search() {
        System.out.println("Enter name: ");
        String searchName = sc.nextLine();
        return searchName;
    }
    public void displaySearchBook(List<Book> searchBook) {
        if(searchBook.isEmpty()) {
            System.out.println("No Records Found");
        } else {
            for(Book b : searchBook) {
                System.out.println(b);
            }
        }
    }
    public void displayBook(List<Book> books){
        for (Book book: books){
            System.out.println(book);
            System.out.println();
        }
    }
    public int getLineNumber() {
        System.out.print("Enter Line Number: ");
        int lineNumber = sc.nextInt();
        sc.nextLine();
        return lineNumber;
    }
    public int getOption() {
        System.out.println("Select what you want to update: ");
        System.out.println("1. Name");
        System.out.println("2. Author");
        System.out.println("3. Publication");
        int option = sc.nextInt();
        sc.nextLine();
        return option;
    }
}
