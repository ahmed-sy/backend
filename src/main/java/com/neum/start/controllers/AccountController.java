package com.neum.start.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neum.start.model.User;
import com.neum.start.model.dto.UserDetailsResponse;
import com.neum.start.services.UserService;

@RestController
@RequestMapping("/api/v1/account")
@Validated
public class AccountController {
	 @Autowired
	 private UserService userService;
	 
	 @GetMapping("/profile")
	    ResponseEntity<UserDetailsResponse> userAllDetails() {
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
         String userName = authentication.getName();
         User user=userService.getUserByEmail(userName);
         UserDetailsResponse userAllDetails=userService.getUserAllDetails(user);
	         return new ResponseEntity<UserDetailsResponse>(userAllDetails, HttpStatus.OK);
	        
	    }

}