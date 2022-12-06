package EbebekFinalCase.service.implementations;

import java.util.List;
import java.util.NoSuchElementException;
import EbebekFinalCase.model.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import EbebekFinalCase.repository.CategoryRepository;
import EbebekFinalCase.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

	@Autowired

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

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
