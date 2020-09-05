package com.ssk.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.ssk.model.entities.Post;

public interface PostRepository extends CrudRepository<Post, Long> {
	

}