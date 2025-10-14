package com.Ecommerce.ShoppingApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.ShoppingApplication.Entity.Cart;
import com.Ecommerce.ShoppingApplication.Entity.CartItem;
import com.Ecommerce.ShoppingApplication.Entity.Product;
import com.Ecommerce.ShoppingApplication.ExceptionalHandler.CartNotFoundException;
import com.Ecommerce.ShoppingApplication.ExceptionalHandler.ExistingCartFound;
import com.Ecommerce.ShoppingApplication.Service.CartService;

@RestController
@RequestMapping("/Cart")
public class CartController {

	
	@Autowired
	CartService cartService;

	
@PostMapping("/create/{userId}")
public String createCart(@PathVariable long userId) throws ExistingCartFound {
		
		cartService.createCart(userId);
		return "Cart Created Succesfully";
	}
    @GetMapping("/get/{userId}")
	public Cart getCartByUserId(@PathVariable long userId) throws CartNotFoundException {
	
		return cartService.getCartByUserId(userId);
	}
	@PostMapping("/add/{userId}/{productId}")
	public String addToCart(@PathVariable long userId,@PathVariable long productId) throws CartNotFoundException {
		
		cartService.addToCart(userId, productId);
		
		
		return "Product Added Succesfully To Cart";
	
  }
 @DeleteMapping("/remove/{userId}/{cartItemId}")
 public String removeFromCart(@PathVariable long userId,@PathVariable long cartItemId) throws CartNotFoundException {
		
		cartService.removeFromCart(userId, cartItemId);
		
		return "Product remove Succesfully From Cart";
	
  }
	
	
	
}
