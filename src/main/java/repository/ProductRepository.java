package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Product;


public interface ProductRepository  extends JpaRepository<Product, Integer> {
	  List<Product> getByBrand_Id(int brandId);
}
