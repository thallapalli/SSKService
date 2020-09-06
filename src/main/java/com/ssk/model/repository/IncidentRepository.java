package com.ssk.model.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.ssk.model.entities.Incident;

public interface IncidentRepository extends CrudRepository<Incident, Long> {
	Page<Incident> findByUserId(Long postId, Pageable pageable);
    Optional<Incident> findByincidentNumberAndUserId(Long incidentNumber, Long userId);
    
}
