package com.neum.start.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name="m_services")
public class MService {

    @Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private	Long id;	
   
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="service_provider_id", nullable=false)
    private	ServiceProvider serviceProvider;	
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="service_id", nullable=false)
    private	Product service;	
}