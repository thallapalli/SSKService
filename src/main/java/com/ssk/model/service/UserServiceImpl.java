package com.ssk.model.service;

import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ssk.model.entities.User;
import com.ssk.model.exception.ResourceNotFoundException;
import com.ssk.model.repository.RoleRepository;
import com.ssk.model.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(new HashSet<>(roleRepository.findAll()));
		userRepository.save(user);
	}
	

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public Long count() {
		// TODO Auto-generated method stub
		return userRepository.count();
	}

	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.existsById(id);
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		userRepository.deleteAll();

	}

	public void deleteById(Long id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		if (existsById(id)) {
			userRepository.deleteById(id);
		} else {
			throw new ResourceNotFoundException(String.valueOf(id));
		}

	}

	public Iterable<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	public Optional<User> findById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	public Iterable<User> saveAll(Iterable<User> users) {
		// TODO Auto-generated method stub
		return userRepository.saveAll(users);
	}

}