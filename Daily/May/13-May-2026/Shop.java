import java.util.*;

class Shop {

    static Scanner sc = new Scanner(System.in);

    static List<Customer> customers = new ArrayList<>();

    static Map<String, Product> inventory = new HashMap<>();

    public static void main(String[] args) {

        inventory.put("Mouse", new Product("Mouse", 1700, 5));
        inventory.put("Keyboard", new Product("Keyboard", 2500, 10));
        inventory.put("Headphone", new Product("Headphone", 2000, 15));

        int choice;

        do {
            System.out.println("\n----- SHOP MENU -----");
            System.out.println("1. Add Customer");
            System.out.println("2. View Products");
            System.out.println("3. Process Payment");
            System.out.println("4. View Customers");
            System.out.println("5. View Balance");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addCustomer();
                    break;

                case 2:
                    viewProducts();
                    break;

                case 3:
                    processPayment();
                    break;

                case 4:
                    viewCustomers();
                    break;

                case 5:
                    viewBalance();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);
    }

    private static void addCustomer() {

        System.out.print("Enter customer id: ");
        int id = sc.nextInt();
        sc.nextLine();
        if (customers.stream().anyMatch(c -> c.getId() == id)) {
            System.out.println("Customer with this ID already exists.");
            return;
        }

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        System.out.print("Enter customer balance: ");
        double balance = sc.nextDouble();

        customers.add(new Customer(id, name, balance));

        System.out.println("Customer added successfully.");
    }

    private static void viewProducts() {

        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        System.out.println("\n----- PRODUCT INVENTORY -----");

        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }

    private static void processPayment() {

        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }

        if (inventory.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        sc.nextLine();

        System.out.print("Enter product name: ");
        String productName = sc.nextLine();

        Product product = inventory.get(productName);

        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();

        if (quantity > product.getQuantity()) {
            System.out.println("Insufficient stock.");
            return;
        }

        System.out.print("Enter customer id: ");
        int id = sc.nextInt();

        Customer customer = customers.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);

        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        double totalAmount = quantity * product.getPrice();

        Payment payment = new Payment();

        try {

            payment.processPayment(customer, totalAmount);

            product.setQuantity(product.getQuantity() - quantity);

            System.out.println("Product Purchased Successfully.");

        } catch (InvalidBalanceException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void viewCustomers() {

        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }

        System.out.println("\n----- CUSTOMER LIST -----");

        customers.forEach(System.out::println);
    }

    private static void viewBalance() {

        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }

        System.out.print("Enter customer id: ");
        int id = sc.nextInt();

        Customer customer = customers.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);

        if (customer != null) {
            System.out.println("Customer: " + customer.getName()
                    + ", Balance: " + customer.getBalance());
        } else {
            System.out.println("Customer not found.");
        }
    }
}

class InvalidBalanceException extends Exception {

    public InvalidBalanceException(String message) {
        super(message);
    }
}

class Customer {

    int id;
    String name;
    double balance;

    public Customer(int id, String name, double balance) {

        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void deductBalance(double amount) {
        balance -= amount;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Balance: " + balance;
    }
}

class Product {

    String name;
    double price;
    int quantity;

    public Product(String name, double price, int quantity) {

        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return "Product: " + name
                + ", Price: " + price
                + ", Quantity: " + quantity;
    }
}

class Payment {

    public void processPayment(Customer customer, double amount)
            throws InvalidBalanceException {

        if (customer.getBalance() < amount) {

            throw new InvalidBalanceException(
                    "Insufficient balance for customer: "
                            + customer.getName());

        } else {

            customer.deductBalance(amount);

            System.out.println("Payment of " + amount
                    + " processed for customer: "
                    + customer.getName());
        }
    }
}