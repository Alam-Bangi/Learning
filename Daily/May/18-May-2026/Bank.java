import java.util.Scanner;

class Bank {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double balance = 10000;

        while (true) {

            System.out.println("\n->->-> BANK MENU <-<-<-");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Bill Payment");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            TransactionType type = null;

            switch (choice) {

                case 1:
                    type = TransactionType.DEPOSIT;
                    break;

                case 2:
                    type = TransactionType.WITHDRAW;
                    break;

                case 3:
                    type = TransactionType.BILL_PAYMENT;
                    break;

                case 4:
                    System.out.println("Current Balance: " + balance);
                    continue;

                case 5:
                    System.out.println("Thank you for banking with us!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
                    continue;
            }

            System.out.print("Enter amount: ");
            double amount = sc.nextDouble();

            if (!type.isWithinLimit(amount)) {
                System.out.println("Transaction Failed: Exceeds Limit");
                continue;
            }

            double fee = type.calculateFee(amount);

            switch (type) {

                case DEPOSIT:
                    balance += (amount - fee);
                    System.out.println("Deposited Successfully");
                    break;

                case WITHDRAW:
                    balance -= amount;
                    System.out.println("Withdrawal Successful");
                    break;

                case BILL_PAYMENT:
                    if (amount + fee > balance) {
                        System.out.println("Insufficient Balance");
                        continue;
                    }
                    balance -= (amount + fee);
                    System.out.println("Bill Paid Successfully");
                    break;
            }

            System.out.println("Transaction Fee: " + fee);
            System.out.println("Updated Balance: " + balance);
        }
    }
}

enum TransactionType {

    DEPOSIT(0.05, 50000),
    WITHDRAW(0.0, 100000),
    BILL_PAYMENT(1.0, 100000);

    double feePercent;
    int dailyLimit;

    TransactionType(double feePercent, int dailyLimit) {
        this.feePercent = feePercent;
        this.dailyLimit = dailyLimit;
    }

    double calculateFee(double amount) {
        return (amount * feePercent) / 100;
    }

    boolean isWithinLimit(double amount) {
        return amount <= dailyLimit;
    }

    void showDetails() {
        System.out.println("Transaction : " + this.name());
        System.out.println("Fee %       : " + feePercent);
        System.out.println("Limit       : " + dailyLimit);
        System.out.println();
    }
}
