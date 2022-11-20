package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import model.Brand;
import service.BrandService;

@RestController
@RequestMapping("/api/brand")
public class BrandController {
	private BrandService brandService;
	
	@Autowired
    public BrandController(BrandService brandService) {
  	  this.brandService=brandService;
    }
	
	   @GetMapping("/getall")
       ResponseEntity<?> getAll(){
          return ResponseEntity.ok(brandService.getAllBrands());
       }
	   @GetMapping("/{id}")
	  	public ResponseEntity<Brand> getBrand(@PathVariable(name = "id") int id) {
	  		return brandService.getBrand(id);
	  	}
	      
	    @DeleteMapping("/delete/{id}")
	  	public ResponseEntity<Brand> deleteBrand(@PathVariable(name = "id") int id) {
	  		return brandService.deleteBrand(id);
	  	}
	    @PutMapping("/update/{id}")
	  	public ResponseEntity<Brand> updateBrand(@PathVariable(value = "id") int id,  @RequestBody Brand newBrand) {
	      	return brandService.updateBrand(id, newBrand);
	  	}
	    @PostMapping("/create")
	    public ResponseEntity<Brand> createBrand(@RequestBody Brand brand){
	    	return brandService.addBrand(brand);
	    }
	

}
