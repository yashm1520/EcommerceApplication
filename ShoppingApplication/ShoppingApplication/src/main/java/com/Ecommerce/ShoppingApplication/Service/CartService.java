package com.Ecommerce.ShoppingApplication.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.Ecommerce.ShoppingApplication.Entity.Cart;
import com.Ecommerce.ShoppingApplication.Entity.CartItem;
import com.Ecommerce.ShoppingApplication.Entity.Product;
import com.Ecommerce.ShoppingApplication.ExceptionalHandler.CartNotFoundException;
import com.Ecommerce.ShoppingApplication.ExceptionalHandler.ExistingCartFound;
import com.Ecommerce.ShoppingApplication.Repository.CartItemRepository;
import com.Ecommerce.ShoppingApplication.Repository.CartRepository;
import com.Ecommerce.ShoppingApplication.Repository.ProductRepository;

@Service
public class CartService {

	@Autowired
	CartRepository cartRepository;
	

	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired 
	CartItemRepository cartItemRepository;
	
	
	public String createCart(long userId) throws ExistingCartFound {
		Cart existingCart=cartRepository.getCartByUserId(userId);
		if(existingCart!=null) {
			throw new ExistingCartFound("Cart Already Present for userId "+userId);
		}
		Cart cart=new Cart();
		cart.setUserId(userId);
		cartRepository.save(cart);
		return "Cart Created Succesfully";
	}
	public Cart getCartByUserId(long userId) throws CartNotFoundException {
		Cart cart=cartRepository.getCartByUserId(userId);
		if(cart==null) {
			throw new CartNotFoundException("Cart not for "+ userId);
		}
		return cart;
	}
	
	public String addToCart(long userId,long productId) throws CartNotFoundException {
		
		CartItem cartItem=new CartItem();
	    Product product=productRepository.getById(productId);
		
		Cart cart=getCartByUserId(userId);
		cartItem.setPrice(product.getPrice());
		List<CartItem> cartItems=cart.getItems();
		cartItem.setCart(cart);
		cartItem.setProduct(product);
		cartItems.add(cartItem);
		cart.setItems(cartItems);
		cart.setTotalprice(cart.getTotalprice()+cartItem.getPrice());
		
		cartRepository.save(cart);
		
		return "Product Added Succesfully To Cart";
	
  }
 public String removeFromCart(long userId,long cartItemId) throws CartNotFoundException {
		
		CartItem cartItem=cartItemRepository.findById(cartItemId).get();
	    Cart cart=getCartByUserId(userId);
		boolean Isremoved=cart.getItems().removeIf(item -> item.getId().equals(cartItemId));
		cart.setTotalprice(cart.getTotalprice()-cartItem.getPrice());
		
		cartRepository.save(cart);
		
		return "Product remove Succesfully From Cart";
	
  }


	
   
	
	
	
	
	
	
}
