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
@Table(name="reviews")
public class Review {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private	long id;	
	
	@Column(name="value")
    private	int value;	
	
	@Column(name="comment")
    private	String comment;
	
	   @ManyToOne
	   @JoinColumn(name="reviewed")
	   private	User reviewed;	
	    
	    @ManyToOne
	    @JoinColumn(name="reviewer")
	    private	User reviewer;
	    
	   
	    
}
