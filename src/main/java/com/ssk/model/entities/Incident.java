package com.ssk.model.entities;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ssk.model.audit.Auditable;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "incident")
@JsonIgnoreProperties(value = { "incidentNumber" }, allowGetters = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Incident extends Auditable<String> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long incidentId;
	private String contact;
	private String priority;
	@NotNull
	@Size(max = 100)
	private String summary;

	private String description;
	private String status;
	

	

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Incident))
			return false;
		return incidentId != null && incidentId.equals(((Incident) o).getIncidentId());
	}

	@Override
	public int hashCode() {
		return 31;
	}

}
