package com.Ecommerce.ShoppingApplication.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Ecommerce.ShoppingApplication.Entity.Category;
import com.Ecommerce.ShoppingApplication.Entity.Product;

public interface CatgoryRepository extends JpaRepository<Category, Long> {

	
	@Query("SELECT C FROM Category C WHERE C.name=:name")
	public Category catgoryByName(@Param("name") String name);
}
