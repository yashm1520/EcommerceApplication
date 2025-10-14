package com.Ecommerce.ShoppingApplication.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	
	private String name;
	
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
	@JsonManagedReference
	List<Product> products;
	
	
	
	
	
	
	
	
	
	
}
