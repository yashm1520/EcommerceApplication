package com.Ecommerce.ShoppingApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.ShoppingApplication.Entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
