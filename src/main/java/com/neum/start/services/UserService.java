package com.neum.start.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.neum.start.model.Address;
import com.neum.start.model.Customer;
import com.neum.start.model.MService;
import com.neum.start.model.User;
import com.neum.start.model.Product;
import com.neum.start.model.Review;
import com.neum.start.model.Role;
import com.neum.start.model.ServiceProvider;
import com.neum.start.model.dto.AdressDto;
import com.neum.start.model.dto.CreateCustomer;
import com.neum.start.model.dto.CreateServiceProvider;
import com.neum.start.model.dto.MServiceDto;
import com.neum.start.model.dto.ReviewDto;
import com.neum.start.model.dto.ServiceProviderDto;
import com.neum.start.model.dto.UserDetailsResponse;
import com.neum.start.model.dto.UserDto;
import com.neum.start.repository.AddressRepository;
import com.neum.start.repository.CustomerRepository;
import com.neum.start.repository.MServiceRepository;
import com.neum.start.repository.ProductRepository;
import com.neum.start.repository.ReviewsRepository;
import com.neum.start.repository.ServiceProviderRepository;
import com.neum.start.repository.UserRepository;

@Service
public class UserService {
	    
	    @Autowired
	    private UserRepository userRepository;
	    @Autowired
	    private CustomerRepository customerRepository;
	   @Autowired
	    private ServiceProviderRepository serviceProviderRepository;
	   @Autowired
	    private BCryptPasswordEncoder passwordEncoder;
	   @Autowired
        private	ProductRepository proRepositry;
	   @Autowired
	    private MServiceRepository mServiceRepository;
	   @Autowired
	   private AddressRepository addressRepository;
	   
	   @Autowired
	   private ReviewsRepository reviewsRepository;
	   
	   @Autowired
		 private AddressRepository addressRepositry;
	    
	    public User createUser(User request) {
	    	 User user = new User();
	         user.setFirstName(request.getFirstName());
	         user.setLastName(request.getLastName());
	         user.setEmail(request.getEmail());
	         user.setRole(request.getRole());
	         user.setType(request.getType());
	       user.setPassword(passwordEncoder.encode(request.getPassword()));

	         // Save the user to the database
	       return userRepository.save(user);       
	    }
   public CreateCustomer createCustomer(CreateCustomer customer) {
	   CreateCustomer cc=new CreateCustomer();
	User newUser=  createUser(customer.getUser());
	   Customer c = new Customer();
	   c.setUser(newUser);
	   Customer newC= customerRepository.save(c);
	 List<Address> addressList=   customer.getUser().getAddress();
	 if(addressList!=null) {
		 addressList.forEach(a->a.setUser(newUser));
		 addressList.forEach(a->saveAddress(a));
		 
	   }	   
	   cc.setUser(newUser);
	   cc.setCustomer(newC);
	   return cc;
	   
   }
   
   public CreateServiceProvider createServiceProvider(CreateServiceProvider request) {
	   CreateServiceProvider csp= new CreateServiceProvider();
	   User newUser=createUser(request.getUser());
	   ServiceProvider sp =new ServiceProvider();
	   sp.setUser(newUser);
	   if(request.getService()!=null) {
	   ServiceProvider newsp=  serviceProviderRepository.save(sp);
	   Optional<Product> s =proRepositry.findById(request.getService());
	   MService m= new MService();
	   m.setServiceProvider(newsp);
	   m.setService(s.get());
	   MService newM = mServiceRepository.save(m); 
	   csp.setService(newM.getId());
	   }
	   List<Address> addressList=   request.getUser().getAddress();
		 if(addressList!=null) {
			 addressList.forEach(a->a.setUser(newUser));
			 addressList.forEach(a->saveAddress(a));
		   }	
	   csp.setUser(newUser);
	   return csp;
   }
   
   public List<ServiceProvider> getServiceProvider(){
		return	serviceProviderRepository.findAll();
		}
        
   public ReviewDto saveReview(ReviewDto review) {
	  return  new ReviewDto(reviewsRepository.save(mapReview(review)));
   }
   
   public Address saveAddress(Address request) {
	   return addressRepository.save(request);
	   
   }
   public UserDetailsResponse getUserAllDetails(User user) {
	UserDetailsResponse udr= new UserDetailsResponse();
    if(user!=null){
	  udr.setUser(mappUserDto(user));
	  ServiceProvider sp=serviceProviderRepository.findByUser(user);
	  if(sp!=null) {
		  udr.setSp(mappServiceProviderDto(sp));
      }
	  }
	 return udr;
  }


    public User getUserByEmail(String email) {
	  return userRepository.findByEmail(email).get();
	
}
   
	    private UserDto mappUserDto(User user) {
	    	UserDto ud= new UserDto();
	    	ud.setFirstName(user.getFirstName());
	    	ud.setLastName(user.getLastName());
	    	ud.setEmail(user.getEmail());
	    	ud.setRole(user.getRole());
	    	ud.setType(user.getType());
	    	ud.setId(user.getId());
	    	ud.setAddress(addressMapping(user));
	    	ud.setReviews(getReviews(user.getId()));
	    	
			return ud;
	    }
	     
	    	
	    private ServiceProviderDto mappServiceProviderDto(ServiceProvider sp) {
	    	
	    	ServiceProviderDto spd= new ServiceProviderDto();
	    	spd.setId(sp.getId());
	    	List<MServiceDto> msd= new ArrayList<MServiceDto>();
	    	sp.getServices().forEach(s->msd.add(mappMServiceDto(s)));
	    	spd.setServices(msd);
			return spd;
	    	
	    }
	    
	    private MServiceDto mappMServiceDto(MService ms) {
	    	MServiceDto msd= new MServiceDto();
	    	msd.setId(ms.getId());
	    	msd.setService(ms.getService());
	    	return msd;
	    }
	    
	    public AdressDto addressMapping( User user) {
			AdressDto adressDto= new AdressDto();
		List<Address> adds=	addressRepositry.findByUser(user);
		if(adds!=null &&adds.size()!=0) {
		Address ads= adds.get(0);
		adressDto.setId(ads.getId());
		adressDto.setStreet(ads.getStreet());
		adressDto.setHaus_number(ads.getHaus_number());
		adressDto.setCountry(ads.getCountry());
		adressDto.setPlz(ads.getPlz());
		adressDto.setLatitude(ads.getLatitude());
		adressDto.setLongitude(ads.getLongitude());
		adressDto.setCountryCode(ads.getCountryCode());
		}
		
			return adressDto;
		}
	    
	    
	    public List<ReviewDto> getReviews(long userId){
			List<ReviewDto> reviwes= new ArrayList<ReviewDto>();
			
			Optional<User> user= userRepository.findById(userId);
			if(user.isPresent()) {
				List<Review> revs=reviewsRepository.findAllForUser(user.get());
				revs.forEach(r->reviwes.add(new ReviewDto (r)));
			}
			
			return reviwes;	
		}
	    
	    public Review mapReview(ReviewDto r) {
	    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		      String userName = authentication.getName();
	          User user=getUserByEmail(userName);
	    	  Review re=new Review();
	    	  re.setValue(r.getValue());
	    	  re.setComment(r.getComment());
			  re.setReviewed(userRepository.findById(r.getReviewed()).get());
			  re.setReviewer(user);
			
			return re;
		}
	    
	    
	    
	    
}
