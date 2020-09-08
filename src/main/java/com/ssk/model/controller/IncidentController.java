package com.ssk.model.controller;

import java.util.Optional;

import javax.validation.Valid;

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

import com.ssk.model.entities.Incident;
import com.ssk.model.entities.User;
import com.ssk.model.exception.ResourceNotFoundException;
import com.ssk.model.service.IncidentService;
import com.ssk.model.service.UserServiceImpl;

@RestController
@RequestMapping("/incidents")
@CrossOrigin(origins = "http://locahost:5000", maxAge = 3600)
public class IncidentController {
	@Autowired
	IncidentService incidentService;
	@Autowired
	UserServiceImpl userServiceImpl;

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

	@GetMapping(value = "/")
	public Iterable<Incident> findAll() {
		return incidentService.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<Incident> findById(@PathVariable Long id) {
		return incidentService.findById(id);
	}

	@PostMapping(value = "/")
	public Incident save(@RequestBody Incident incident) {
		return incidentService.save(incident);
	}

	@PutMapping(value = "/")
	public Incident update(@RequestBody Incident incident) {
		return incidentService.save(incident);
	}

	@PostMapping(value = "/saveall")
	public Iterable<Incident> saveAll(@RequestBody Iterable<Incident> incidents) {
		return incidentService.saveAll(incidents);

	}

	@PostMapping("/user/{userId}/incidents")
	public Incident createIncident(@PathVariable(value = "userId") Long userId, @Valid @RequestBody Incident incident)
			throws ResourceNotFoundException {

		if (userServiceImpl.existsById(userId)) {

			Optional<User> user = userServiceImpl.findById(userId);
			User user1 = user.get();
			//incident.setUser(user1);
			return incidentService.save(incident);

		} else {
			throw new ResourceNotFoundException(userId + " Not found while creating Incident");
		}

	}

	@PutMapping("/user/{userId}/incidents/{incidentId}")
	public Incident updateIncident(@PathVariable(value = "userId") Long userId,
			@PathVariable(value = "incidentNumber") Long incidentId, @Valid @RequestBody Incident incident)
			throws ResourceNotFoundException {

		if (!userServiceImpl.existsById(userId)) {

			throw new ResourceNotFoundException(userId + " Not found while updateing Incident");

		} else {
			Optional<Incident> findById = incidentService.findById(incidentId);
			
			Incident incident2 = findById.get();
			if(null!=incident2) {
			incident2.setSummary(incident.getSummary());
			return incidentService.save(incident2);
			
			}else {
				return incidentService.save(incident);
			}
		}

	}

}
