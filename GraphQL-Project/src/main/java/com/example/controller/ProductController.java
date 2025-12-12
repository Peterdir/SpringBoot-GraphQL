package com.example.controller;

import org.springframework.stereotype.Controller;

import com.example.service.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;
	
	
}
