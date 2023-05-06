package com.partner.dataObjects;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "lumbers_parameters")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ParametersLumber {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_lumber_parameters")
	private int idParamemtersLumber;

	@ManyToOne
	@JoinColumn(name = "id_category")
	private CategoryLumber categoryLumber;

	@ManyToOne
	@JoinColumn(name = "id_breed")
	private BreedWood breedWood;

	@Column(name = "variety_lumber")
	private String varietyLumber;

	private int diameter;

	private int width;

	private int lenght;

	private int thickness;

	@Column(name = "image_for_card")
	private byte[] imageLumber;

	public ParametersLumber() {

	}

	public int getIdParamemtersLumber() {
		return idParamemtersLumber;
	}

	public void setIdParamemtersLumber(int idParamemtersLumber) {
		this.idParamemtersLumber = idParamemtersLumber;
	}

	public CategoryLumber getCategoryLumber() {
		return categoryLumber;
	}

	public void setCategoryLumber(CategoryLumber categoryLumber) {
		this.categoryLumber = categoryLumber;
	}

	public BreedWood getBreedWood() {
		return breedWood;
	}

	public void setBreedWood(BreedWood breedWood) {
		this.breedWood = breedWood;
	}

	public String getVarietyLumber() {
		return varietyLumber;
	}

	public void setVarietyLumber(String varietyLumber) {
		this.varietyLumber = varietyLumber;
	}

	public int getDiameter() {
		return diameter;
	}

	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLenght() {
		return lenght;
	}

	public void setLenght(int lenght) {
		this.lenght = lenght;
	}

	public int getThickness() {
		return thickness;
	}

	public void setThickness(int thickness) {
		this.thickness = thickness;
	}

	public byte[] getImageLumber() {
		return imageLumber;
	}

	public void setImageLumber(byte[] imageLumber) {
		this.imageLumber = imageLumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idParamemtersLumber, diameter, lenght, thickness, varietyLumber, width, breedWood,
				categoryLumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParametersLumber other = (ParametersLumber) obj;
		return idParamemtersLumber == other.idParamemtersLumber && diameter == other.diameter && lenght == other.lenght
				&& thickness == other.thickness && Objects.equals(varietyLumber, other.varietyLumber)
				&& width == other.width && Objects.equals(breedWood, other.breedWood)
				&& Objects.equals(categoryLumber, other.categoryLumber);
	}

}
