package com.neum.start.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neum.start.model.Product;
import com.neum.start.model.ServiceProvider;
import com.neum.start.model.dto.ServiceProvidersResponse;
import com.neum.start.services.ProudctService;
import com.neum.start.services.ServiceProvidersService;
import com.neum.start.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/service")
public class ServiceProviderController {
	  @Autowired
	   private ServiceProvidersService serviceProvider;
	  
	  @Autowired
	   private ProudctService proudctService;
	@GetMapping("/service-providers")
	  public ResponseEntity<List<ServiceProvidersResponse>> getServiceProvider(@RequestParam long prod)  {
	    return ResponseEntity.ok( serviceProvider.getServiceProviders(prod));
	  }
	 @GetMapping("/products")
	  public ResponseEntity<List<Product>>Products() {
		
	    return ResponseEntity.ok( proudctService.getProducts());
	  }
	 @GetMapping("/reviews")
	  public ResponseEntity<List<Product>> Reviews() {
		
	    return ResponseEntity.ok( proudctService.getProducts());
	  }
}