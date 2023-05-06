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
import jakarta.persistence.Table;

@Entity
@Table(name = "prices_lumbers")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class PriceLumber {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_price")
	private int idPrice;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_lumber")
	private Lumber lumber;

	private float price;

	@Column(name = "discount_price")
	private float discountPrice;

	@ManyToOne
	@JoinColumn(name = "id_category_price")
	private CategoryPrice categoryPrice;

	public int getIdPrice() {
		return idPrice;
	}

	public Lumber getLumber() {
		return lumber;
	}

	public void setLumber(Lumber lumber) {
		this.lumber = lumber;
	}

	public void setIdPrice(int idPrice) {
		this.idPrice = idPrice;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(float discountPrice) {
		this.discountPrice = discountPrice;
	}

	public CategoryPrice getCategoryPrice() {
		return categoryPrice;
	}

	public void setCategoryPrice(CategoryPrice categoryPrice) {
		this.categoryPrice = categoryPrice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoryPrice, discountPrice, idPrice, lumber, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PriceLumber other = (PriceLumber) obj;
		return Objects.equals(categoryPrice, other.categoryPrice)
				&& Float.floatToIntBits(discountPrice) == Float.floatToIntBits(other.discountPrice)
				&& idPrice == other.idPrice && Objects.equals(lumber, other.lumber)
				&& Float.floatToIntBits(price) == Float.floatToIntBits(other.price);
	}

}
