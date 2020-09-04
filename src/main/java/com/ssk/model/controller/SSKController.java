package com.ssk.model.controller;

import java.sql.Timestamp;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssk.model.entities.User;
import com.ssk.model.service.UserService;

@RestController
public class SSKController {
	@Autowired
	UserService userService;

	@GetMapping(value = "/hello")
	public String hello() {
		return "Hello ,welcome to SSKS!!!";

	}
	@GetMapping(value = "/dummyuser")
	public User dummyuser() {
		User user=new User();
		user.setId(1L);
		user.setFirst_name("karnakar");
		user.setLast_name("Thallaplli");
		user.setEmail("karnakar@gmail.com");
		user.setPassword("test");
		user.setRegistration_date( new Timestamp(System.currentTimeMillis()));
		
		return user;
	}

	@PostMapping(value = "/create")
    public ResponseEntity<User> create(@Valid @RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }
	@PutMapping(value = "/save")
	public User save(User user) {
		User save = userService.save(user);
		return save;
	}

	@GetMapping(value = "/findall")
	public Iterable<User> findAll(@RequestBody User user) {
		Iterable<User> findAll = userService.findAll();
		return findAll;

	}
	@GetMapping(value = "/{id}")
	public Optional<User> findAll(@PathVariable Long id) {
		 Optional<User> findById = userService.findById(id);
		return findById;

	}

	@DeleteMapping(value = "/{id}/delete")
	public Iterable<User> deleteById(@PathVariable Long id) throws Exception {
		userService.deleteById(id);
		return null;

	}

}
