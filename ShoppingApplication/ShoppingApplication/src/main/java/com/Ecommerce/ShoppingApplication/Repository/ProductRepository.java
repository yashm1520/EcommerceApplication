package com.Ecommerce.ShoppingApplication.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Ecommerce.ShoppingApplication.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	
	@Query("SELECT P FROM Product P where P.name LIKE %:name%")
	public List<Product> searchProductByName(String name);
	
	
	
}
