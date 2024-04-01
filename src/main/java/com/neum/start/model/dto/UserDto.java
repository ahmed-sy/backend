package com.neum.start.model.dto;

import java.util.List;

import com.neum.start.model.Address;
import com.neum.start.model.Role;
import com.neum.start.model.User;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
    private	Long id;	
	
	private String firstName;
	
    private	String lastName;
		
    private	String email;

	private long type;
	
	private Role role;
	
	private List<AdressDto> address;
}
