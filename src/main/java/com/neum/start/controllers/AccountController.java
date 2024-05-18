package com.neum.start.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neum.start.model.Address;
import com.neum.start.model.Product;
import com.neum.start.model.Review;
import com.neum.start.model.User;
import com.neum.start.model.dto.AdressDto;
import com.neum.start.model.dto.CreateServiceProvider;
import com.neum.start.model.dto.Edit;
import com.neum.start.model.dto.EditUser;
import com.neum.start.model.dto.ReviewDto;
import com.neum.start.model.dto.UserDetailsResponse;
import com.neum.start.model.dto.UserDto;
import com.neum.start.services.UserService;

@RestController
@RequestMapping("/api/v1/account")
@Validated
public class AccountController {
	 @Autowired
	 private UserService userService;
	 
	 @GetMapping("/profile")
	    ResponseEntity<UserDetailsResponse> userAllDetails() {
		 
         UserDetailsResponse userAllDetails=userService.getUserAllDetails();
         
	         return new ResponseEntity<UserDetailsResponse>(userAllDetails, HttpStatus.OK);
	        
	    }
	  @PostMapping("/review")
	    ResponseEntity<ReviewDto> userReview(@RequestBody ReviewDto request) {
			 
	    	  ReviewDto re=	userService.saveReview(request);
	    	
	         return new ResponseEntity<ReviewDto>(re, HttpStatus.OK);
	    }
	  @PutMapping("/user")
	    ResponseEntity<UserDto> editUser(@RequestBody EditUser request) {
		 

		  UserDto newServiceProvider=	userService.editUser(request);
	         return new ResponseEntity<UserDto>(newServiceProvider, HttpStatus.OK);
	    }
	  @PostMapping("/product")
	     ResponseEntity<Product> addProduct(@RequestBody Product request) {
			 
	    	  Product re=	userService.addProduct(request);
	    	
	         return new ResponseEntity<Product>(re, HttpStatus.OK);
	    }
	  
	  @PutMapping("/adress")
	    ResponseEntity<AdressDto> changAdress(@RequestBody Address request) {
		 
		  AdressDto newServiceProvider=	userService.changeAddress(request);
	         return new ResponseEntity<AdressDto>(newServiceProvider, HttpStatus.OK);
	  
        }
	  @PutMapping("/type")
	    ResponseEntity<UserDto> editUserType(@RequestBody int request) {
		 
		  UserDto newServiceProvider=	userService.editUserType(request);
	         return new ResponseEntity<UserDto>(newServiceProvider, HttpStatus.OK);
	    }
}