import java.util.*;

class Store {
    public static void main(String[] args) {
        
        List<Product> products = new List();
        products.add("Laptop");
    }
}
class List<T>{
    private ArrayList<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public void remove(T item) {
        if(items.contains(item)) {
            items.remove(item);
        }
    }
}
class Product{
    String name;

    Product(String name) {
        this.name = name;
    }
}
class Subscription {
    String appName;

    Subscription(String appName) {
        this.appName = appName;
    }
}