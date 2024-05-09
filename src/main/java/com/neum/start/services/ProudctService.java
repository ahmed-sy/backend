package com.neum.start.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.neum.start.model.Product;
import com.neum.start.model.Review;
import com.neum.start.repository.ProductRepository;
import com.neum.start.repository.ReviewsRepository;
import com.neum.start.repository.ServiceProviderRepository;
import com.neum.start.repository.UserRepository;

@Service
public class ProudctService {

	 @Autowired
     private ProductRepository proRepositry;
	
	public List<Product> getProducts(){
	return	proRepositry.findAll();
	}
	public Optional<Product> getProduct(long id){
		return	proRepositry.findById(id);
		}	
}
