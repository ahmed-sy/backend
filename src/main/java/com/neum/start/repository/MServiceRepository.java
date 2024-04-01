package com.neum.start.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.neum.start.model.MService;
import com.neum.start.model.Product;
import com.neum.start.model.ServiceProvider;

@Repository
public interface MServiceRepository extends JpaRepository<MService, Long> {
	
	@Query("FROM MService ms WHERE ms.service=:product")
	public List<MService> findByProductId(Product product );
	
	@Query("FROM MService ms WHERE ms.serviceProvider=:serviceProvider")
	public List<MService> findByServiceProvider(ServiceProvider serviceProvider );
}
