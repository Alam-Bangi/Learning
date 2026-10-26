package tryouts.thread.multi_threading;

class PaymentTask extends Thread {
    @Override
    public void run() {
        System.out.println("Payment processing started...");

        try {
            Thread.sleep(2000); // Simulate payment processing
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
        System.out.println("Payment completed!");
    }
}

class EmailTask extends Thread {
    @Override
    public void run() {
        System.out.println("Sending order confirmation email...");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
        System.out.println("Confirmation email sent!");
    }
}

class InventoryTask extends Thread {
    @Override
    public void run() {
        System.out.println("Updating inventory...");

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
        System.out.println("Inventory updated!");
    }
}

public class MT {
    public static void main(String[] args) {
        PaymentTask payment = new PaymentTask();
        EmailTask email = new EmailTask();
        InventoryTask inventory = new InventoryTask();

        payment.start();
        email.start();
        inventory.start();

        System.out.println("Order tasks started!");
    }
}
