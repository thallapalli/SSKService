package com.ssk.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.ssk.model.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);

}