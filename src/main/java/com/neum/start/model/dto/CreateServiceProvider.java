package com.neum.start.model.dto;

import com.neum.start.model.Address;
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
public class CreateServiceProvider {
	private User user;
    private Long service;
}
