package com.neum.start.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.neum.start.model.Address;
import com.neum.start.model.Customer;
import com.neum.start.model.User;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	@Query("FROM Customer a WHERE a.user=:user")
	public Customer findByUser(User user);

}
