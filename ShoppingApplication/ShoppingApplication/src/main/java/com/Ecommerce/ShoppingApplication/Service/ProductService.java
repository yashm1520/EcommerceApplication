package com.Ecommerce.ShoppingApplication.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.ShoppingApplication.Dto.ProductDto;
import com.Ecommerce.ShoppingApplication.Entity.Category;
import com.Ecommerce.ShoppingApplication.Entity.Product;
import com.Ecommerce.ShoppingApplication.Repository.CatgoryRepository;
import com.Ecommerce.ShoppingApplication.Repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CatgoryRepository catgoryRepository;

	
	public String addProduct(ProductDto productDto) {
		
		Product product=new Product();
		Category catgory=catgoryRepository.findById(productDto.getCatgoryId()).get();
		product.setCategory(catgory);
		product.setDescription(productDto.getDescription());
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		
		productRepository.save(product);
		
		return "Product Succesfully Added for id "+product.getId()+" Product Name "+product.getName();
		
	}
	public List<ProductDto> SearchProduct(String name) {
		List<Product> product=productRepository.searchProductByName(name);
		List<ProductDto> productDto=convertToDTO(product);
		
		return productDto;
		}
	
	public List<ProductDto> convertToDTO(List<Product> products) {
	    return products.stream()
	                   .map(p -> new ProductDto(p.getName(), p.getPrice(),p.getDescription(),p.getId()))
	                   .collect(Collectors.toList());
	}
	
	public String removeProduct(long id) {
		productRepository.deleteById(id);
		
		return "Product Remove Succesfully for id"+id;
	}
	
	public List<ProductDto> getAllProduct(){
		List<Product> product=productRepository.findAll();
		List<ProductDto> productDto=convertToDTO(product);
		
		return productDto;
	}
	
	
	
	
	
	
	
	
	
}
