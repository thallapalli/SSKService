package com.ssk.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssk.model.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
