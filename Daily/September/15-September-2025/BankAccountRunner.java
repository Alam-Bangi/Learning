import java.util.Scanner;

public class BankAccountRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account;

        System.out.println("Welcome to My Bank!");
        System.out.println("Choose account type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            account = new SavingsAccount();
            System.out.println("Savings Account created successfully.");
        } else if (choice == 2) {
            account = new CurrentAccount();
            System.out.println("Current Account created successfully.");
        } else {
            System.out.println("Invalid account type.");
            scanner.close();
            return;
        }
        while (true) {
            System.out.println("--- Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    System.out.println("Thank you for using My Bank!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}

abstract class BankAccount {
    double balance;
    abstract void deposit(double amount);
    abstract void withdraw(double amount);

    void checkBalance() {
        System.out.println("Current balance: ₹" + balance);
    }
}

class SavingsAccount extends BankAccount {
    public void deposit(double amount) {
        balance += amount;
        System.out.println("₹" + amount + " deposited to Savings Account.");
    }
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn from Savings Account.");
        } else {
            System.out.println("Insufficient balance");
        }
    }
}

class CurrentAccount extends BankAccount {

    public void deposit(double amount) {
        balance += amount;
        System.out.println("₹" + amount + " deposited to Current Account.");
    }
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn from Current Account.");
        } else {
            System.out.println("Insufficient balance");
        }
    }
}
