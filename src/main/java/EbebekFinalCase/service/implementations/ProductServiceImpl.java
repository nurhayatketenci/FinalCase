package EbebekFinalCase.service.implementations;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import EbebekFinalCase.model.Product;
import EbebekFinalCase.repository.ProductRepository;
import EbebekFinalCase.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;


	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> products=this.productRepository.findAll();
		return products ;
	}

	@Override
	public ResponseEntity<Product> getProduct(int id) {
		Product product=this.productRepository.findById(id).orElseThrow(NoSuchElementException ::new);
		 return new ResponseEntity<>(product,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Product> addProduct(Product product) {
		Product newProduct=this.productRepository.save(product);
		return new ResponseEntity<>(newProduct, HttpStatus.CREATED); 
	}

	

	@Override
	public ResponseEntity<Product> deleteProduct(int id) {
		this.productRepository.deleteById(id);
		return new ResponseEntity<>( HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Product> getByBrand(int brandId) {
		this.productRepository.getByBrand_Id(brandId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
