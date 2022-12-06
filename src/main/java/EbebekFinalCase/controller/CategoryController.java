package EbebekFinalCase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import EbebekFinalCase.service.CategoryService;

@RestController
@RequestMapping("/api/Category")
public class CategoryController {
private CategoryService categoryService;
	
	@Autowired
    public CategoryController(CategoryService categoryService) {
  	  this.categoryService=categoryService;
    }
	
	   @GetMapping("/getall")
       ResponseEntity<?> getAll(){
          return ResponseEntity.ok(categoryService.getAllCategories());
       }

}
