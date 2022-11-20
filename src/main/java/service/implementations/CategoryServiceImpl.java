package service.implementations;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Locale.Category;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import repository.CategoryRepository;
import service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
    private CategoryRepository categoryRepository;
    
	@Override
	public List<Category> getAllCategories() {
		List<Category> categories=this.categoryRepository.findAll();
		return categories ;
	}

	@Override
	public ResponseEntity<Category> getCategory(int id) {
		Category category=this.categoryRepository.findById(id).orElseThrow(NoSuchElementException ::new);
		 return new ResponseEntity<>(category,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Category> addCategory(Category category) {
		Category newCategory=this.categoryRepository.save(category);
		return new ResponseEntity<>(newCategory, HttpStatus.CREATED); 
	}


	@Override
	public ResponseEntity<Category> deleteCategory(int id) {
		this.categoryRepository.deleteById(id);
		return new ResponseEntity<>( HttpStatus.OK);
	}

}
