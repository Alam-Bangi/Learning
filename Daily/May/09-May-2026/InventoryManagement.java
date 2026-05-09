import java.util.*;
import java.util.stream.Collectors;

class InventoryManagement {

    public static void main(String[] args) {

        Product p1 = new Product(
                1, "Laptop", "Electronics", 10, 75000);

        Product p2 = new Product(2, "Phone", "Electronics", 25, 30000);

        Product p3 = new Product(3, "Office Chair", "Furniture", 5, 8500);

        Product p4 = new Product(4, "Desk", "Furniture", 3, 12000);

        Product p5 = new Product(5, "Water Bottle", "Accessories", 50, 500);

        List<Product> products = Arrays.asList(p1, p2, p3, p4, p5);

        Set<String> categories = products.stream()
                .map(Product::getCategory)
                .collect(Collectors.toSet());

        System.out.println("Product Categories:");

        categories.forEach(System.out::println);

        Map<Integer, Product> productMap = products.stream()
                .collect(Collectors.toMap(Product::getId,
                        product -> product));

        System.out.println("\nProduct Inventory:");

        productMap.forEach((id, product) -> System.out.println(id + " -> " + product));

        double totalValue = products.stream()
                .mapToDouble(Product::getInventoryValue)
                .sum();

        System.out.println("\nTotal Inventory Value: " + totalValue);

        List<Product> lowStock = products.stream()
                .filter(product -> product.getQuantity() < 5)
                .collect(Collectors.toList());

        System.out.println("\nLow Stock Products:");

        lowStock.forEach(System.out::println);

        Product expensiveProduct = products.stream()
                .reduce((pr1, pr2) -> pr1.getPrice() > pr2.getPrice() ? pr1 : pr2).orElse(null);

        System.out.println("\nMost Expensive Product:");

        System.out.println(expensiveProduct);

        Map<String, List<Product>> groupedProducts = new HashMap<>();

        for (Product p : products) {
            groupedProducts.computeIfAbsent(p.getCategory(), k -> new ArrayList<>()).add(p);
        }

        System.out.println("\nProducts By Category:");

        groupedProducts.forEach((category, productList) -> System.out.println(category + " -> " + productList));

        List<Product> sortedProducts = products.stream().sorted((a, b) -> Double.compare(
                b.getInventoryValue(), a.getInventoryValue()))
                .collect(Collectors.toList());

        System.out.println("\nProducts Sorted By Inventory Value:");

        sortedProducts.forEach(product -> System.out.println(product.getName() + " -> " + product.getInventoryValue()));
    }
}

class Product {

    private int id;
    private String name;
    private String category;
    private int quantity;
    private double price;

    public Product(int id, String name, String category, int quantity, double price) {

        this.id = id;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public double getInventoryValue() {
        return quantity * price;
    }

    public String toString() {
        return name + " (" + category + ", Qty: " + quantity + ", " + price + ")";
    }
}
