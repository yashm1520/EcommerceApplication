package com.Ecommerce.ShoppingApplication.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
	
	    private long userId;
	    private String flatNo;
	    private String building;
	    private String city;
	    private String landmark;
	    private String state;
	    private String country;
}
