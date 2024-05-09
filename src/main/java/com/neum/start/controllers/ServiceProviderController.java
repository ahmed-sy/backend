package com.neum.start.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neum.start.model.Address;
import com.neum.start.model.Product;
import com.neum.start.model.dto.ReviewDto;
import com.neum.start.model.dto.ServiceProvidersResponse;
import com.neum.start.services.ProudctService;
import com.neum.start.services.ServiceProvidersService;


@RestController
@RequestMapping("/api/v1/service")
public class ServiceProviderController {
	  @Autowired
	   private ServiceProvidersService serviceProviderService;
	  
	  @Autowired
	   private ProudctService proudctService;
	@GetMapping("/service-providers")
	  public ResponseEntity<List<ServiceProvidersResponse>> getServiceProvider(@RequestParam long prod)  {
	    return ResponseEntity.ok( serviceProviderService.getServiceProviders(prod));
	  }
	 @GetMapping("/products")
	  public ResponseEntity<List<Product>>Products() {
		
	    return ResponseEntity.ok( proudctService.getProducts());
	  }
	 
	 
	  }
	 	 