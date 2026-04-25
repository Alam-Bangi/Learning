import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class InventoryManagement {

    public static void main(String[] args) {

        Map<String, Integer> inventory = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n===== INVENTORY MENU =====");
            System.out.println("1. Add Product");
            System.out.println("2. Update Stock");
            System.out.println("3. View Inventory");
            System.out.println("4. Remove Product");
            System.out.println("5. Search Product");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter product name: ");
                    String name = sc.nextLine();
                    name.toLowerCase();

                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();

                    inventory.put(name, qty);
                    System.out.println("Product added successfully!");
                    break;

                case 2:
                    if (inventory.isEmpty()) {
                        System.out.println("No products added yet!!");
                        break;
                    }

                    System.out.print("Enter product name to update: ");
                    String updateName = sc.nextLine();
                    updateName.toLowerCase();

                    if (inventory.containsKey(updateName)) {
                        System.out.print("Enter new quantity: ");
                        int newQty = sc.nextInt();
                        inventory.put(updateName, newQty);
                        System.out.println("Stock updated!");
                    } else {
                        System.out.println("Product not found!");
                    }
                    break;

                case 3:
                    System.out.println("\n--- Inventory ---");
                    if (inventory.isEmpty()) {
                        System.out.println("Inventory is empty.");
                    } else {
                        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
                            System.out.println("Product: " + entry.getKey() +
                                    " | Quantity: " + entry.getValue());
                        }
                    }
                    break;

                case 4:
                    if (inventory.isEmpty()) {
                        System.out.println("No products added yet!!");
                        break;
                    }

                    System.out.print("Enter product name to remove: ");
                    String removeName = sc.nextLine();

                    if (inventory.remove(removeName) != null) {
                        System.out.println("Product removed!");
                    } else {
                        System.out.println("Product not found!");
                    }
                    break;

                case 5:
                    if (inventory.isEmpty()) {
                        System.out.println("No products added yet!!");
                        break;
                    }

                    System.out.print("Enter product name to search: ");
                    String searchName = sc.nextLine();

                    if (inventory.containsKey(searchName)) {
                        System.out.println("Stock: " + inventory.get(searchName));
                    } else {
                        System.out.println("Product not found!");
                    }
                    break;

                case 6:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}