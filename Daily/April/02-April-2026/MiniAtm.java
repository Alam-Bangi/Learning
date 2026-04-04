import java.util.Scanner;

class MiniAtm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        int amount = 0;

        do {
            System.out.println("Welcome to ATM");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw amount");
            System.out.println("3. Deposit amount");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> System.out.println("Your balance is: " + amount);
                case 2 -> {
                    System.out.print("Enter amount to withdraw: ");
                    int withdrawAmount = sc.nextInt();
                    if (withdrawAmount > amount) {
                        System.out.println("Insufficient balance");
                    } else {
                        amount -= withdrawAmount;
                        System.out.println("Withdrawal successful. Current balance: " + amount);
                    }
                }
                case 3 -> {
                    System.out.print("Enter amount to deposit: ");
                    int depositAmount = sc.nextInt();
                    amount += depositAmount;
                    System.out.println("Deposit successful. Current balance: " + amount);
                }
                case 4 -> System.out.println("Thank you for using ATM");
                default -> System.out.println("Invalid choice");
            }
        } while (choice != 4);
        sc.close();
    }
}
