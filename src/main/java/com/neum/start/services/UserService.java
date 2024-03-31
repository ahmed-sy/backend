package com.neum.start.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.neum.start.model.Address;
import com.neum.start.model.Customer;
import com.neum.start.model.MService;
import com.neum.start.model.User;
import com.neum.start.model.Product;
import com.neum.start.model.Review;
import com.neum.start.model.ServiceProvider;
import com.neum.start.model.dto.CreateCustomer;
import com.neum.start.model.dto.CreateServiceProvider;
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
	   newUser.setPassword(null);
	   c.setUserId(newUser.getId());
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
	   sp.setUserId(newUser.getId());
	   ServiceProvider newsp=  serviceProviderRepository.save(sp);
	   Optional<Product> s =proRepositry.findById(request.getService());
	   MService m= new MService();
	   m.setServiceProvider(newsp);
	   m.setService(s.get());
	   MService newM = mServiceRepository.save(m); 
	   List<Address> addressList=   request.getUser().getAddress();
		 if(addressList!=null) {
			 addressList.forEach(a->a.setUser(newUser));
			 addressList.forEach(a->saveAddress(a));
		   }	
	   newUser.setPassword(null);
	   csp.setUser(newUser);
	   csp.setService(newM.getId());
	   return csp;
   }
   
   public List<ServiceProvider> getServiceProvider(){
		return	serviceProviderRepository.findAll();
		}
        
   public void saveReview(Review review) {
	   reviewsRepository.save(review);
   }
   
   public Address saveAddress(Address address) {
	   return addressRepository.save(address);
	   
   }
   
	    
	    
}
