package com.neum.start.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private	Long id;	
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
    private	String lastName;
	
	
	@Column(name="password")
    private	String password;
	
	@Column(name="email", unique=true)
    private	String email;

	
	@Column(name="type")
	private long type;
	
	
	@Column(name="role")
	 @Enumerated(EnumType.STRING)
	  private Role role;
	
	 @OneToMany(mappedBy ="user",orphanRemoval = true)
	 private List<Address> address;
	
}
