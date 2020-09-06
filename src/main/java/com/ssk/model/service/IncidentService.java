package com.ssk.model.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssk.model.entities.Incident;
import com.ssk.model.exception.ResourceNotFoundException;
import com.ssk.model.repository.IncidentRepository;

@Service
public class IncidentService {
	@Autowired
	private IncidentRepository incidentRepository;

	public Incident createIncident(Incident incident) {

		return incidentRepository.save(incident);
	}

	public Long count() {
		// TODO Auto-generated method stub
		return incidentRepository.count();
	}

	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return incidentRepository.existsById(id);
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		incidentRepository.deleteAll();

	}

	public void deleteById(Long id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		if (existsById(id)) {
			incidentRepository.deleteById(id);
		} else {
			throw new ResourceNotFoundException(String.valueOf(id));
		}

	}

	public Iterable<Incident> findAll() {
		// TODO Auto-generated method stub
		return incidentRepository.findAll();
	}

	public Optional<Incident> findById(Long id) {
		// TODO Auto-generated method stub
		return incidentRepository.findById(id);
	}

	public Incident save(Incident incident) {
		// TODO Auto-generated method stub
		return incidentRepository.save(incident);
	}

	public Iterable<Incident> saveAll(Iterable<Incident> incidents) {
		// TODO Auto-generated method stub
		return incidentRepository.saveAll(incidents);
	}

}
