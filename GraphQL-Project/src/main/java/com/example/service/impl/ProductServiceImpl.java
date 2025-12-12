package com.example.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import com.example.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository productRepository;
	
	@Override
	public List<Product> getProductsByPriceAsc(){
		return productRepository.findAllByOrderByPriceAsc();
	}
	
	@Override
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	@Override
	public List<Product> getProductsByCategoryId(Long categoryId){
		return productRepository.findByCategory_CategoryId(categoryId);
	}
	
	@Override
	public List<Product> getProductById(Long productId){
		return productRepository.findAllById(List.of(productId));
	}
	
	@Override
	public List<Product> createProduct(Product product){
		productRepository.save(product);
		return productRepository.findAll();
	}
	
	@Override
	public List<Product> updateProduct(Long productId, Product product){
		product.setProductId(productId);
		productRepository.save(product);
		return productRepository.findAll();
	}
	
	@Override
	public Boolean deleteProduct(Long productId) {
		if(!productRepository.existsById(productId)) {
			return false;
		}
		productRepository.deleteById(productId);
		return true;
	}
}
