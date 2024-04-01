package com.neum.start.model.dto;

import java.util.List;

import com.neum.start.model.MService;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceProviderDto {
	
    private	Long id;
		
	private List<MServiceDto> services;
}
