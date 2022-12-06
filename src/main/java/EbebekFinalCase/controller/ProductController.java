package EbebekFinalCase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import EbebekFinalCase.model.Product;
import EbebekFinalCase.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private ProductService productService;
    
    @Autowired
    public ProductController(ProductService productService) {
  	  this.productService=productService;
    }
    
	    @GetMapping("/getall")
	    ResponseEntity<?> getAll(){
	       return ResponseEntity.ok(productService.getAllProducts());
	    }
	   @GetMapping("/{id}")
	  	public ResponseEntity<Product> getProduct(@PathVariable(name = "id") int id) {
	  		return productService.getProduct(id);
	  	}
	      
	    @DeleteMapping("/delete/{id}")
	  	public ResponseEntity<Product> deleteProduct(@PathVariable(name = "id") int id) {
	  		return productService.deleteProduct(id);
	  	}
	    @PostMapping("/create")
	    public ResponseEntity<Product> createProduct(@RequestBody Product product){
	    	return productService.addProduct(product);
	    }
	    @GetMapping("/getbrand/{id}")
	    ResponseEntity<?> getByBrand(@PathVariable(name = "id") int id){
	       return ResponseEntity.ok(productService.getByBrand(id));
	    }
}
