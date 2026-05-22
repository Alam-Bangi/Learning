import java.util.Scanner;

class FoodOrderRunner {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== Food Delivery Order System =====");

        System.out.print("Enter Order ID: ");
        int orderId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Customer Name: ");
        String customerName = sc.nextLine();

        System.out.print("Enter Food Item Name: ");
        String itemName = sc.nextLine();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        System.out.print("Enter Price Per Item: ");
        double price = sc.nextDouble();

        FoodOrder order = new FoodOrder(orderId, customerName, itemName, quantity, price);

        System.out.println("\n----- Order Summary -----");
        System.out.println("Order ID      : " + order.orderId());
        System.out.println("Customer Name : " + order.customerName());
        System.out.println("Food Item     : " + order.itemName());
        System.out.println("Quantity      : " + order.quantity());
        System.out.println("Price Per Item: " + order.price());

        System.out.println("-----------------------------");
        System.out.println("Total Bill    : " + order.totalBill());

        sc.close();
    }
}

record FoodOrder(int orderId, String customerName, String itemName, int quantity, double price) {
    public double totalBill() {
        return quantity * price;
    }
}