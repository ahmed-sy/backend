package com.neum.start.model.dto;

import com.neum.start.model.Customer;
import com.neum.start.model.Review;
import com.neum.start.model.ServiceProvider;
import com.neum.start.model.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {

	
    private	Long id;	
	
	
    private	int value;	
	
	
    private	String comment;
	
	 
	 private long reviewed;	
	    
	    
	    
	    	 
	 

	public ReviewDto(Review r) {
		  this.id=r.getId();
		  this.value=r.getValue();
		  this.comment=r.getComment();	
		  this.reviewed= r.getReviewed().getId();
	}
	    
}
