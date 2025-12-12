package com.example.service;

import java.util.List;

import com.example.entity.Product;

public interface ProductService {
	List<Product> getProductsByPriceAsc();
	
	List<Product> getAllProducts();
	
	List<Product> getProductsByCategoryId(Long categoryId);
	
	List<Product> getProductById(Long productId);
	
	List<Product> createProduct(Product product);
	
	List<Product> updateProduct(Long productId, Product product);
	
	Boolean deleteProduct(Long productId);
}
