package com.Ecommerce.ShoppingApplication.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.Ecommerce.ShoppingApplication.Dto.CategoryDto;
import com.Ecommerce.ShoppingApplication.Dto.ProductDto;
import com.Ecommerce.ShoppingApplication.Entity.Category;
import com.Ecommerce.ShoppingApplication.Entity.Product;
import com.Ecommerce.ShoppingApplication.Repository.CatgoryRepository;

@Service
public class CategoryService {
	
	private static final Logger log = LoggerFactory.getLogger(CategoryService.class);

	@Autowired
	CatgoryRepository catgoryRepository;
	
	public List<ProductDto> productByCatgory(String catgoryName){
		Category category=catgoryRepository.catgoryByName(catgoryName);
		log.info("catgory " + category);
		List<Product> products=category.getProducts();
		log.info("products " +category.getProducts().toString());
		List<ProductDto> productsDto=convertToDTO(products);
		
		return productsDto;
		
	}
	public List<ProductDto> convertToDTO(List<Product> products) {
	    return products.stream()
	                   .map(p -> new ProductDto(p.getName(), p.getPrice(),p.getDescription(),p.getCategory().getId()))
	                   .collect(Collectors.toList());
	}
	public String addCatgory(CategoryDto catgoryDto) {
		Category catgory=new Category();
		catgory.setDescription(catgoryDto.getDescription());
		catgory.setName(catgoryDto.getName());
		catgoryRepository.save(catgory);
		
		return "Catgory SucessFully Added";
		
	}
	
	
	
	
	
	
}
