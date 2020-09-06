package com.ssk.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.ssk.model.entities.Incident;

public interface IncidentRepository extends CrudRepository<Incident, Long> {

}
