package tryouts.map_implementations.treemap;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ShoppingPriceManager {

    static Scanner sc = new Scanner(System.in);
    static TreeMap<Double, String> products = new TreeMap<>();

    public static void main(String[] args) {
        addSampleProducts();

        int choice;
        do {
            System.out.println("\n===== SHOPPING PRICE MANAGER =====");
            System.out.println("1. Add Product");
            System.out.println("2. Display All Products");
            System.out.println("3. Search Product");
            System.out.println("4. Find Cheapest Product");
            System.out.println("5. Find Most Expensive Product");
            System.out.println("6. Display Products in Price Range");
            System.out.println("7. Remove Product");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addProduct();
                    break;

                case 2:
                    displayProducts();
                    break;

                case 3:
                    searchProduct();
                    break;

                case 4:
                    findCheapestProduct();
                    break;

                case 5:
                    findMostExpensiveProduct();
                    break;

                case 6:
                    displayPriceRange();
                    break;

                case 7:
                    removeProduct();
                    break;

                case 8:
                    exitApplication();
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 8);
        sc.close();
    }

    static void addSampleProducts() {
        products.put(499.0, "Keyboard");
        products.put(19999.0, "Laptop");
        products.put(1499.0, "Headphones");
        products.put(799.0, "Mouse");
        products.put(2999.0, "Smartwatch");
    }

    static void addProduct() {
        System.out.print("Enter product price: ");
        double price = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter product name: ");
        String name = sc.nextLine();

        if (products.containsKey(price)) {
            System.out.println("Price already exists!");
            return;
        }

        products.put(price, name);
        System.out.println("Product added successfully.");
    }

    static void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        System.out.println("\nProducts sorted by price:");

        for (Map.Entry<Double, String> entry
                : products.entrySet()) {
            System.out.println("Product: " + entry.getValue() + " | " + "Price: " + entry.getKey());
        }
    }

    static void searchProduct() {
        sc.nextLine();
        System.out.print("Enter product name to search: ");
        String name = sc.nextLine();

        boolean found = false;
        for (Map.Entry<Double, String> entry : products.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(name)) {
                System.out.println("Product found!");
                System.out.println("Name: " + entry.getValue());
                System.out.println("Price: " + entry.getKey());

                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Product not found.");
        }
    }

    static void findCheapestProduct() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        Map.Entry<Double, String> entry = products.firstEntry();

        System.out.println("Cheapest product: " + entry.getValue() + " | Price: " + entry.getKey());
    }

    static void findMostExpensiveProduct() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        Map.Entry<Double, String> entry = products.lastEntry();

        System.out.println("Most expensive product: " + entry.getValue() + " | Price: " + entry.getKey());
    }

    static void displayPriceRange() {
        System.out.print("Enter minimum price: ");
        double min = sc.nextDouble();

        System.out.print("Enter maximum price: ");
        double max = sc.nextDouble();

        if (min > max) {
            System.out.println("Invalid price range.");
            return;
        }

        Map<Double, String> result = products.subMap(min, true, max, true);

        if (result.isEmpty()) {
            System.out.println("No products found.");
            return;
        }
        System.out.println("Products in price range:");

        for (Map.Entry<Double, String> entry: result.entrySet()) {
            System.out.println( entry.getKey() + " -> " + entry.getValue());
        }
    }

    static void removeProduct() {
        sc.nextLine();

        System.out.print("Enter product name to remove: ");
        String name = sc.nextLine();

        Double priceToRemove = null;
        for (Map.Entry<Double, String> entry : products.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(name)) {
                priceToRemove = entry.getKey();
                break;
            }
        }
        if (priceToRemove != null) {
            products.remove(priceToRemove);
            System.out.println(name + " removed successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    static void exitApplication() {
        System.out.println("Thank you for using the application!");
    }
}