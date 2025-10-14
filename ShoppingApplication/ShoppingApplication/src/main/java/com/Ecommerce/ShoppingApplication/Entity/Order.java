package com.Ecommerce.ShoppingApplication.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="orders")
public class Order {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Double totalPrice;

    @ManyToOne
    @JoinColumn(name="address_id")
    Address address;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "order",orphanRemoval = true)
    @JsonManagedReference
    private List<OrderItem> orderItem;

}
