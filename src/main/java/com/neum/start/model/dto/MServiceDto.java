package com.neum.start.model.dto;

import com.neum.start.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MServiceDto {
	
    private	Long id;	
   
    private	Product service;
}
