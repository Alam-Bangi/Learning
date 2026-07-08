package learning.inventory_management.service;

import learning.inventory_management.entity.Product;
import learning.inventory_management.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Transactional
    public Product updateStock(Long id, int quantity) {

        Product product =
                productRepository.findById(id).orElse(null);

        if (product != null) {
            product.setQuantity(quantity);
        }
        return product;
    }

    public List<Product> getLowStockProducts() {
        return productRepository.findLowStockProducts();
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}