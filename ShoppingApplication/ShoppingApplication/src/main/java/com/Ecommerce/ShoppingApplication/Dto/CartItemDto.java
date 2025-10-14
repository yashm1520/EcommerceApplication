package com.Ecommerce.ShoppingApplication.Dto;

import lombok.Data;

@Data
public class CartItemDto {
	
	 private String productName; 
	 
	    private Double productPrice; 
	    
	    private int quantity;
	    
	    private Double totalPrice;      
}
