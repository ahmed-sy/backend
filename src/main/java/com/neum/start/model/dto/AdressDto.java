package com.neum.start.model.dto;

import java.util.List;

import com.neum.start.model.Address;
import com.neum.start.model.Role;
import com.neum.start.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdressDto {
	
    private	Long id;	
	
	
    private	String street;
	
	
    private	String haus_number;
	
    private	String city;

	
	private String country;
	
	private String countryCode;
	
	private String plz;
	
	private String latitude;
	
	private String longitude;
}
