
/** 
Write a Python program for department library which has N books, write functions for following:
3
a) Delete the duplicate entries
b) Display books in ascending order based on cost of books
c) Count number of books with cost more than 500.
d) Copy books in a new list which has cost less than 500.
*/

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Assignment3 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();

        int choice = 0;
        while (choice != 4) {
            System.out.println("\n-----------------------------");
            System.out.println("Welcome to Library Management System");
            System.out.println("1. Add Books");
            System.out.println("2. View Books");
            System.out.println("3. Get Books above a certain price");
            System.out.println("4. Exit");
            System.out.println("-----------------------------");
            System.out.println("Please enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    books = addBooks(books);
                    books = removeDuplicateBooks(books);
                    break;
                case 2:
                    viewBooks(books);
                    break;
                case 3:
                    if (books.isEmpty()) {
                        System.out.println("No books added yet.");
                        break;
                    }
                    System.out.println("Enter price to filter books(Books above given price): ");
                    double price = sc.nextDouble();
                    List<Book> filteredBooks = filterByPrice(books, price);
                    System.out.println("Books priced above " + price + " are: ");
                    for (Book book : filteredBooks) {
                        System.out.println(book);
                    }
                    break;
                case 4:
                    System.out.println("Exiting ....");
                    break;
                default:
                    System.out.println("Invalid choice. Exiting ....");
                    break;
            }
        }
    }

    public static List<Book> addBooks(List<Book> books) {

        System.out.println("Enter the number of books: ");
        int numberOfBooks = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numberOfBooks; i++) {
            System.out.println("\nEnter details for book " + (i + 1) + ": ");
            System.out.println("Enter book id: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter book title: ");
            String title = sc.nextLine();

            System.out.println("Enter book price: ");
            double price = sc.nextDouble();
            while (price < 0) {
                System.out.println("Price cannot be negative. Please enter valid price.");
                sc.nextLine();
                price = sc.nextDouble();
            }

            books.add(new Book(id, title, price));

        }
        return books;
    }

    public static void viewBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books added yet.");
            return;
        } else {
            System.out.println("\nBooks in library: ");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public static List<Book> removeDuplicateBooks(List<Book> books) {
        Set<Integer> seenIds = new HashSet<>();
        List<Book> uniqueBooks = new ArrayList<>();

        for (Book book : books) {
            if (!seenIds.contains(book.id)) {
                uniqueBooks.add(book);
                seenIds.add(book.id);
            }
        }
        return uniqueBooks;
    }

    public static List<Book> filterByPrice(List<Book> books, double price) {
        List<Book> filteredBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.price < price) {
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }

    public static List<Book> removeDuplicates(List<Book> books) {
        Set<Book> uniqueBooks = new HashSet<>(books);
        for (Book book : uniqueBooks) {
            if (uniqueBooks.contains(book.id)) {
                uniqueBooks.remove(book);
            }
        }
        return new ArrayList<>(uniqueBooks);
    }
}

class Book {
    int id;
    String title;
    double price;

    public Book(int id, String title, double price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public String toString() {
        return "Book id = " + id + ", title = " + title + ", price = " + price;
    }
}
