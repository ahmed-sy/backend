package com.neum.start.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neum.start.model.Product;
import com.neum.start.model.ServiceProvider;
import com.neum.start.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ServiceProviderController {
	  @Autowired
	    private UserService userService;
	@GetMapping("/service-providers")
	  public ResponseEntity<List<ServiceProvider>> getServiceProvider() {
		
	    return ResponseEntity.ok( userService.getServiceProvider());
	  }
}