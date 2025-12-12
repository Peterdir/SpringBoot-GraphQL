package com.example.service;

import java.util.List;

import com.example.entity.User;

public interface UserService {
	List<User> findAll();

	User findById(Long id);

	User create(User u);

	User update(Long id, User u);

	boolean delete(Long id);
}
