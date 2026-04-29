import java.util.List;

class Orders {
    public static void main(String[] args) {

        List<Order> orders = List.of(
                new Order("Laptop", 50000),
                new Order("Mouse", 500),
                new Order("Keyboard", 1500));

        System.out.println("Before Discount: ");
        orders.forEach(i -> System.out.println(i));
        System.out.println("\nAfter Discount(only discounted products): ");

        List<Order> discountedOrders = orders.stream()
                .filter(order -> order.getPrice() > 1000)
                .map(order -> new Order(order.getItem(), order.getPrice() * 0.9))
                .toList();

        discountedOrders.forEach(o -> System.out.println(o.getItem() + " - " + o.getPrice()));
    }
}

class Order {
    private String item;
    private double price;

    public Order(String item, double price) {
        this.item = item;
        this.price = price;
    }

    public String getItem() {
        return item;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return item + " - " + price;
    }
}