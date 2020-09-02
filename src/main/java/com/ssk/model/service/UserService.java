package com.ssk.model.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssk.model.entities.User;
import com.ssk.model.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Iterable<User> findAll() {
		Iterable<User> allUsers = userRepository.findAll();
		return allUsers;
	}

	public User save(User user) {
		User save = userRepository.save(user);
		return save;

	}

	public Optional<User> findById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user;

	}
	public void deleteById(Long id) throws Exception {
		if (userRepository.existsById(id)) {
		userRepository.deleteById(id);
		}else {
			throw new Exception("User Not Exisists......");
		}
		
		

	}
	

}