package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Brand;


public interface BrandRepository  extends JpaRepository<Brand, Integer> {
	@Query("Select u.name from brands u order by u.name desc")
	List<Brand> findAllBrand();
} 
