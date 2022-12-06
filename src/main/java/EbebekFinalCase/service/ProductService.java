package EbebekFinalCase.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import EbebekFinalCase.model.Product;

public interface ProductService {
	List<Product> getAllProducts();
    ResponseEntity<Product> getProduct(int id);
    ResponseEntity<Product> addProduct(Product product);
	ResponseEntity<Product> deleteProduct(int id) ;
	ResponseEntity<Product> getByBrand(int brandId);
}
