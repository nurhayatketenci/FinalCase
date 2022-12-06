package EbebekFinalCase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import EbebekFinalCase.model.Product;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductRepository  extends JpaRepository<Product, Integer> {
	  List<Product> getByBrand_Id(int brandId);
}
