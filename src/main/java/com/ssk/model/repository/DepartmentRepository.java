package com.ssk.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.ssk.model.entities.Department;
import com.ssk.model.entities.Incident;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
	
    
}
