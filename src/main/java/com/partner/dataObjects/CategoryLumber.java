package com.partner.dataObjects;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories_lumbers")
public class CategoryLumber {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_category_lumber")
	private int idCategoryLumber;

	@Column(name = "name_category")
	private String nameCategory;

	public CategoryLumber() {

	}

	public int getIdCategoryLumber() {
		return idCategoryLumber;
	}

	public void setIdCategoryLumber(int idCategoryLumber) {
		this.idCategoryLumber = idCategoryLumber;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCategoryLumber, nameCategory);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoryLumber other = (CategoryLumber) obj;
		return idCategoryLumber == other.idCategoryLumber && Objects.equals(nameCategory, other.nameCategory);
	}

}
