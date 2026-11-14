package tryouts.contactmanagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContactService service = new ContactService();

        while (true) {
            System.out.println("\n===== CONTACT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Display All Contacts");
            System.out.println("6. Total Contacts");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            String input = sc.nextLine().trim();

            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter a number.");
                continue;
            }
            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    System.out.println(service.addContact(name, phone));
                    break;
                case 2:
                    System.out.print("Enter Name to Search: ");
                    String searchName = sc.nextLine();
                    Contact contact = service.searchContact(searchName);
                    if (contact != null) {
                        System.out.println("Contact Found!");
                        System.out.println(contact);
                    } else {
                        System.out.println("Contact not found!");
                    }
                    break;
                case 3:
                    System.out.print("Enter Name to Update: ");
                    String updateName = sc.nextLine();

                    System.out.print("Enter New Phone: ");
                    String newPhone = sc.nextLine();
                    System.out.println(service.updateContact(updateName, newPhone));
                    break;
                case 4:
                    System.out.print("Enter Name to Delete: ");
                    String deleteName = sc.nextLine();
                    System.out.println(service.deleteContact(deleteName));
                    break;
                case 5:
                    service.displayContacts();
                    break;
                case 6:
                    System.out.println("Total Contacts: " + service.getContactCount());
                    break;
                case 7:
                    System.out.println("Application closed!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Select 1 to 7.");
            }
        }
    }
}
