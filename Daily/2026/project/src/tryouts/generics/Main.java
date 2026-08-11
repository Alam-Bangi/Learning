package tryouts.generics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductService service = new ProductService();

        List<Product> products = new ArrayList<>();

        products.add(new Product(101, "Laptop"));
        products.add(new Product(102, "Mobile"));
        products.add(new Product(103, "Headphones"));

        Product firstProduct = service.getFirst(products);
        System.out.println("First Product: " + firstProduct);
        service.printAll(products);

        service.print("Hello");
        service.print(100);
        service.print(99.99);
    }
}