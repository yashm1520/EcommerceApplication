package com.Ecommerce.ShoppingApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.ShoppingApplication.Entity.CartItem;
import com.Ecommerce.ShoppingApplication.Service.CartItemService;

@RestController
@RequestMapping("/cart")
public class CartitemController {
	
	
	@Autowired
	CartItemService cartItemService;
	
	@PostMapping("/increase/{cartId}")
	public String increaseQuantity(@PathVariable long cartId) {
		
		
		return cartItemService.increaseQuantity(cartId);
		
		
		
	}
	@PostMapping("/decrease/{cartId}")
	public String decreaseQuantity(@PathVariable long cartId) {
		
		
		return cartItemService.decreaseQuantity(cartId);
		
		
		
	}
}
