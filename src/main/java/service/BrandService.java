package service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import model.Brand;

public interface BrandService {
	List<Brand> getAllBrands();
    ResponseEntity<Brand> getBrand(int id);
    ResponseEntity<Brand> addBrand(Brand brand);
    ResponseEntity<Brand> updateBrand(int id, Brand newBrand);
	ResponseEntity<Brand> deleteBrand(int id) ;
}
