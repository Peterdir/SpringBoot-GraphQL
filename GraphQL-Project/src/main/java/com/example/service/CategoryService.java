package com.example.service;

import java.util.List;

import com.example.entity.Category;

public interface CategoryService {
	List<Category> findAll();

	Category findById(Long id);

	Category create(Category c);

	Category update(Long id, Category c);

	boolean delete(Long id);
}
