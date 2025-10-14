package com.Ecommerce.ShoppingApplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.ShoppingApplication.Entity.CartItem;
import com.Ecommerce.ShoppingApplication.Entity.Product;
import com.Ecommerce.ShoppingApplication.Repository.CartItemRepository;
import com.Ecommerce.ShoppingApplication.Repository.ProductRepository;

@Service
public class CartItemService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CartItemRepository cartItemRepository;

	
	public String increaseQuantity(long cartId) {
		CartItem cartItem=cartItemRepository.findById(cartId).get();
	    int quantity=cartItem.getQuantity();
	    quantity=quantity+1;
		cartItem.setQuantity(quantity);
		cartItem.setPrice(2*quantity*cartItem.getPrice());
		cartItemRepository.save(cartItem);
		
		return "Increase Quantity Succesfully";
		
		
		
	}
	public String decreaseQuantity(long cartId) {
		CartItem cartItem=cartItemRepository.findById(cartId).get();
	    int quantity=cartItem.getQuantity();
	    quantity=quantity-1;
		cartItem.setQuantity(quantity);
		cartItem.setPrice(2*quantity*cartItem.getPrice());
		cartItemRepository.save(cartItem);
		
		return "Decrease Quantity Succesfully";
		
		
		
	}
	
	
	
	
	
	
}
