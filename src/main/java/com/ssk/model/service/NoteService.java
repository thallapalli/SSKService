package com.ssk.model.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssk.model.entities.Department;
import com.ssk.model.entities.Note;
import com.ssk.model.exception.ResourceNotFoundException;
import com.ssk.model.repository.DepartmentRepository;
import com.ssk.model.repository.NoteRepository;

@Service
public class NoteService {
	@Autowired
	private NoteRepository noteRepository;

	public Note createIncident(Note note) {

		return noteRepository.save(note);
	}

	public Long count() {
		// TODO Auto-generated method stub
		return noteRepository.count();
	}

	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return noteRepository.existsById(id);
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		noteRepository.deleteAll();

	}

	public void deleteById(Long id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		if (existsById(id)) {
			noteRepository.deleteById(id);
		} else {
			throw new ResourceNotFoundException(String.valueOf(id));
		}

	}

	public Iterable<Note> findAll() {
		// TODO Auto-generated method stub
		return noteRepository.findAll();
	}

	public Optional<Note> findById(Long id) {
		// TODO Auto-generated method stub
		return noteRepository.findById(id);
	}

	public Note save(Note note) {
		// TODO Auto-generated method stub
		return noteRepository.save(note);
	}

	public Iterable<Note> saveAll(Iterable<Note> notes) {
		// TODO Auto-generated method stub
		return noteRepository.saveAll(notes);
	}
	
	
	

}
