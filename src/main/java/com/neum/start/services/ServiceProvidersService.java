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
import com.neum.start.repository.CustomerRepository;
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
     private ReviewsRepository  reviewsRepository;
	 
	 @Autowired
	 private MServiceRepository mServiceRepository;
	 
	 @Autowired
	  private UserRepository userRepository;
	 
	 @Autowired
	 private AddressRepository addressRepositry;
	 
	 @Autowired
	 ServiceProviderRepository serviceProviderRepository;
	 
	 
	 
	public List<ServiceProvidersResponse> getServiceProviders( long prod){
		Optional<Product> produ=proRepositry.findById(prod);
		List<MService> mServices=	mServiceRepository.findByProductId( produ.get());
		List<ServiceProvidersResponse> servicesProviderResponses=new ArrayList<ServiceProvidersResponse>();
		List<Product> products=new ArrayList<Product>();

		
		for( MService ms : mServices) {
			ServiceProvidersResponse spr=new ServiceProvidersResponse();
			Optional<User> user =userRepository.findById(ms.getServiceProvider().getUser().getId());
			
			products.add(produ.get());
			spr.setFirstName(user.get().getFirstName());
			spr.setLastName(user.get().getLastName());
			spr.setEmail(user.get().getEmail());
			spr.setId(ms.getServiceProvider().getId());
			spr.setProducts(products);
	     	spr.setAddress(addressMapping(ms.getServiceProvider().getUser()));
			servicesProviderResponses.add(spr);
			
			
			
		}
		
		return servicesProviderResponses;
	}
	
	private AdressDto addressMapping( User user) {
		AdressDto adressDto= new AdressDto();
	List<Address> adds=	addressRepositry.findByUser(user);
	Address ads= adds.get(0);
	adressDto.setId(ads.getId());
	adressDto.setStreet(ads.getStreet());
	adressDto.setHaus_number(ads.getHaus_number());
	adressDto.setCountry(ads.getCountry());
	adressDto.setPlz(ads.getPlz());
	adressDto.setLatitude(ads.getLatitude());
	adressDto.setLongitude(ads.getLongitude());
	adressDto.setCountryCode(ads.getCountryCode());
	
		return adressDto;
	}
	
	public List<ReviewDto> getReviews(long sp){
		List<ReviewDto> reviwes= new ArrayList<ReviewDto>();
		
		Optional<ServiceProvider> sps= serviceProviderRepository.findById(sp);
		if(sps.isPresent()) {
			List<Review> revs=reviewsRepository.findAllForUser(sps.get());
			
			revs.forEach(r->reviwes.add(reviewMapping(r)));
		}
		
		return reviwes;	
	}
  private ReviewDto reviewMapping(Review r) {
	  ReviewDto rd= new ReviewDto();
	  rd.setId(r.getId());
	  rd.setValue(r.getValue());
	  rd.setComment(r.getComment());
	  rd.setServiceProvider(r.getServiceProvider());
	  rd.setUser(r.getUser());
	  rd.setCustomer(r.getCustomer());
	return rd;
	  
  }
}
