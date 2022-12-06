package EbebekFinalCase.service.implementations;


import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import EbebekFinalCase.model.Brand;
import EbebekFinalCase.repository.BrandRepository;
import EbebekFinalCase.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService{

    private final BrandRepository brandRepository;

	@Autowired
	public BrandServiceImpl(BrandRepository brandRepository) {
		this.brandRepository = brandRepository;
	}

	@Override
	public List<Brand> getAllBrands() {
		List<Brand> brands = brandRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
		return brands;
	}

	@Override
	public ResponseEntity<Brand> getBrand(int id) {
		 Brand brand=this.brandRepository.findById(id).orElseThrow(NoSuchElementException ::new);
		 return new ResponseEntity<>(brand,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Brand> addBrand(Brand brand) {
		 Brand newBrand=this.brandRepository.save(brand);
		return new ResponseEntity<>(newBrand, HttpStatus.CREATED); 
	}

	@Override
	public ResponseEntity<Brand> updateBrand(int id, Brand newBrand) {
		 Brand brand=this.brandRepository.findById(id).orElseThrow(NoSuchElementException ::new);
		 brand.setName(newBrand.getName());
		 Brand updatedBrand=this.brandRepository.save(brand);
		return new ResponseEntity<>(updatedBrand, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Brand> deleteBrand(int id) {
		this.brandRepository.deleteById(id);
		return new ResponseEntity<>( HttpStatus.OK);
	}

}
