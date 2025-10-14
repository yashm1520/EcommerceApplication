package com.Ecommerce.ShoppingApplication.Dto;

import java.util.List;

import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
public class CategoryDto {

    private String name;
	
	private String description;
	

}
