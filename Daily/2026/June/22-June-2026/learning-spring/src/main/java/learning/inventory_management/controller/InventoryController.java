package learning.inventory_management.controller;

import learning.inventory_management.entity.Product;
import learning.inventory_management.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService service;

    @PostMapping("/product")
    public Product addProduct(
            @RequestBody Product product) {

        return service.saveProduct(product);
    }

    @GetMapping("/products")
    public List<Product> getProducts() {

        return service.getAllProducts();
    }

    @PutMapping("/stock/{id}/{qty}")
    public Product updateStock(
            @PathVariable Long id,
            @PathVariable int qty) {

        return service.updateStock(id, qty);
    }

    @GetMapping("/low-stock")
    public List<Product> lowStockProducts() {

        return service.getLowStockProducts();
    }

    @DeleteMapping("/product/{id}")
    public String deleteProduct(
            @PathVariable Long id) {

        service.deleteProduct(id);
        return "Deleted";
    }
}