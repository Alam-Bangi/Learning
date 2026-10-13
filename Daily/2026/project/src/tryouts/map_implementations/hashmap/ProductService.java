package tryouts.map_implementations.hashmap;

import java.util.HashMap;
import java.util.Map;

public class ProductService {
    private final Map<Integer, Product> productMap = new HashMap<>();

    public void addProduct(Product product) {
        if (productMap.containsKey(product.getProductId())) {
            System.out.println("Product ID already exists!");
            return;
        }
        productMap.put(product.getProductId(), product);
        System.out.println("Product added successfully.");
    }

    public void searchProduct(int productId) {
        Product product = productMap.get(productId);

        if (product == null) {
            System.out.println("Product not found.");
        } else {
            System.out.println(product);
        }
    }

    public void displayProducts() {
        if (productMap.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        System.out.println("\n========== PRODUCT INVENTORY ==========");
        for (Product product : productMap.values()) {
            System.out.println(product);
        }
    }

    public void purchaseProduct(int productId, int quantity) {
        Product product = productMap.get(productId);
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }
        if (!product.reduceStock(quantity)) {
            System.out.println("Invalid quantity or insufficient stock.");
            return;
        }
        double total = product.getPrice() * quantity;

        System.out.println("\n========== PURCHASE BILL ==========");
        System.out.println("Product : " + product.getProductName());
        System.out.println("Quantity: " + quantity);
        System.out.printf("Total   : Rs. %.2f%n", total);
        System.out.println("Purchase successful!");
    }

    public void removeProduct(int productId) {
        Product removed = productMap.remove(productId);
        if (removed == null) {
            System.out.println("Product not found.");
        } else {
            System.out.println("Product removed: " + removed.getProductName());
        }
    }
}