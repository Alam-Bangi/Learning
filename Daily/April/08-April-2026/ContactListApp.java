import java.util.ArrayList;
import java.util.Scanner;

class ContactListApp {

    static ArrayList<Contact> contacts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== CONTACT LIST MENU =====");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Remove Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter a number.");
                sc.next();
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addContact();
                    break;

                case 2:
                    viewContacts();
                    break;

                case 3:
                    searchContact();
                    break;

                case 4:
                    removeContact();
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 5);

        sc.close();
    }

    static void addContact() {
        System.out.print("Enter contact name: ");
        String name = sc.nextLine();

        for (Contact c : contacts) {
            if (c.name.equalsIgnoreCase(name)) {
                System.out.println("Contact already exists.");
                return;
            }
        }

        System.out.print("Enter contact number: ");
        String number = sc.nextLine();

        contacts.add(new Contact(name, number));
        System.out.println("Contact added!");
    }

    static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        System.out.println("Contact List:");
        for (int i = 0; i < contacts.size(); i++) {
            Contact c = contacts.get(i);
            System.out.println((i + 1) + ". " + c.name + " - " + c.number);
        }
    }

    static void searchContact() {
        System.out.print("Enter name to search: ");
        String search = sc.nextLine();

        boolean found = false;

        for (Contact c : contacts) {
            if (c.name.equalsIgnoreCase(search)) {
                System.out.println("Found: " + c.name + " - " + c.number);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    static void removeContact() {
        System.out.print("Enter name to remove: ");
        String name = sc.nextLine();

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).name.equalsIgnoreCase(name)) {
                contacts.remove(i);
                System.out.println("Contact removed.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }
}

class Contact {
    String name;
    String number;

    Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }
}