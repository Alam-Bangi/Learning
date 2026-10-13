package tryouts.map_implementations.hashmap;

import java.util.Scanner;

public class ECommerceApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductService service = new ProductService();

        service.addProduct(new Product(101, "iPhone 16", 69999.00, 10));
        service.addProduct(new Product(102, "Samsung Galaxy S25",79999.00, 15));
        service.addProduct(new Product(103, "Sony Headphones",9999.00, 20));

        int choice;
        do {
            System.out.println("\n==================================");
            System.out.println("      E-COMMERCE MANAGEMENT");
            System.out.println("==================================");
            System.out.println("1. Add Product");
            System.out.println("2. Search Product");
            System.out.println("3. Display All Products");
            System.out.println("4. Purchase Product");
            System.out.println("5. Remove Product");
            System.out.println("6. Exit");
            System.out.println("==================================");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Enter a valid number: ");
                sc.next();
            }

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter product ID: ");
                    int id = readInt(sc);

                    sc.nextLine();
                    System.out.print("Enter product name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter product price: ");
                    double price = readDouble(sc);

                    System.out.print("Enter stock quantity: ");
                    int stock = readInt(sc);

                    if (price < 0 || stock < 0) {
                        System.out.println("Price and stock cannot be negative.");
                    } else {
                        service.addProduct(new Product(id, name, price, stock));
                    }
                    break;

                case 2:
                    System.out.print("Enter product ID to search: ");
                    service.searchProduct(readInt(sc));
                    break;

                case 3:
                    service.displayProducts();
                    break;

                case 4:
                    System.out.print("Enter product ID: ");
                    int purchaseId = readInt(sc);

                    System.out.print("Enter quantity: ");
                    int quantity = readInt(sc);

                    service.purchaseProduct(purchaseId, quantity);
                    break;

                case 5:
                    System.out.print("Enter product ID to remove: ");
                    service.removeProduct(readInt(sc));
                    break;

                case 6:
                    System.out.println("Thank you for using the application!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
        sc.close();
    }

    private static int readInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Enter a valid integer: ");
            sc.next();
        }
        return sc.nextInt();
    }

    private static double readDouble(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.print("Enter a valid number: ");
            sc.next();
        }
        return sc.nextDouble();
    }
}