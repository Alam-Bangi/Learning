import java.util.HashMap;
import java.util.Map;

class GroceryStore {
    public static void main(String[] args) {

        Map<String, Integer> inventory = new HashMap<>();

        inventory.put("Milk", 20);
        inventory.put("Bread", 15);
        inventory.put("Eggs", 30);
        inventory.put("Rice", 10);

        System.out.println("Inventory:");
        System.out.println(inventory);

        int milkStock = inventory.get("Milk");
        System.out.println("\nMilk stock: " + milkStock);
        
        if (inventory.containsKey("Bread")) {
            System.out.println("\nBread is available.");
        }

        int currentEggs = inventory.get("Eggs");
        inventory.put("Eggs", currentEggs - 5);

        System.out.println("\nInventory after selling 5 eggs:");
        System.out.println(inventory);

        inventory.replace("Rice", 25);
        System.out.println("\nInventory after restocking Rice:");
        System.out.println(inventory);

        inventory.remove("Bread");
        System.out.println("\nInventory after removing Bread:");
        System.out.println(inventory);

        System.out.println("\nProduct Details:");
        for (Map.Entry<String, Integer> item : inventory.entrySet()) {
            System.out.println(item.getKey() + " - " + item.getValue());
        }

        System.out.println("\nAvailable Products:");
        for (String product : inventory.keySet()) {
            System.out.println(product);
        }

        System.out.println("\nStock Quantities:");
        for (Integer quantity : inventory.values()) {
            System.out.println(quantity);
        }

        System.out.println("\nUsing forEach:");
        inventory.forEach((product, quantity) -> {
            System.out.println(product + " : " + quantity);
        });

        inventory.replace("Milk", 7);
        System.out.println("\nLow Stock Items:");
        for (Map.Entry<String, Integer> item : inventory.entrySet()) {
            if (item.getValue() < 15) {
                System.out.println(item.getKey() + " is running low.");
            } else {
                System.out.println(item.getKey() + " is in stock.");
            }
        }
    }
}