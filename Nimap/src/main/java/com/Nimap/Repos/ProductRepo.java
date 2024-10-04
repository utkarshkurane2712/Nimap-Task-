package com.Nimap.Repos;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Nimap.Entites.Product;


@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
	
	Optional<Product> findByProductname(String productname);

}
