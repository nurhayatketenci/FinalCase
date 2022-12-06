package EbebekFinalCase.repository;

import java.util.List;

import EbebekFinalCase.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface BrandRepository  extends JpaRepository<Brand, Integer> {

} 
