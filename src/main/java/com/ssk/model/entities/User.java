package com.ssk.model.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ssk.model.audit.Auditable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = { "id","roles" }, allowGetters = true)
public class User extends Auditable<String> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	@Column(nullable = false, unique = true)

	private String username;
	@Column(nullable = false)
	private String password;

	@Transient
	private String passwordConfirm;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<Role> roles;
	private String first_name;
	private String last_name;
	private String email;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String zip;
	private String phoneNumber;
	

}
