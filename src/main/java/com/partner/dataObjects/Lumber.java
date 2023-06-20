package com.partner.dataObjects;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "lumbers")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Lumber {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_lumber")
	private int idLumber;

	@Column(name = "name_lumber")
	private String nameLumber;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_lumber_parameters")
	private ParametersLumber parametersLumber;
	
	private boolean availability;

	public Lumber() {

	}

	public int getIdLumber() {
		return idLumber;
	}

	public void setIdLumber(int idLumber) {
		this.idLumber = idLumber;
	}

	public String getNameLumber() {
		return nameLumber;
	}

	public void setNameLumber(String nameLumber) {
		this.nameLumber = nameLumber;
	}

	public ParametersLumber getParametersLumber() {
		return parametersLumber;
	}

	public void setParametersLumber(ParametersLumber parametersLumber) {
		this.parametersLumber = parametersLumber;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	@Override
	public int hashCode() {
		return Objects.hash(availability, idLumber, nameLumber, parametersLumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lumber other = (Lumber) obj;
		return availability == other.availability && idLumber == other.idLumber
				&& Objects.equals(nameLumber, other.nameLumber)
				&& Objects.equals(parametersLumber, other.parametersLumber);
	}
}
