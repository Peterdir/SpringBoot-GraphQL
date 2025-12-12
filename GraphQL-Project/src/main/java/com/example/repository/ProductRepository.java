package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByCategory_CategoryId(Long categoryId);
	List<Product> findAllByOrderByPriceAsc();
	
}
