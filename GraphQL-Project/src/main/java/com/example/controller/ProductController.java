package com.example.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.entity.Product;
import com.example.service.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;
	
	@QueryMapping
	public List<Product> products(){
		return productService.getAllProducts();
	}
	
	@QueryMapping
	public List<Product> productsByPriceAsc(){
		return productService.getProductsByPriceAsc();
	}
	
	@QueryMapping
	public List<Product> productsByCategory(Long categoryId){
		return productService.getProductsByCategoryId(categoryId);
	}
	
	@QueryMapping
	public List<Product> productsByProductId(Long productId){
		return productService.getProductById(productId);
	}
	
	@MutationMapping
	public List<Product> createProduct(Product product){
		return productService.createProduct(product);
	}
	
	@MutationMapping
	public List<Product> updateProduct(Long productId, Product product){
		return productService.updateProduct(productId, product);
	}
	
	@MutationMapping
	public Boolean deleteProduct(Long productId){
		return productService.deleteProduct(productId);
	}
}
