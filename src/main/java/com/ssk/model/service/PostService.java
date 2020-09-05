package com.ssk.model.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssk.model.entities.Post;
import com.ssk.model.repository.PostRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;

	public Long count() {
		return postRepository.count();
	}

	public boolean existsById(Long id) {
		return postRepository.existsById(id);
	}

	public void deleteAll() {
		postRepository.deleteAll();
	}

	public void deleteById(Long id) throws Exception {
		if(postRepository.existsById(id)) {
		postRepository.deleteById(id);
		}else {
			throw new Exception("Requested Resource with "+id+" does not exisists...");
		}
	}

	public Iterable<Post> findAll() {
		return postRepository.findAll();
	}

	public Optional<Post> findById(Long id) {
		return postRepository.findById(id);
	}

	public Post save(Post post) {
		 
		return postRepository.save(post);
	}

	public Iterable<Post> saveAll(Iterable<Post> posts) {
		return postRepository.saveAll(posts);

	}
	

}