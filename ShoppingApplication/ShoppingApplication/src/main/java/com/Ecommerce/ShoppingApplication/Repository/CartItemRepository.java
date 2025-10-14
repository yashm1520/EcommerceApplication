package com.Ecommerce.ShoppingApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Ecommerce.ShoppingApplication.Entity.CartItem;


public interface CartItemRepository extends JpaRepository<CartItem, Long> {

	@Query(nativeQuery=true,name="SELECT C FROM CartItem C WHERE C.product_id=:productid")
	public CartItem getCartItemByProductId(@Param("productid") long productId);
	
	
}
