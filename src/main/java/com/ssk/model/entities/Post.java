package com.ssk.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
@Entity
@Table(name = "post")
public class Post {
	@javax.persistence.Id
	@GeneratedValue
	private Long Id;
	private String description;
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JsonIgnore
//	private User user;

	public Post(Long id, String description) {
		super();
		Id = id;
		this.description = description;

	}

	public Post() {
		super();
	}

	

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
