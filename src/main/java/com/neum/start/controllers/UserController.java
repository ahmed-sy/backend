package com.neum.start.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neum.start.model.Address;
import com.neum.start.model.dto.CreateCustomer;
import com.neum.start.model.dto.CreateServiceProvider;
import com.neum.start.services.UserService;

@RestController
@RequestMapping("/api/v1/new-user")
@Validated
public class UserController {
	 @Autowired
	 private UserService userService;
	 @PostMapping("/customer")
	    ResponseEntity<CreateCustomer> createCustomer(@RequestBody CreateCustomer request) {
		 CreateCustomer newCustomer=userService.createCustomer(request);
	         return new ResponseEntity<CreateCustomer>(newCustomer, HttpStatus.OK);
	        
	    }
	    @PostMapping("/service-provider")
	    ResponseEntity<CreateServiceProvider> createServiceProvider(@RequestBody CreateServiceProvider request) {
	    	CreateServiceProvider newServiceProvider=	userService.createServiceProvider(request);
	         return new ResponseEntity<CreateServiceProvider>(newServiceProvider, HttpStatus.OK);
	    }
	    
	    @PostMapping("/address")
	    ResponseEntity<Address> createServiceProvider(@RequestBody Address request) {
	    	Address address=	userService.saveAddress(request);
	         return new ResponseEntity<Address>(address, HttpStatus.OK);
	    }
	
}
