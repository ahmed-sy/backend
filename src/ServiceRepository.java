package com.neum.start.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neum.start.model.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {

}
