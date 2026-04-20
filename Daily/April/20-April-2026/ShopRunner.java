class ShopRunner {
    public static void main(String[] args) {
        double price = 1000;
        System.out.println("Earphones");
        System.out.println("Price: " + price);

        Discount seasonal = new SeasonalDiscount();
        seasonal.applyDiscount(price);

        Discount festive = new FestiveDiscount();
        festive.applyDiscount(price);

        Discount member = new MemberDiscount();
        member.applyDiscount(price);
    }
}

interface Discount {
    void applyDiscount(double price);
}

class SeasonalDiscount implements Discount {
    public void applyDiscount(double price) {
        double priceAfterDiscount = price * 0.95;
        System.out.println("Seasonal Discount Price(5% off): " + priceAfterDiscount);
    }
}

class FestiveDiscount implements Discount {
    public void applyDiscount(double price) {
        double priceAfterDiscount = price * 0.90;
        System.out.println("Festive Discount Price(10% off): " + priceAfterDiscount);
    }
}

class MemberDiscount implements Discount {
    public void applyDiscount(double price) {
        double priceAfterDiscount = price * 0.80;
        System.out.println("Member Discount Price(20% off): " + priceAfterDiscount);
    }
}