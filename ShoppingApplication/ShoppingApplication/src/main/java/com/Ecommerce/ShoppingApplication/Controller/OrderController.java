package com.Ecommerce.ShoppingApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.ShoppingApplication.ExceptionalHandler.CartNotFoundException;
import com.Ecommerce.ShoppingApplication.Service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

@Autowired
OrderService orderService;

@PostMapping("/create/{userId}")
public String createOrder(@PathVariable long userId) throws CartNotFoundException {
		
	orderService.createOrder(userId);
		
		
		return "Order placed Succesfuly";
		
		
	}
	
	
	
}
