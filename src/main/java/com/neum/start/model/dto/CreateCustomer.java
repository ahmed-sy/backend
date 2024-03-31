package com.neum.start.model.dto;

import com.neum.start.model.Address;
import com.neum.start.model.Customer;
import com.neum.start.model.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomer {
	
	private User user;
	private Customer customer;
}
