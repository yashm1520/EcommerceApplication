package com.Ecommerce.ShoppingApplication.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.ShoppingApplication.Dto.CategoryDto;
import com.Ecommerce.ShoppingApplication.Dto.ProductDto;
import com.Ecommerce.ShoppingApplication.Entity.Category;
import com.Ecommerce.ShoppingApplication.Entity.Product;
import com.Ecommerce.ShoppingApplication.Service.CategoryService;

@RestController
@RequestMapping("/catgory")
public class CategoryController {
	
	
	
	@Autowired
	CategoryService catgoryService;

	
	@GetMapping("/get/{catgoryName}")
	public List<ProductDto> productByCatgory(@PathVariable String catgoryName){
		
		
		return catgoryService.productByCatgory(catgoryName);
		
	}
	@PostMapping("/add")
	public String addCatgory(@RequestBody CategoryDto catgoryDto) {
		return catgoryService.addCatgory(catgoryDto);
	}
	
	
	
	
	
	
	
	
	
	
	
}
