package com.neum.start.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.neum.start.model.Customer;
import com.neum.start.model.ServiceProvider;
import com.neum.start.model.User;

@Repository
public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Long> {
	
	@Query("FROM ServiceProvider a WHERE a.user=:user")
	public ServiceProvider findByUser(User user );


}
