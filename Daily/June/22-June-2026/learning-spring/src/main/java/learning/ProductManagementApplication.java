package learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductManagementApplication.class, args);
	}

}

//Get all products http://localhost:8080/inventory/products
//Add product http://localhost:8080/inventory/product
//Update product http://localhost:8080/inventory/stock/id/quantity
//Delete product http://localhost:8080/inventory/product/1
//Get low-stock(>10) http://localhost:8080/inventory/low-stock