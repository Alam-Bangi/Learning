import java.util.ArrayList;
import java.util.List;

class ScRunner {
    public static void main(String[] args) {

        ShoppingCart<Grocery> groceryCart = new ShoppingCart<>();
        groceryCart.addItem(new Grocery("Milk", 50));
        groceryCart.addItem(new Grocery("Bread", 30));

        System.out.println("Grocery Cart:");
        groceryCart.showItems();

        ShoppingCart<Electronics> electronicsCart = new ShoppingCart<>();
        electronicsCart.addItem(new Electronics("Laptop", 2));
        electronicsCart.addItem(new Electronics("Phone", 1));

        System.out.println("\nElectronics Cart:");
        electronicsCart.showItems();
    }
}

class ShoppingCart<T> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public void showItems() {
        for (T item : items) {
            System.out.println(item);
        }
    }
}

class Grocery {
    String name;
    double price;

    Grocery(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return "Grocery{name='" + name + "', price=" + price + "}";
    }
}

class Electronics {
    String name;
    int warrantyYears;

    Electronics(String name, int warrantyYears) {
        this.name = name;
        this.warrantyYears = warrantyYears;
    }

    public String toString() {
        return "Electronics{name='" + name + "', warranty=" + warrantyYears + " years}";
    }
}