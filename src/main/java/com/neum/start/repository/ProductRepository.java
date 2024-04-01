package com.neum.start.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neum.start.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
	
}
