package com.neum.start.model.dto;

import java.util.List;

import com.neum.start.model.Address;
import com.neum.start.model.Customer;
import com.neum.start.model.MService;
import com.neum.start.model.Product;
import com.neum.start.model.ServiceProvider;
import com.neum.start.model.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsResponse {
	private UserDto user;
	private Customer customer;
	private ServiceProviderDto sp;
}
