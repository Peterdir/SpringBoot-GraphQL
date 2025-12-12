package com.example.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	@Override
	public User findById(Long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	@Override
	public User create(User u) {
		return userRepository.save(u);
	}
	
	@Override
	public User update(Long id, User u) {
		if (!userRepository.existsById(id)) {
			return null;
		}
		u.setUserId(id);
		return userRepository.save(u);
	}
	
	@Override
	public boolean delete(Long id) {
		if(!userRepository.existsById(id)) {
			return false;
		}
		
		userRepository.deleteById(id);
		return true;
	}
}
