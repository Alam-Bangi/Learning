import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class LibraryRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isBookAdded = false;
        boolean isJournalAdded = false;

        Library<Book> books = new Library<>();
        Library<Journal> journals = new Library<>();

        int choice;

        do {
            System.out.println("\n----Welcome to Digital Library System----");
            System.out.println("1. Add Book");
            System.out.println("2. Add Journal");
            System.out.println("3. Display Books");
            System.out.println("4. Display Journals");
            System.out.println("5. Search Book");
            System.out.println("6. Issue Book");
            System.out.println("7. Return Book");
            System.out.println("8. Search Journal");
            System.out.println("9. Issue Journal");
            System.out.println("10. Return Journal");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String bookTitle = sc.nextLine();
                    System.out.print("Enter author: ");
                    String authorName = sc.nextLine();
                    books.addItem(new Book(bookTitle, authorName));
                    isBookAdded = true;
                    break;
                case 2:
                    System.out.print("Enter journal title: ");
                    String journalTitle = sc.nextLine();
                    System.out.print("Enter volume ");
                    int volume = sc.nextInt();
                    sc.nextLine();
                    journals.addItem(new Journal(journalTitle, volume));
                    isJournalAdded = true;
                    break;
                case 3:
                    books.displayItems();
                    break;
                case 4:
                    journals.displayItems();
                    break;
                case 5:
                    if (isBookAdded) {
                        System.out.print("Enter book name to search: ");
                        books.searchItem(sc.nextLine());
                    } else {
                        System.out.println("No items to search");
                    }
                    break;
                case 6:
                    if (isBookAdded) {
                        System.out.print("Enter book name to issue: ");
                        books.issueItem(sc.nextLine());
                    } else {
                        System.out.println("No items to issue");
                    }
                    break;
                case 7:
                    if (isBookAdded) {
                        System.out.print("Enter book name to return: ");
                        books.returnItem(sc.nextLine());
                    } else {
                        System.out.println("No items issued");
                    }
                    break;
                case 8:
                    if (isJournalAdded) {
                        System.out.print("Enter journal name to search: ");
                        journals.searchItem(sc.nextLine());
                    } else {
                        System.out.println("No items to search");
                    }
                    break;
                case 9:
                    if (isJournalAdded) {
                        System.out.print("Enter journal name to issue: ");
                        journals.issueItem(sc.nextLine());
                    } else {
                        System.out.println("No items to issue");
                    }
                    break;
                case 10:
                    if (isJournalAdded) {
                        System.out.print("Enter journal name to return: ");
                        journals.returnItem(sc.nextLine());
                    } else {
                        System.out.println("No items issued");
                    }
                    break;
                case 0:
                    System.out.println("Exiting!!!");
                    sc.close();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 0);
    }
}

abstract class LibraryItem {
    String title;
    boolean isIssued;

    LibraryItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean isIssued) {
        this.isIssued = isIssued;
    }

    abstract public String toString();
}

class Library<T extends LibraryItem> {
    List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
        System.out.println("Item added.!");
    }

    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("No items to display");
        }
        for (T item : items) {
            System.out.println(item);
        }
    }

    public void searchItem(String title) {
        boolean found = false;
        for (T item : items) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Found: " + item);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Item not found");
        }
    }

    public void issueItem(String title) {
        for (T item : items) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                if (!item.isIssued()) {
                    item.setIssued(true);
                    System.out.println("Item issued");
                } else {
                    System.out.println("Item already issued");
                }
                return;
            }
        }
        System.out.println("Item not found");
    }

    public void returnItem(String title) {
        for (T item : items) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                if (item.isIssued) {
                    System.out.println("Item returned ");
                    item.setIssued(false);
                } else {
                    System.out.println("Item was not issued");
                }
                return;
            }
        }
        System.out.println("Item not found");
    }
}

class Book extends LibraryItem {
    String author;

    Book(String title, String author) {
        super(title);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public String toString() {
        return title + " by " + author;
    }
}

class Journal extends LibraryItem {
    int volume;

    Journal(String title, int volume) {
        super(title);
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public String toString() {
        return "Journal- " + title + " Volume- " + volume;
    }
}