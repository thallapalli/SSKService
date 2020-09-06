package com.ssk.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.ssk.model.entities.UserDetails;

public interface UserDetailsRespository extends CrudRepository<UserDetails, Long>  {

}
