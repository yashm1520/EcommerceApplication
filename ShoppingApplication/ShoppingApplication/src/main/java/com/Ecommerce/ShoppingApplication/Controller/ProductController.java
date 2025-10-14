package com.Ecommerce.ShoppingApplication.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.ShoppingApplication.Dto.ProductDto;
import com.Ecommerce.ShoppingApplication.Entity.Product;
import com.Ecommerce.ShoppingApplication.Service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	
	@Autowired
	ProductService productService;
@PostMapping("/add")
public String addProduct(@RequestBody ProductDto productDto) {
		

		
		return productService.addProduct(productDto);
		
	}
@GetMapping("/search")
	public List<ProductDto> SearchProduct(String name) {
		
		
		return productService.SearchProduct(name);
		}
	
	
	@DeleteMapping("/remove/{id}")
	public String removeProduct(@PathVariable long  id) {
		productService.removeProduct(id);
		
		return productService.removeProduct(id);
	}
	@GetMapping("/get")
	public List<ProductDto> getAllProduct(){
		
		
		return productService.getAllProduct();
	}
	
	
}
