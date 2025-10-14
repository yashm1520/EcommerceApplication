package com.Ecommerce.ShoppingApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.ShoppingApplication.Dto.AddressDto;
import com.Ecommerce.ShoppingApplication.Entity.Address;
import com.Ecommerce.ShoppingApplication.Service.AddresService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	AddresService addressService;

	@PostMapping("/add")
	public String addNewAddress(@RequestBody AddressDto addressDto) {
	
		
		return addressService.addNewAddress(addressDto);
		
	}
	
}
