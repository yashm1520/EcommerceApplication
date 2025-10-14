package com.Ecommerce.ShoppingApplication.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	private long userId;
	
	private String flat_no;
	
	private String building;
	
	private String City;
	
	private String landmark;
	
	private String State;
	
	private String Country;
	
	
	
	
	
	
}
