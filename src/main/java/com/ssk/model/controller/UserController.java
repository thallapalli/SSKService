package com.ssk.model.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssk.model.entities.User;
import com.ssk.model.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserServiceImpl userServiceImpl;

	@GetMapping(value = "/count")
	public Long count() {
		return userServiceImpl.count();
	}

	@GetMapping(value = "/{id}/exists")
	public boolean existsById(@PathVariable Long id) {
		return userServiceImpl.existsById(id);
	}

	@DeleteMapping(value = "/")
	public void deleteAll() {
		userServiceImpl.deleteAll();
	}

	@DeleteMapping(value = "/{id}")
	public void deleteById(@PathVariable Long id) throws Exception {
		userServiceImpl.deleteById(id);
	}

	@GetMapping(value = "/all")
	public Iterable<User> findAll() {
		return userServiceImpl.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<User> findById(@PathVariable Long id) {
		return userServiceImpl.findById(id);
	}

	@PostMapping(value = "/create")
	public void save(@RequestBody User user) {
		userServiceImpl.save(user);
	}

	@PostMapping(value = "/saveall")
	public Iterable<User> saveAll(@RequestBody Iterable<User> users) {
		return userServiceImpl.saveAll(users);

	}

}
