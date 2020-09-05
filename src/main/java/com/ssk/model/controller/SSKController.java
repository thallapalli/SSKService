package com.ssk.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssk.model.service.UserServiceImpl;

@RestController
public class SSKController {
	@Autowired
	UserServiceImpl userService;

	@GetMapping(value = "/hello")
	public String hello() {
		return "Hello ,welcome to SSKS!!!";

	}

}
