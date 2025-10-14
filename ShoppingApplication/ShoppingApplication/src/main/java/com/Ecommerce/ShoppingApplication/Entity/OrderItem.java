package com.Ecommerce.ShoppingApplication.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor

public class OrderItem {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

private long quantity;
private double price;

public OrderItem(int quantity, double price, Order order, Product product) {
    this.quantity = quantity;
    this.price = price;
    this.order = order;
    this.product = product;
}

@ManyToOne
@JoinColumn(name = "order_id")
@JsonBackReference
private Order order;

@ManyToOne
@JsonBackReference
@JoinColumn(name = "product_id")
private Product product;

	
	
	
}
