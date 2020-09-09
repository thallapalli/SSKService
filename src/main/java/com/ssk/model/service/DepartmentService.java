package com.ssk.model.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssk.model.entities.Department;
import com.ssk.model.exception.ResourceNotFoundException;
import com.ssk.model.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;

	public Department createIncident(Department department) {

		return departmentRepository.save(department);
	}

	public Long count() {
		// TODO Auto-generated method stub
		return departmentRepository.count();
	}

	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return departmentRepository.existsById(id);
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		departmentRepository.deleteAll();

	}

	public void deleteById(Long id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		if (existsById(id)) {
			departmentRepository.deleteById(id);
		} else {
			throw new ResourceNotFoundException(String.valueOf(id));
		}

	}

	public Iterable<Department> findAll() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

	public Optional<Department> findById(Long id) {
		// TODO Auto-generated method stub
		return departmentRepository.findById(id);
	}

	public Department save(Department depratmemnt) {
		// TODO Auto-generated method stub
		return departmentRepository.save(depratmemnt);
	}

	public Iterable<Department> saveAll(Iterable<Department> depratmemnts) {
		// TODO Auto-generated method stub
		return departmentRepository.saveAll(depratmemnts);
	}
	
	
	

}
