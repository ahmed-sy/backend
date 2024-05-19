package com.neum.start.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProviderDataDto {
	private	long id;
	
	private String firstName;
	
	private String lastName;
	
	private String plz;
	
	private String city;
	
	private String country;
	
}
