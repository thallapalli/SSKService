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

import com.ssk.model.entities.Note;
import com.ssk.model.exception.ResourceNotFoundException;
import com.ssk.model.service.NoteService;

@RestController
@RequestMapping("/notes")
@CrossOrigin(origins = "http://locahost:5000", maxAge = 3600)
public class NoteController {
	@Autowired
	NoteService noteService;
	
	@GetMapping(value = "/count")
	public Long count() {
		return noteService.count();
	}

	@GetMapping(value = "/{id}/exists")
	public boolean existsById(@PathVariable Long id) {
		return noteService.existsById(id);
	}

	@DeleteMapping(value = "/")
	public void deleteAll() {
		noteService.deleteAll();
	}

	@DeleteMapping(value = "/{id}")
	public void deleteById(@PathVariable Long id) throws ResourceNotFoundException {
		noteService.deleteById(id);
	}

	@GetMapping(value = "/")
	public Iterable<Note> findAll() {
		return noteService.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<Note> findById(@PathVariable Long id) {
		return noteService.findById(id);
	}

	@PostMapping(value = "/")
	public Note save(@RequestBody Note note) {
		return noteService.save(note);
	}

	@PutMapping(value = "/")
	public Note update(@RequestBody Note note) {
		return noteService.save(note);
	}

	@PostMapping(value = "/saveall")
	public Iterable<Note> saveAll(@RequestBody Iterable<Note> notes) {
		return noteService.saveAll(notes);

	}


}
