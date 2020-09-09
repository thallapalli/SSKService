package com.ssk.model.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssk.model.entities.Department;
import com.ssk.model.exception.ResourceNotFoundException;
import com.ssk.model.service.DepartmentService;
import com.ssk.model.service.UserServiceImpl;

@RestController
@RequestMapping("/departments")
@CrossOrigin(origins = "http://locahost:5000", maxAge = 3600)
public class DepartmentController {
	@Autowired
	DepartmentService departmentService;
	@Autowired
	UserServiceImpl userServiceImpl;

	@GetMapping(value = "/count")
	public Long count() {
		return departmentService.count();
	}

	@GetMapping(value = "/{id}/exists")
	public boolean existsById(@PathVariable Long id) {
		return departmentService.existsById(id);
	}

	@DeleteMapping(value = "/")
	public void deleteAll() {
		departmentService.deleteAll();
	}

	@DeleteMapping(value = "/{id}")
	public void deleteById(@PathVariable Long id) throws ResourceNotFoundException {
		departmentService.deleteById(id);
	}

	@GetMapping(value = "/")
	public Iterable<Department> findAll() {
		return departmentService.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<Department> findById(@PathVariable Long id) {
		return departmentService.findById(id);
	}

	@PostMapping(value = "/")
	public Department save(@RequestBody Department department) {
		return departmentService.save(department);
	}

	@PutMapping(value = "/")
	public Department update(@RequestBody Department department) {
		return departmentService.save(department);
	}

	@PostMapping(value = "/saveall")
	public Iterable<Department> saveAll(@RequestBody Iterable<Department> departments) {
		return departmentService.saveAll(departments);

	}


}
