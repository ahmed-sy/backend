package com.neum.start.controllers;

import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neum.start.model.User;
import com.neum.start.model.dto.AuthResponseDto;
import com.neum.start.model.dto.CreateCustomer;
import com.neum.start.model.dto.CreateServiceProvider;
import com.neum.start.model.dto.LoginRequestDto;
import com.neum.start.securtiy.AuthService;
import com.neum.start.securtiy.AuthUser;
import com.neum.start.services.UserService;

@RestController
@RequestMapping("/api/v1/auth")
@Validated
public class AuthController {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthService authService;
    @Autowired
    private AuthenticationManager authenticationManager;
   

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginRequestDto userLogin) {
    	 Authentication authentication =
                 authenticationManager
                         .authenticate(new UsernamePasswordAuthenticationToken(
                                 userLogin.getEmail(),
                                 userLogin.getPassword()));
         SecurityContextHolder.getContext().setAuthentication(authentication);

         AuthUser userDetails = (AuthUser) authentication.getPrincipal();
         User user=    userDetails.getUser();

         log.info("Token requested for user :{}", authentication.getAuthorities());
         String token = authService.generateToken(authentication);
         AuthResponseDto response= new AuthResponseDto(token);
        return ResponseEntity.ok(response);

         }
   
}
    

