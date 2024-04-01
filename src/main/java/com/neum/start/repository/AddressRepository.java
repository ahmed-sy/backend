package com.neum.start.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.neum.start.model.Address;
import com.neum.start.model.User;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

	@Query("FROM Address a WHERE a.user=:user")
	public List<Address> findByUser(User user );
}
