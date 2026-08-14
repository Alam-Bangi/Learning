package tryouts.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
    private static final AtomicInteger orderId = new AtomicInteger(1000);

    public static void createOrder(String customerName) {
        int newOrderId = orderId.incrementAndGet();
        System.out.println(customerName + " created Order ID: " + newOrderId);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread customer1 = new Thread(() -> createOrder("Rahul"));
        Thread customer2 = new Thread(() -> createOrder("Priya"));
        Thread customer3 = new Thread(() -> createOrder("Amit"));
        Thread customer4 = new Thread(() -> createOrder("Sneha"));
        Thread customer5 = new Thread(() -> createOrder("Kartik"));
        Thread customer6 = new Thread(() -> createOrder("Kart"));

        customer1.start();
        customer2.start();
        customer3.start();
        customer4.start();
        customer5.start();
        customer6.start();

        customer1.join();
        customer2.join();
        customer3.join();
        customer4.join();
        customer5.join();
        customer6.join();

        System.out.println("Next available Order ID: " + orderId.get());

    }
}