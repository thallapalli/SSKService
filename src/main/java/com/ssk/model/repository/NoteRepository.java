package com.ssk.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.ssk.model.entities.Note;

public interface NoteRepository extends CrudRepository<Note, Long> {
	
    
}
