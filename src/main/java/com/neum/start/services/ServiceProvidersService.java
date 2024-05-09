package com.neum.start.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neum.start.model.Address;
import com.neum.start.model.MService;
import com.neum.start.model.Product;
import com.neum.start.model.Review;
import com.neum.start.model.ServiceProvider;
import com.neum.start.model.User;
import com.neum.start.model.dto.AdressDto;
import com.neum.start.model.dto.ReviewDto;
import com.neum.start.model.dto.ServiceProvidersResponse;
import com.neum.start.repository.AddressRepository;
import com.neum.start.repository.MServiceRepository;
import com.neum.start.repository.ProductRepository;
import com.neum.start.repository.ReviewsRepository;
import com.neum.start.repository.ServiceProviderRepository;
import com.neum.start.repository.UserRepository;

@Service
public class ServiceProvidersService {
	
	 @Autowired
     private ProductRepository proRepositry;
		 
	 @Autowired
	 private MServiceRepository mServiceRepository;
	 
	 @Autowired
	  private UserRepository userRepository;
	 
	
	 @Autowired
	 ServiceProviderRepository serviceProviderRepository;
	 
	 @Autowired
	 UserService userService;
	 
	 
	 
	public List<ServiceProvidersResponse> getServiceProviders( long prod){
		Optional<Product> produ=proRepositry.findById(prod);
		List<MService> mServices=	mServiceRepository.findByProductId( produ.get());
		List<ServiceProvidersResponse> servicesProviderResponses=new ArrayList<ServiceProvidersResponse>();
		List<Product> products=new ArrayList<Product>();

		
		for( MService ms : mServices) {
			ServiceProvidersResponse spr=new ServiceProvidersResponse();
			Optional<User> user =userRepository.findById(ms.getServiceProvider().getUser().getId());
			if (user.isPresent()) {
			spr.setAddress(userService.addressMapping(user.get()));
			spr.setReviews(userService.getReviews(user.get().getId()));
			products.add(produ.get());
			spr.setFirstName(user.get().getFirstName());
			spr.setLastName(user.get().getLastName());
			spr.setEmail(user.get().getEmail());
	                  	}
			spr.setId(ms.getServiceProvider().getId());
			spr.setProducts(products);
			servicesProviderResponses.add(spr);
			
		}
		
		return servicesProviderResponses;
	}
	
	
	
	
 
}
