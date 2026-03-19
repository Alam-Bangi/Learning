import java.util.ArrayList;

class PaymentSystem {
    public static void main(String[] args) {
        ArrayList<Payment> payments = new ArrayList<>();
        payments.add(new CashPayment(1234.0));
        payments.add(new CashPayment());
        payments.add(new CardPayment());
        payments.add(new UpiPayment());

        double amount = 1000.0;
        for (Payment payment : payments) {
            payment.pay(amount);
        }
    }
}

interface Payment {
    void pay(double amount);
}

class UpiPayment implements Payment {
    public void pay(double amount) {
        System.out.println("₹" + amount + " paid using UPI");
    }
}

class CardPayment implements Payment {
    public void pay(double amount) {
        System.out.println("₹" + amount + " paid using Card");
    }
}

class CashPayment implements Payment {
    double amount;

    public CashPayment() {
    }

    public CashPayment(double amount) {
        this.amount = amount;
    }

    public void pay(double amount) {
        System.out.println("₹" + amount + " paid using Cash");
    }
}