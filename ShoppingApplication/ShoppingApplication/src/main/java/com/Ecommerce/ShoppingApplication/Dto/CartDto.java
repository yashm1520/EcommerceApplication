package com.Ecommerce.ShoppingApplication.Dto;

import java.util.List;

import lombok.Data;
@Data
public class CartDto {
	
	private Long id;                
    private Long userId;
    private Double totalPrice;

    private List<CartItemDto> items;
}
