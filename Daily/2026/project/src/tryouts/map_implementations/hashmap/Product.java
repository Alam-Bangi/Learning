package tryouts.map_implementations.hashmap;

public class Product {
    private final int productId;
    private final String productName;
    private final double price;
    private int stock;

    public Product(int productId, String productName,
                   double price, int stock) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public boolean reduceStock(int quantity) {
        if (quantity <= 0 || quantity > stock) {
            return false;
        }
        stock -= quantity;
        return true;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId
                + " | Name: " + productName
                + " | Price: Rs. " + price
                + " | Stock: " + stock;
    }
}