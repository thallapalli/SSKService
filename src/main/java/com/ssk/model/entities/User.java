package com.ssk.model.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class User {
	@Id
	@GeneratedValue
	
	private Long id;
	@Size(min = 2,max = 50)
	private String first_name;//	varchar(50),
	@Size(min = 2,max = 50)
	private String last_name;//		varchar(50) not null,
	@Size(min = 2,max = 100)
	private String email;//			varchar(100) not null unique,
	@Size(min = 2,max = 30)
	private String password;//		varchar(30) not null,
	private Timestamp registration_date;//
	
	public User() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(Timestamp registration_date) {
		this.registration_date = registration_date;
	}
	
	
}
	