import java.util.Scanner;

class Restaurant {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice = 0;

        while (choice != 4) {
            System.out.println("\n=== Restaurant Menu ===");
            System.out.println("1. Pizza");
            System.out.println("2. Burger");
            System.out.println("3. Pasta");
            System.out.println("4. Exit");
            System.out.print("Choose a dish: ");

            choice = sc.nextInt();
            System.out.println();

            String dishName = "";

            switch (choice) {
                case 1:
                    dishName = "Pizza";
                    break;
                case 2:
                    dishName = "Burger";
                    break;
                case 3:
                    dishName = "Pasta";
                    break;
                case 4:
                    System.out.println("Exiting...");
                    continue;
                default:
                    System.out.println("Invalid choice!");
                    continue;
            }

            Order order = new Order(dishName);

            Thread chef = new Thread(order::prepareFood);
            Thread waiter = new Thread(order::serveFood);

            waiter.start();
            chef.start();

            try {
                chef.join();
                waiter.join();
            } catch (InterruptedException e) {
                System.out.println("Preparing...");
            }
        }

        sc.close();
    }
}

class Order {

    private boolean isReady = false;
    private String dish;

    public Order(String dish) {
        this.dish = dish;
    }

    public synchronized void prepareFood() {
        System.out.println("Chef is cooking " + dish + "...");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Interruption");
        }

        isReady = true;
        System.out.println(dish + " is ready!");

        notifyAll();
    }

    public synchronized void serveFood() {

        while (!isReady) {
            try {
                System.out.println("Waiter waiting for " + dish + "...");
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interruption");
            }
        }

        System.out.println("Waiter is serving " + dish + ".");
    }
}