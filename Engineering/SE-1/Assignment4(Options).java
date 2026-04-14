
/**
Write a Python program that computes the net amount of a bank 
account based a transaction log from console input. The 
transaction log format is shown as following: 
D 100 W 200 (Withdrawal is not allowed if balance is going negative. 
Write functions for withdraw and deposit) D means deposit 
while W means withdrawal.
Suppose the following input is supplied to the program:
D 300, D 300, W 200, D 100 Then, the output should be: 500
*/

import java.util.ArrayList;
import java.util.Scanner;

class Assignment4 {
    static Scanner sc = new Scanner(System.in);
    static BankAccount account;

    public static void main(String[] args) {

        System.out.println("Select your choice");
        System.out.println("1. Menu Driven");
        System.out.println("2. String Driven");
        System.out.print("Your Selection: ");
        int selected = sc.nextInt();
        while (selected != 1 && selected != 2) {
            System.out.print("Enter valid choice: ");
            selected = sc.nextInt();
        }

        System.out.println("\n------------------------------");
        System.out.println("Welcome to Bank Account Management System");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        while (choice != 1 && choice != 2) {
            System.out.print("Enter valid choice: ");
            choice = sc.nextInt();
        }

        switch (choice) {
            case 1:
                account = new SavingsAccount();
                break;
            case 2:
                account = new CurrentAccount();
                break;
        }
        switch (selected) {
            case 1:
                menuDriven();
                break;
            case 2:
                stringDriven();
                break;
        }
    }

    public static void menuDriven() {
        while (true) {
            System.out.println("\n------------------------------");
            System.out.println("1. Deposit Amount");
            System.out.println("2. Withdraw Amount");
            System.out.println("3. Display Balance");
            System.out.println("4. See All Transactions");
            System.out.println("5. Exit");
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
                    account.displayTransactions();
                    break;
                case 5:
                    System.out.println("Thank You for using Bank System!!!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void stringDriven() {
        while (true) {
            System.out.println("\n------------------------------");
            System.out.println("1. Display Balance");
            System.out.println("2. Enter Transaction String");
            System.out.println("3. See All Transactions ");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    account.displayBalance();
                    break;
                case 2:
                    account.stringTransactions();
                    break;
                case 3:
                    account.displayTransactions();
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
    ArrayList<Transactions> transactions = new ArrayList<>();

    abstract void depositAmount(double amount);

    abstract void stringTransactions();

    abstract void withdrawAmount(double amount);

    public boolean validateAmount(double amount) {
        return amount <= 0;
    }

    public boolean validateString(String input) {
        // to-do
        // 1. No negative amounts
        // 2. Transactions should contain only d/D or w/W followed by amount
        // 3. Transactions should be separated by commas
        // 4. Should've space between transaction type and amount

        String[] transactions = input.split(",");
        for (String transaction : transactions) {
            transaction = transaction.trim();
            if (!(transaction.toUpperCase().charAt(0) == 'D') && !(transaction.toUpperCase().charAt(0) == 'W')
                    && !(transaction.charAt(1) == ' ')) {
                System.out.println("Invalid transaction type: " + transaction);
                return false;
            }
            if (input.contains("-") && !(input.contains(" "))) {
                System.out.println("Please enter a valid transaction(Please follow the format: D 100, W 200): ");
                return false;
            }
        }
        return true;
    }

    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public void displayTransactions() {
        if(transactions.isEmpty()){
            System.out.println("No transactions yet");
        } else {
            System.out.println("Your Transactions are: ");
            for(Transactions transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }
}

class SavingsAccount extends BankAccount {
    public void depositAmount(double amount) {
        while (validateAmount(amount)) {
            System.out.println("Enter valid amount (Cannot be negative): ");
            amount = scanner.nextDouble();
        }
        balance += amount;
        this.transactions.add(new Transactions("Deposit: ", amount));
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
            this.transactions.add(new Transactions("Withdraw: ", amount));
            System.out.println(amount + " withdrawn successfully.");
        }
    }

    public void stringTransactions() {
        System.out.println("Enter transactions (Please follow the format: D 100, W 200): ");
        String input = scanner.nextLine();
        while (!validateString(input)) {
            input = scanner.nextLine();
        }
        input = input.toUpperCase();
        String[] transactions = input.split(",");
        for (String transaction : transactions) {
            transaction = transaction.trim();
            String[] transactionDetails = transaction.split(" ");
            if (transactionDetails.length > 2) {
                System.out.println("Invalid transaction format: " + transaction);
                continue;
            }
            String transactionType = transactionDetails[0];
            double amount;
            amount = Double.parseDouble(transactionDetails[1]);
            if (transactionType.equalsIgnoreCase("D")) {
                depositAmount(amount);
            } else if (transactionType.equalsIgnoreCase("W")) {
                withdrawAmount(amount);
            }
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
        this.transactions.add(new Transactions("Deposit: ", amount));
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
            if (this.balance < 1000) {
                this.balance += amount;
                System.out.println("Insufficient balance (Need to keep minimum balance of Rs.1000).");
            } else {
                this.transactions.add(new Transactions("Withdraw: ", amount));
                System.out.println(amount + " withdrawn successfully.");
            }
        }
    }

    public void stringTransactions() {
        System.out.println("Enter transactions (Please follow the format: D 100, W 200): ");
        String input = scanner.nextLine();
        while (!validateString(input)) {
            input = scanner.nextLine();
        }
        input = input.toUpperCase();
        String[] transactions = input.split(",");
        for (String transaction : transactions) {
            transaction = transaction.trim();
            String[] transactionDetails = transaction.split(" ");
            if (transactionDetails.length >= 2) {
                System.out.println("Invalid transaction format: " + transaction);
                continue;
            }
            String transactionType = transactionDetails[0];
            double amount;
            amount = Double.parseDouble(transactionDetails[1]);
            if (transactionType.equalsIgnoreCase("D")) {
                depositAmount(amount);
            } else if (transactionType.equalsIgnoreCase("W")) {
                withdrawAmount(amount);
            }
        }
    }
}
class Transactions {
    String type;
    double amount;

    public Transactions(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String toString() {
        return type + amount;
    }
}