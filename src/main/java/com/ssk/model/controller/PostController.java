package com.ssk.model.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssk.model.entities.Post;
import com.ssk.model.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
	@Autowired
	PostService postService;

	@GetMapping(value = "/hello")
	public String hello() {
		return "Hello ,welcome to SSKS!!!";

	}
	@GetMapping(value = "/count")
	public Long count() {
		return postService.count();
	}
	@GetMapping(value = "/{id}/exists")
	public boolean existsById(@PathVariable Long id) {
		return postService.existsById(id);
	}
	@DeleteMapping(value = "/")
	public void deleteAll() {
		postService.deleteAll();
	}
	@DeleteMapping(value = "/{id}")
	public void deleteById(@PathVariable Long id) throws Exception {
		postService.deleteById(id);
	}
	@GetMapping(value = "/all")
	public Iterable<Post> findAll() {
		return postService.findAll();
	}
	@GetMapping(value = "/{id}")
	public Optional<Post> findById(@PathVariable Long id) {
		return postService.findById(id);
	}
	@PostMapping(value = "/create")
	public Post save(@RequestBody Post post) {
		return postService.save(post);
	}
	@PostMapping(value = "/saveall")
	public Iterable<Post> saveAll(@RequestBody Iterable<Post> posts) {
		return postService.saveAll(posts);

	}
	
	
	
	
}
