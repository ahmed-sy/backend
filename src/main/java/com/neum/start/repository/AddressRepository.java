package com.neum.start.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neum.start.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

}
