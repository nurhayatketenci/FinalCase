package EbebekFinalCase.service;

import java.util.List;
import EbebekFinalCase.model.Category;
import org.springframework.http.ResponseEntity;

public interface CategoryService {
	List<Category> getAllCategories();
    ResponseEntity<Category> getCategory(int id);
    ResponseEntity<Category> addCategory(Category category);
	ResponseEntity<Category> deleteCategory(int id) ;
}
