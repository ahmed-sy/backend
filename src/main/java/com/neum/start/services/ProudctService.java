package com.neum.start.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neum.start.model.Product;
import com.neum.start.repository.ProductRepository;

@Service
public class ProudctService {

	 @Autowired
     private ProductRepository proRepositry;
	 
	public List<Product> getProducts(){
	return	proRepositry.findAll();
	}
}
