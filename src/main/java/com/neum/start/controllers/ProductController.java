 package com.neum.start.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neum.start.model.Product;
import com.neum.start.services.ProudctService;

@RestController
 @RequestMapping("/api/v1/auth")
 @Validated
 public class ProductController {
	@Autowired
	 private ProudctService proudctService;
	 
	 @GetMapping("/products")
	  public ResponseEntity<List<Product>>Products() {
		
	    return ResponseEntity.ok( proudctService.getProducts());
	  }
	 @GetMapping("/reviews")
	  public ResponseEntity<List<Product>> Reviews() {
		
	    return ResponseEntity.ok( proudctService.getProducts());
	  }

}
