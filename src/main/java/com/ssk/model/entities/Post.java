package com.ssk.model.entities;

import javax.persistence.GeneratedValue;

public class Post {
	@javax.persistence.Id
	@GeneratedValue
	private Integer Id;
	private String description;
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JsonIgnore
//	private User user;

	public Post(Integer id, String description) {
		super();
		Id = id;
		this.description = description;

	}

	public Post() {
		super();
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
