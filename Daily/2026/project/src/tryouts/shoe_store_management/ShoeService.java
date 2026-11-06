package tryouts.shoe_store_management;

import java.util.ArrayList;

public class ShoeService {
    private ArrayList<Shoe> shoes = new ArrayList<>();

    public Shoe findShoe(String name) {
        for (Shoe shoe : shoes) {
            if (shoe.getName().equalsIgnoreCase(name)) {
                return shoe;
            }
        }
        return null;
    }

    public void addShoe(String name, double price, int quantity) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Shoe name cannot be empty!");
            return;
        }

        if (price <= 0) {
            System.out.println("Invalid shoe price!");
            return;
        }

        if (quantity <= 0) {
            System.out.println("Invalid shoe quantity!");
            return;
        }

        Shoe existing = findShoe(name.trim());

        if (existing != null) {
            existing.addQuantity(quantity);
            System.out.println("Shoe already exists!");
            System.out.println("Quantity updated successfully!");
        } else {
            shoes.add(new Shoe(name.trim(), price, quantity));
            System.out.println("Shoe added successfully!");
        }
    }

    public void displayShoes() {
        if (shoes.isEmpty()) {
            System.out.println("Inventory is empty!");
            return;
        }

        System.out.println("\n======= SHOE INVENTORY =======");
        for (Shoe shoe : shoes) {
            shoe.display();
        }
    }

    public void searchShoe(String name) {
        Shoe shoe = findShoe(name);
        if (shoe == null) {
            System.out.println("Shoe not found!");
        } else {
            System.out.println("\nShoe Found:");
            shoe.display();
        }
    }

    public void editQuantity(String name, int quantity) {
        Shoe shoe = findShoe(name);
        if (shoe == null) {
            System.out.println("Shoe not found!");
            return;
        }

        if (quantity < 0) {
            System.out.println("Quantity cannot be negative!");
            return;
        }

        shoe.setQuantity(quantity);
        System.out.println("Quantity updated successfully!");
    }

    public void updatePrice(String name, double price) {
        Shoe shoe = findShoe(name);
        if (shoe == null) {
            System.out.println("Shoe not found!");
            return;
        }

        if (price <= 0) {
            System.out.println("Invalid shoe price!");
            return;
        }

        shoe.setPrice(price);
        System.out.println("Price updated successfully!");
    }

    public void purchaseShoe(String name, int quantity) {
        Shoe shoe = findShoe(name);
        if (shoe == null) {
            System.out.println("Shoe not found!");
            return;
        }

        if (quantity <= 0) {
            System.out.println("Purchase quantity must be greater than zero!");
            return;
        }

        if (quantity > shoe.getQuantity()) {
            System.out.println("Insufficient stock!");
            System.out.println("Available quantity: " + shoe.getQuantity());
            return;
        }
        double total = shoe.getPrice() * quantity;

        shoe.setQuantity(shoe.getQuantity() - quantity);
        System.out.println("\n======= PURCHASE BILL =======");
        System.out.println("Shoe Name: " + shoe.getName());
        System.out.println("Price: " + shoe.getPrice());
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Amount: " + total);
        System.out.println("Purchase successful!");
    }

    public void deleteShoe(String name) {
        Shoe shoe = findShoe(name);
        if (shoe == null) {
            System.out.println("Shoe not found!");
        } else {
            shoes.remove(shoe);
            System.out.println("Shoe deleted successfully!");
        }
    }
}
