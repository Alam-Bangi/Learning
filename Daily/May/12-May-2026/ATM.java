import java.util.Scanner;

class ATM {
    public static void main(String[] args)
            throws InvalidAmountException, InsufficientBalanceException, InvalidPinException {
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

    private int pin = 4321;
    boolean isBlocked = false;

    abstract void depositAmount(double amount) throws InvalidAmountException;

    abstract void withdrawAmount(double amount)
            throws InvalidAmountException, InsufficientBalanceException, InvalidPinException;

    public void validatePin() throws InvalidPinException {
        int attempts = 0;

        if (isBlocked) {
            throw new InvalidPinException("Account is blocked. Please contact the bank.");
        }

        if (!isBlocked) {
            while (attempts < 3) {
                System.out.print("Enter PIN: ");
                int enteredPin = scanner.nextInt();
                if (enteredPin == pin) {
                    return;
                } else {
                    attempts++;
                    System.out.println("Incorrect PIN. Try again.");
                }
            }
        }
        if (attempts >= 3) {
            isBlocked = true;
            throw new InvalidPinException("Too many incorrect attempts. Account Blocked.");
        }
    }

    public void validateAmount(double amount) throws InvalidAmountException {
        if (amount < 1) {
            throw new InvalidAmountException("Amount cannot be negative or zero.");
        }
    }

    public void displayBalance() throws InvalidPinException {
        validatePin();
        System.out.println("Current Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {
    public void depositAmount(double amount) throws InvalidAmountException {
        validateAmount(amount);
        balance += amount;
        System.out.println(amount + " deposited successfully.");
    }

    public void withdrawAmount(double amount)
            throws InvalidAmountException, InsufficientBalanceException, InvalidPinException {
        validatePin();
        validateAmount(amount);

        if (this.balance < amount) {
            throw new InsufficientBalanceException("Insufficient balance. Withdrawal failed.");
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

    public void depositAmount(double amount) throws InvalidAmountException {
        validateAmount(amount);
        balance += amount;
        System.out.println(amount + " deposited successfully.");
    }

    public void withdrawAmount(double amount)
            throws InvalidAmountException, InsufficientBalanceException, InvalidPinException {
        validatePin();
        validateAmount(amount);

        if (this.balance < amount) {
            throw new InsufficientBalanceException("Insufficient balance. Withdrawal failed.");
        } else {
            this.balance -= amount;
            if (this.balance < 1000) {
                this.balance += amount;
                System.out.println("Cannot withdraw as minimum balance should be 1000");
            } else {
                System.out.println(amount + " withdrawn successfully.");
            }
        }
    }
}

class InvalidPinException extends Exception {
    public InvalidPinException(String message) {
        super(message);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}