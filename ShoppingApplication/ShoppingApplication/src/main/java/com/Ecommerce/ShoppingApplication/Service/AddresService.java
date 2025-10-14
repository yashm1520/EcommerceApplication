package com.Ecommerce.ShoppingApplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.ShoppingApplication.Dto.AddressDto;
import com.Ecommerce.ShoppingApplication.Entity.Address;
import com.Ecommerce.ShoppingApplication.Repository.AddresRepository;

@Service
public class AddresService {

	@Autowired
	AddresRepository addressRepository;
	
	public String addNewAddress(AddressDto addressDto) {
		Address address=new Address();
		address.setFlat_no(addressDto.getFlatNo());
		address.setCity(addressDto.getCity());
		address.setCountry(addressDto.getCountry());
		address.setLandmark(address.getLandmark());
		address.setState(addressDto.getState());
		address.setUserId(addressDto.getUserId());
		addressRepository.save(address);
		
		return "New Address added Succesfully";
		
	}
	
}
