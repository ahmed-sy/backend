package com.neum.start.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.neum.start.model.MService;
import com.neum.start.model.Product;

@Repository
public interface MServiceRepository extends JpaRepository<MService, Long> {
	
	@Query("FROM MService ms WHERE ms.service=:product")
	public List<MService> getbyProductId(Product product );
}
