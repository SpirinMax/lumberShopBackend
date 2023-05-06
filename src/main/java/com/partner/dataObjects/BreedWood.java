package com.partner.dataObjects;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "breeds_woods")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class BreedWood {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_breed_wood")
	private int idBreed;

	@Column(name = "name_breed")
	private String nameBreed;

	@Column(name = "breed_woood")
	private String varietyBreed;

	public BreedWood() {

	}

	public String getNameBreed() {
		return nameBreed;
	}

	public void setNameBreed(String nameBreed) {
		this.nameBreed = nameBreed;
	}

	public String getVarietyBreed() {
		return varietyBreed;
	}

	public void setVarietyBreed(String varietyBreed) {
		this.varietyBreed = varietyBreed;
	}

	public int getIdBreed() {
		return idBreed;
	}

	public void setIdBreed(int idBreed) {
		this.idBreed = idBreed;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idBreed, nameBreed, varietyBreed);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BreedWood other = (BreedWood) obj;
		return idBreed == other.idBreed && Objects.equals(nameBreed, other.nameBreed)
				&& Objects.equals(varietyBreed, other.varietyBreed);
	}

}
