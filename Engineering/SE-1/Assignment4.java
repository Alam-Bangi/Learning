
/**
Write a Python program that computes the net amount of a bank account based a transaction log from console input. The transaction log format is shown as following: D 100 W 200 (Withdrawal is not allowed if balance is going negative. Write functions for withdraw and deposit) D means deposit while W means withdrawal.
Suppose the following input is supplied to the program:
D 300, D 300, W 200, D 100 Then, the output should be: 500
*/

import java.util.Scanner;

class Assignment4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BankAccount account;

        System.out.println("\n------------------------------");
        System.out.println("Welcome to Bank Account Management System");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                account = new SavingsAccount();
                break;
            case 2:
                account = new CurrentAccount();
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }
        while (true) {
            System.out.println("\n------------------------------");
            System.out.println("1. Deposit Amount");
            System.out.println("2. Withdraw Amount");
            System.out.println("3. Display Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    account.depositAmount(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdrawAmount(withdrawAmount);
                    break;
                case 3:
                    account.displayBalance();
                    break;
                case 4:
                    System.out.println("Thank You for using Bank System!!!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }

    }
}

abstract class BankAccount {
    Scanner scanner = new Scanner(System.in);

    double balance;

    abstract void depositAmount(double amount);

    abstract void withdrawAmount(double amount);

    public boolean validateAmount(double amount) {
        return amount < 1;
    }

    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {
    public void depositAmount(double amount) {
        while (validateAmount(amount)) {
            System.out.println("Enter valid amount (Cannot be negative): ");
            amount = scanner.nextDouble();
        }
        balance += amount;
        System.out.println(amount + " deposited successfully.");
    }

    public void withdrawAmount(double amount) {
        while (validateAmount(amount)) {
            System.out.println("Enter valid amount (Cannot be negative): ");
            amount = scanner.nextDouble();
        }
        if (this.balance < amount) {
            System.out.println("Insufficient balance. Withdrawal failed.");
        } else {
            this.balance -= amount;
            System.out.println(amount + " withdrawn successfully.");
        }
    }
}

class CurrentAccount extends BankAccount {
    public CurrentAccount() {
        this.balance = 1000;
    }

    public void depositAmount(double amount) {
        while (validateAmount(amount)) {
            System.out.println("Enter valid amount (Cannot be negative): ");
            amount = scanner.nextDouble();
        }
        this.balance += amount;
        System.out.println(amount + " deposited successfully.");
    }

    public void withdrawAmount(double amount) {

        while (validateAmount(amount)) {
            System.out.println("Enter valid amount (Cannot be negative): ");
            amount = scanner.nextDouble();
        }
        if (this.balance < amount) {
            System.out.println("Insufficient balance. Withdrawal failed.");
        } else {
            this.balance -= amount;
            if(this.balance < 1000) {
                this.balance += amount;
                System.out.println("Cannot withdraw as minimum balance should be 1000");
            } else {
                System.out.println(amount + " withdrawn successfully.");
            }
        }
    }
}
