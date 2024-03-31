package com.neum.start.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="address")
public class Address {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private	Long id;	
	
	 @ManyToOne
	 @JoinColumn(name="user_id")
	 User user;
	
	@Column(name="street")
    private	String street;
	
	
	@Column(name="haus_number")
    private	String haus_number;
	
	@Column(name="city")
    private	String city;

	
	@Column(name="country")
	private String country;
	
	@Column(name="country_code")
	private String countryCode;
	
	@Column(name="plz")
	private String plz;
	
	@Column(name="latitude")
	private String latitude;
	
	@Column(name="longitude")
	private String longitude;
    

}
