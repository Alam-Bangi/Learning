```
import java.util.*;
import java.util.stream.*;

class Main {
    public static void main(String[] args) {

        List<Order> orders = List.of(
            new Order("Alice", List.of(
                new Item("Laptop", 50000, 1),
                new Item("Mouse", 500, 2)
            ), "COMPLETED"),

            new Order("Bob", List.of(
                new Item("Keyboard", 1500, 1)
            ), "PENDING"),

            new Order("Alice", List.of(
                new Item("Monitor", 12000, 1)
            ), "COMPLETED")
        );

        // 🔥 Single pipeline processing
        Map<String, Double> spendingByCustomer =
            orders.stream()
                  .filter(o -> "COMPLETED".equals(o.status))                 // filter
                  .collect(Collectors.groupingBy(
                      o -> o.customer,
                      Collectors.flatMapping(
                          o -> o.items.stream(),                            // flatMap
                          Collectors.summingDouble(Item::totalPrice)        // map + reduce
                      )
                  ));

        // Top customer
        String topCustomer =
            spendingByCustomer.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(e -> "Top customer: " + e.getKey() + " spent " + e.getValue())
                .orElse("No data");

        // All items (flatten once)
        List<Item> allItems =
            orders.stream()
                  .filter(o -> "COMPLETED".equals(o.status))
                  .flatMap(o -> o.items.stream())
                  .toList();

        // Partition + unique + summary
        Map<Boolean, List<Item>> partitioned =
            allItems.stream()
                    .collect(Collectors.partitioningBy(i -> i.totalPrice() > 10000));

        String itemSummary =
            allItems.stream()
                    .map(i -> i.name)
                    .distinct()
                    .sorted()
                    .collect(Collectors.joining(", "));

        double totalRevenue =
            allItems.stream()
                    .mapToDouble(Item::totalPrice)
                    .sum();

        // Debug (peek)
        allItems.stream()
                .peek(i -> System.out.println("Processing: " + i.name))
                .map(Item::totalPrice)
                .forEach(System.out::println);

        // Final outputs
        System.out.println("\nRevenue: " + totalRevenue);
        System.out.println(topCustomer);
        System.out.println("Items: " + itemSummary);
        System.out.println("Expensive Items: " + partitioned.get(true));
    }
}

// Models
class Item {
    String name;
    double price;
    int quantity;

    Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    double totalPrice() {
        return price * quantity;
    }

    public String toString() {
        return name + "(" + totalPrice() + ")";
    }
}

class Order {
    String customer;
    List<Item> items;
    String status;

    Order(String customer, List<Item> items, String status) {
        this.customer = customer;
        this.items = items;
        this.status = status;
    }
}
```
# ex
```
🟢 Basic Level (Warm-up)

1. Filter completed orders
👉 Question:
Given a list of orders, return only those with status "COMPLETED".

    List<Order> result = orders.stream()
        .filter(o -> "COMPLETED".equals(o.status))
        .toList();

2. Extract all items from orders
👉 Question:
Convert List<Order> into List<Item>.

    List<Item> items = orders.stream()
        .flatMap(o -> o.items.stream())
        .toList();

3. Calculate total revenue
👉 Question:
Find total price of all items.

    double total = orders.stream()
        .flatMap(o -> o.items.stream())
        .map(Item::totalPrice)
        .reduce(0.0, Double::sum);

🟡 Intermediate Level

4. Group orders by customer
👉 Question:
Group all orders by customer name.

    Map<String, List<Order>> grouped =
        orders.stream()
            .collect(Collectors.groupingBy(o -> o.customer));

5. Total spending per customer
👉 Question:
Return total amount spent by each customer.

    Map<String, Double> spending =
        orders.stream()
            .filter(o -> "COMPLETED".equals(o.status))
            .collect(Collectors.groupingBy(
                o -> o.customer,
                Collectors.flatMapping(
                    o -> o.items.stream(),
                    Collectors.summingDouble(Item::totalPrice)
                )
            ));

6. Find top customer
👉 Question:
Find the customer who spent the most.

    Optional<Map.Entry<String, Double>> top =
        spending.entrySet().stream()
            .max(Map.Entry.comparingByValue());

7. Sort customers by spending
👉 Question:
Return customers sorted by highest spending.

    List<Map.Entry<String, Double>> sorted =
        spending.entrySet().stream()
            .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
            .toList();

🔵 Advanced Level

8. Partition items (expensive vs cheap)
👉 Question:
Split items into >10000 and ≤10000.

    Map<Boolean, List<Item>> partition =
        orders.stream()
            .flatMap(o -> o.items.stream())
            .collect(Collectors.partitioningBy(
                i -> i.totalPrice() > 10000
            ));

9. Get unique item names
👉 Question:
Return all unique product names.

    Set<String> unique =
        orders.stream()
            .flatMap(o -> o.items.stream())
            .map(i -> i.name)
            .collect(Collectors.toSet());

10. Join item names into string
👉 Question:
Convert all product names into comma-separated string.

    String result =
        orders.stream()
            .flatMap(o -> o.items.stream())
            .map(i -> i.name)
            .distinct()
            .sorted()
            .collect(Collectors.joining(", "));

🔴 Tricky / Expert Level

11. Handle duplicate customers (merge lists)
👉 Question:
Convert orders into Map<Customer, List<Item>>.

    Map<String, List<Item>> map =
        orders.stream()
            .collect(Collectors.toMap(
                o -> o.customer,
                o -> o.items,
                (l1, l2) -> {
                    List<Item> merged = new ArrayList<>(l1);
                    merged.addAll(l2);
                    return merged;
                }
            ));

12. Use Optional safely
👉 Question:
Print top customer or default message.

    String output =
        top.map(e -> e.getKey() + " spent " + e.getValue())
        .orElse("No customers");

13. Find most expensive item
👉 Question:
Return item with highest total price.

    Optional<Item> maxItem =
        orders.stream()
            .flatMap(o -> o.items.stream())
            .max(Comparator.comparing(Item::totalPrice));

14. Count items per customer
👉 Question:
Return number of items per customer.

    Map<String, Long> count =
        orders.stream()
            .collect(Collectors.groupingBy(
                o -> o.customer,
                Collectors.flatMapping(
                    o -> o.items.stream(),
                    Collectors.counting()
                )
            ));

15. Multi-level grouping
👉 Question:
Group by customer → then by item name.

    Map<String, Map<String, List<Item>>> multi =
        orders.stream()
            .collect(Collectors.groupingBy(
                o -> o.customer,
                Collectors.flatMapping(
                    o -> o.items.stream(),
                    Collectors.groupingBy(i -> i.name)
                )
            ));

🧠 Interview Tips (Important)
    Prefer groupingBy + collectors over manual maps
    Use flatMap whenever you see nested collections
    Use method references (Item::totalPrice)
    Avoid side effects inside streams
    Know when to use parallelStream (rarely in interviews)
```
