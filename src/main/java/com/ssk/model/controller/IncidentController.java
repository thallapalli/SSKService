package com.ssk.model.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssk.model.entities.Incident;
import com.ssk.model.exception.ResourceNotFoundException;
import com.ssk.model.service.IncidentService;

@RestController
@RequestMapping("/incident")
public class IncidentController {
	@Autowired
	IncidentService incidentService;

	
	@GetMapping(value = "/count")
	public Long count() {
		return incidentService.count();
	}
	@GetMapping(value = "/{id}/exists")
	public boolean existsById(@PathVariable Long id) {
		return incidentService.existsById(id);
	}
	@DeleteMapping(value = "/")
	public void deleteAll() {
		incidentService.deleteAll();
	}
	@DeleteMapping(value = "/{id}")
	public void deleteById(@PathVariable Long id) throws ResourceNotFoundException {
		incidentService.deleteById(id);
	}
	@GetMapping(value = "/all")
	public Iterable<Incident> findAll() {
		return incidentService.findAll();
	}
	@GetMapping(value = "/{id}")
	public Optional<Incident> findById(@PathVariable Long id) {
		return incidentService.findById(id);
	}
	@PostMapping(value = "/create")
	public Incident save(@RequestBody Incident incident) {
		return incidentService.save(incident);
	}
	@PostMapping(value = "/saveall")
	public Iterable<Incident> saveAll(@RequestBody Iterable<Incident> incidents) {
		return incidentService.saveAll(incidents);

	}
	

}
