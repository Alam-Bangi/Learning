import java.util.*;

class GroceryStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<String> customers = new LinkedList<>();
        Map<String, Integer> visitCount = new HashMap<>();

        System.out.println("Welcome to the Grocery Store!");
        System.out.println("1. Add Customer");
        System.out.println("2. Visit Count");
        System.out.println("3. Process Customer");
        System.out.println("4. View Queue");
        System.out.println("5. Exit");

        int option;
        boolean running = true;

        do {
            System.out.println(" ");
            System.out.println("Please select an option:");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Enter customer name:");
                    String name = scanner.next();
                    customers.add(name);
                    visitCount.put(name, visitCount.getOrDefault(name, 0) + 1);
                    System.out.println(name + " added to the queue.");
                    break;

                case 2:
                    System.out.println("Visit Count:");
                    for (Map.Entry<String, Integer> entry : visitCount.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                    break;

                case 3:
                    if (!customers.isEmpty()) {
                        String customer = customers.poll();
                        System.out.println("Processing " + customer);
                    } else {
                        System.out.println("No customers in the queue.");
                    }
                    break;

                case 4:
                    System.out.println("Current Queue:" + customers);
                    break;

                case 5:
                    if (!customers.isEmpty()) {
                        System.out.println("Process the customers are waiting in queue.");
                        break;
                    } else {
                        System.out.println("Thank you for visiting the Grocery Store!");
                        running = false;
                        break;
                    }

                default:
                    System.out.println("Invalid choice!");
            }
        } while (running);

        scanner.close();
    }
}