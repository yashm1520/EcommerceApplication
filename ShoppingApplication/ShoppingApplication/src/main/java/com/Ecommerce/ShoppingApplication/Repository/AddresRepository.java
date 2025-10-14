package com.Ecommerce.ShoppingApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Ecommerce.ShoppingApplication.Entity.Address;

public interface AddresRepository extends JpaRepository<Address, Long> {

	@Query("SELECT A FROM Address A WHERE A.userId=:userId")
	public Address getAddressByUserId(@Param("userId") long userId);
	
}
