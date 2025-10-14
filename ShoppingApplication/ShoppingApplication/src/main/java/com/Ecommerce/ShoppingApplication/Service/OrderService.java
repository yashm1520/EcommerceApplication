package com.Ecommerce.ShoppingApplication.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.ShoppingApplication.Dto.ProductDto;
import com.Ecommerce.ShoppingApplication.Entity.Cart;
import com.Ecommerce.ShoppingApplication.Entity.CartItem;

import com.Ecommerce.ShoppingApplication.Entity.NotificationService;
import com.Ecommerce.ShoppingApplication.Entity.Order;
import com.Ecommerce.ShoppingApplication.Entity.OrderItem;
import com.Ecommerce.ShoppingApplication.ExceptionalHandler.CartNotFoundException;
import com.Ecommerce.ShoppingApplication.Repository.AddresRepository;
import com.Ecommerce.ShoppingApplication.Repository.CartRepository;
import com.Ecommerce.ShoppingApplication.Repository.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	AddresRepository addressRepository;
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	NotificationService notificationService;
	
	@Transactional
	public String createOrder(long userId) throws CartNotFoundException {
		
		Order order=new Order();
		
		Cart cart=cartService.getCartByUserId(userId);
		List<CartItem> cartItemList=cart.getItems();
		
		List<OrderItem>orderItemList= cartItemList.stream()
        .map(p -> new OrderItem(p.getQuantity(), p.getPrice(),order,p.getProduct()))
        .collect(Collectors.toList());
		
		
		order.setOrderItem(orderItemList);
		order.setAddress(addressRepository.getAddressByUserId(userId));
		order.setTotalPrice(cart.getTotalprice());
		order.setUserId(userId);
		cart.getItems().clear();
		
		
		cart.setTotalprice(0);
		cartRepository.save(cart);
		orderRepository.save(order);
		
		String subject = "Order Confirmation - #" + order.getId();
        String message = "Hi " + order.getUserId() + ", your order is confirmed!";
        notificationService.sendOrderConfirmation("myash753@gmail.com", subject, message);
		
		return "Order placed Succesfuly";
		
		
	}
	
	
	
	
}
