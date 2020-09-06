package com.ssk.model.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ssk.model.audit.Auditable;

@Entity
@Table(name = "incident")

public class Incident extends Auditable<String> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long ticketNumber;
	private String contact;
	private String priority;
	private String summary;
	private String description;
	private String status;
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	@Override
	public String toString() {
		return "Incident [ticketNumber=" + ticketNumber + ", contact=" + contact + ", priority=" + priority
				+ ", summary=" + summary + ", description=" + description + ", status=" + status + ", createdBy="
				+ createdBy + ", creationDate=" + creationDate + ", lastModifiedBy=" + lastModifiedBy
				+ ", lastModifiedDate=" + lastModifiedDate + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Incident))
			return false;
		return ticketNumber != null && ticketNumber.equals(((Incident) o).getTicketNumber());
	}

	@Override
	public int hashCode() {
		return 31;
	}

	public Long getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(Long ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
