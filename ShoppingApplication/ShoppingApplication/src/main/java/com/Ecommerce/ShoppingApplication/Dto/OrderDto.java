package com.Ecommerce.ShoppingApplication.Dto;

import java.util.List;

import lombok.Data;
@Data
public class OrderDto {
	 private Long id;
	    private Long userId;
	    private Double totalPrice;
	    private String shippingAddress;

	    private List<OrderItemDto> orderItems;
}
