package com.neum.start.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.neum.start.model.Review;
import com.neum.start.model.ServiceProvider;

@Repository
public interface ReviewsRepository extends JpaRepository<Review, Long> {
	
	@Query("FROM Review r WHERE r.serviceProvider=:serviceProvider")
	 List<Review> findAllForUser( ServiceProvider serviceProvide);
		

}
