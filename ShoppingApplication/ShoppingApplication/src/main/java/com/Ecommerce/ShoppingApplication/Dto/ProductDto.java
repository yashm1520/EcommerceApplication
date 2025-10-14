package com.Ecommerce.ShoppingApplication.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {

	private String name;

	private double price;

	private String description;
	
	private long catgoryId;
}
