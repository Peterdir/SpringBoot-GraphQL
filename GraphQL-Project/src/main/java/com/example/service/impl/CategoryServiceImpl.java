package com.example.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Category;
import com.example.repository.CategoryRepository;
import com.example.service.CategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
	private final CategoryRepository categoryRepository;

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category findById(Long id) {
		return categoryRepository.findById(id).orElse(null);
	}

	@Override
	public Category create(Category c) {
		return categoryRepository.save(c);
	}

	@Override
	public Category update(Long id, Category c) {
		Category e = categoryRepository.findById(id).orElseThrow();
		e.setCategoryName(c.getCategoryName());
		e.setImages(c.getImages());
		return categoryRepository.save(e);
	}

	@Override
	public boolean delete(Long id) {
		if (!categoryRepository.existsById(id))
			return false;
		categoryRepository.deleteById(id);
		return true;
	}
}
