import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeSet;

public class BookstoreApp {
    public static void main(String[] args) {
        HashMap<String, Product> inventory = new HashMap<>();
        inventory.put("976", new Product("Effective Java", 455.00, 10));
        inventory.put("977", new Product("Clean Code", 388.50, 5));
        inventory.put("978", new Product("Design Patterns", 550.00, 7));
        System.out.println("All products in inventory:");
        for (Product p : inventory.values()) {
            System.out.println(p);
        }
        System.out.println();

        // Valid use case of linkedhash map
        LinkedHashMap<String, List<String>> recentViews = new LinkedHashMap<>();
        recentViews.put("user101", new ArrayList<>(List.of("977")));
        recentViews.put("user102", new ArrayList<>(List.of("978")));
        recentViews.get("user101").add("976");

        System.out.println("Recent views for user101: " + recentViews.get("user101"));
        System.out.println("All recent views (in insertion order): " + recentViews);
        System.out.println();

        Comparator<Product> byPriceThenName = new Comparator<>() {
            @Override
            public int compare(Product p1, Product p2) {
                int priceCompare = Double.compare(p1.price, p2.price);
                if (priceCompare != 0) {
                    return priceCompare;
                }
                return p1.name.compareTo(p2.name);
            }
        };
        TreeSet<Product> topSellers = new TreeSet<>(byPriceThenName);
        topSellers.add(inventory.get("977"));
        topSellers.add(inventory.get("976"));
        topSellers.add(inventory.get("978"));

        System.out.println("Top selling products (sorted by price):");
        for (Product p : topSellers) {
            System.out.println(p);
        }
    }
}
class Product {
    String name;
    double price;
    int stock;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return name + " (₹" + price + ", stock: " + stock + ")";
    }
}
