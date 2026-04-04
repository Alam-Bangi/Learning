import java.util.Scanner;

class Conditionals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        System.out.println();
        if (password.equals("ABC@12")) {
            System.out.println("Welcome " + username);
        } else {
            System.out.println("Invalid Credentials");
            sc.close();
            return;
        }

        viewPlans();
        subscribePlan();

        sc.close();
    }

    public static void viewPlans() {
        System.out.println();
        System.out.println("Subscription plans: ");
        System.out.println("1. Lite (₹139/month)");
        System.out.println(
                "You'll have 1 Lite account \nHigh Quality Audio(upto 160Kbps) \nCancel Anytime\n");
        System.out.println("2. Standard (₹199/month)");
        System.out.println(
                "You'll have 1 Standard account \nDownload and listen feature \nHigh Quality Audio(upto 320Kbps) \nCancel Anytime\n");
        System.out.println("3. Premium (₹299/month)");
        System.out.println(
                "You'll have 3 Premium account \nAll features enabled \nLossless Audio \nMix your playlists option \nCancel Anytime");
    }

    public static void subscribePlan() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter plan you want to subscribe: ");
        int planType;
        if (sc.hasNextInt()) {
            planType = sc.nextInt();
        } else {
            System.out.println("Invalid input! Please enter a number.");
            sc.close();
            return;
        }

        System.out.print("Confirm subscription (yes/no): ");
        String confirm = sc.next();

        if (confirm.equalsIgnoreCase("yes")) {
            switch (planType) {
                case 1 -> System.out.println("Congratulations! You've subscribed to the Lite plan");
                case 2 -> System.out.println("Congratulations! You've subscribed to the Standard plan");
                case 3 -> System.out.println("Congratulations! You've subscribed to the Premium plan");
                default -> System.out.println("Invalid Plan Type");
            }
        } else {
            System.out.println("Subscription cancelled.");
        }
        sc.close();
    }
}