package com.neum.start.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="user_id", nullable=false)
    @JsonIgnoreProperties("user")
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
