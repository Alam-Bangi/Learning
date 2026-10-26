package tryouts.thread.multi_threading;

class KitchenOrder implements Runnable {
    private final int orderId;
    private final String dish;
    private final int preparationTime;

    public KitchenOrder(int orderId, String dish, int preparationTime) {
        this.orderId = orderId;
        this.dish = dish;
        this.preparationTime = preparationTime;
    }

    @Override
    public void run() {
        System.out.println("Order #" + orderId + " received: " + dish);

        System.out.println("Order #" + orderId + " is being prepared...");
        try {
            Thread.sleep(preparationTime * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();

            System.out.println("Order #" + orderId + " preparation interrupted.");
            return;
        }
        System.out.println("Order #" + orderId + " is READY: " + dish);
    }
}

public class OrderService {
    public static void main(String[] args) {
        System.out.println("=== RESTAURANT KITCHEN OPEN ===");

        KitchenOrder order1 = new KitchenOrder(101, "Pizza", 4);
        KitchenOrder order2 = new KitchenOrder(102, "Burger", 2);
        KitchenOrder order3 = new KitchenOrder(103, "Pasta", 3);

        Thread chef1 = new Thread(order1, "Chef-1");
        Thread chef2 = new Thread(order2, "Chef-2");
        Thread chef3 = new Thread(order3, "Chef-3");

        chef1.start();
        chef2.start();
        chef3.start();

        try {
            chef1.join();
            chef2.join();
            chef3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Kitchen manager interrupted.");
            return;
        }
        System.out.println("All orders are ready to serve!");
        System.out.println("=== KITCHEN CLOSED ===");
    }
}
