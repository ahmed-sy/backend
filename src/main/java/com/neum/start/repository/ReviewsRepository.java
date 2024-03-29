package com.neum.start.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neum.start.model.Review;

@Repository
public interface ReviewsRepository extends JpaRepository<Review, Long> {

}
