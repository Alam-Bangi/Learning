package tryouts.shoe_store_management;

import java.util.Scanner;

public class ShoeStore {
    Scanner sc = new Scanner(System.in);

    ShoeService service = new ShoeService();
    public void start() {
        int choice;
        do {
            System.out.println("\n===== SHOE STORE =====");
            System.out.println("1. Add Shoe");
            System.out.println("2. Display Shoes");
            System.out.println("3. Search Shoe");
            System.out.println("4. Edit Quantity");
            System.out.println("5. Update Price");
            System.out.println("6. Purchase Shoe");
            System.out.println("7. Delete Shoe");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter shoe name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter quantity: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();
                    service.addShoe(name, price, quantity);
                    break;
                case 2:
                    service.displayShoes();
                    break;
                case 3:
                    System.out.print("Enter shoe name: ");
                    name = sc.nextLine();
                    service.searchShoe(name);
                    break;
                case 4:
                    System.out.print("Enter shoe name: ");
                    name = sc.nextLine();

                    if (service.findShoe(name) != null) {
                        System.out.print("Enter new quantity: ");
                        quantity = sc.nextInt();
                        sc.nextLine();
                        service.editQuantity(name, quantity);
                    } else {
                        System.out.println("Shoe not found!");
                    }
                    break;
                case 5:
                    System.out.print("Enter shoe name: ");
                    name = sc.nextLine();

                    if (service.findShoe(name) != null) {
                        System.out.print("Enter new price: ");
                        price = sc.nextDouble();
                        sc.nextLine();
                        service.updatePrice(name, price);
                    } else {
                        System.out.println("Shoe not found!");
                    }
                    break;
                case 6:
                    System.out.print("Enter shoe name: ");
                    name = sc.nextLine();

                    if (service.findShoe(name) != null) {
                        System.out.print("Enter purchase quantity: ");
                        quantity = sc.nextInt();
                        sc.nextLine();
                        service.purchaseShoe(name, quantity);
                    } else {
                        System.out.println("Shoe not found!");
                    }
                    break;
                case 7:
                    System.out.print("Enter shoe name: ");
                    name = sc.nextLine();

                    service.deleteShoe(name);
                    break;
                case 8:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 8);
    }
}
