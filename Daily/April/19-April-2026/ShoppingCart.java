import java.util.Scanner;

interface OrderService {
    void placeOrder(String[] products, int[] quantities, double[] prices, int count);
}

class OnlineOrder implements OrderService {
    public void placeOrder(String[] products, int[] quantities, double[] prices, int count) {
        double grandTotal = 0;

        System.out.println("\n--- Final Order Summary ---");

        for (int i = 0; i < count; i++) {
            double total = quantities[i] * prices[i];
            grandTotal += total;

            System.out.println("Product: " + products[i]);
            System.out.println("Quantity: " + quantities[i]);
            System.out.println("Price: ₹" + prices[i]);
            System.out.println("Item Total: ₹" + total);
            System.out.println("----------------------");
        }

        System.out.println("Grand Total: ₹" + grandTotal);
        System.out.println("Payment Mode: Online");
        System.out.println("Order Placed Successfully!");
    }
}

class ShoppingCart {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] productList = { "Laptop", "Mobile", "Headphones" };
        double[] priceList = { 50000, 20000, 2000 };

        String[] cartProducts = new String[10];
        int[] cartQty = new int[10];
        double[] cartPrices = new double[10];

        int count = 0;
        char choice = 'n';

        System.out.println("=== Welcome to E-Commerce Store ===");

        do {
            System.out.println("\nAvailable Products:");

            for (int i = 0; i < productList.length; i++) {
                System.out.println((i + 1) + ". " + productList[i] + " - ₹" + priceList[i]);
            }

            System.out.print("Enter product number: ");
            int p = sc.nextInt();

            if (p < 1 || p > productList.length) {
                System.out.println("Invalid choice!");
                continue;
            }

            System.out.print("Enter quantity: ");
            int qty = sc.nextInt();

            cartProducts[count] = productList[p - 1];
            cartQty[count] = qty;
            cartPrices[count] = priceList[p - 1];

            count++;

            System.out.print("Add more items? (y/n): ");
            choice = sc.next().charAt(0);

        } while (choice == 'y' || choice == 'Y');

        OrderService order = new OnlineOrder();
        order.placeOrder(cartProducts, cartQty, cartPrices, count);

        sc.close();
    }
}