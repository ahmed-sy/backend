package com.neum.start.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdressDto {
	
    private	long id;	
	
	
    private	String street;
	
	
    private	String haus_number;
	
    private	String city;

	
	private String country;
	
	private String countryCode;
	
	private String plz;
	
	private String latitude;
	
	private String longitude;
}
