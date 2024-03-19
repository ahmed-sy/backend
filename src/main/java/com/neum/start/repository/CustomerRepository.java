package com.neum.start.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neum.start.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {


}
