package com.neum.start.model.dto;

import java.util.List;

import com.neum.start.model.Address;
import com.neum.start.model.Product;
import com.neum.start.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceProvidersResponse {

private long id;

private String firstName;

private String lastName;

private String email;

private List<Product> products;

private AdressDto address;


}
