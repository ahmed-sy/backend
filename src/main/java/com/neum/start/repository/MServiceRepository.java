package com.neum.start.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neum.start.model.MService;

@Repository
public interface MServiceRepository extends JpaRepository<MService, Long> {

}
