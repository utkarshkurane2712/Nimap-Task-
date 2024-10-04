package com.Nimap.Repos;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Nimap.Entites.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
	
	Optional<Category> findByCategoryname(String categoryname);

}
