package com.partner.dataObjects;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories_prices")
public class CategoryPrice {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_category_price")
	private int idCategoryPrice;

	@Column(name = "name_category")
	private String nameCategoryPrice;

	private boolean discount;

	@Column(name = "discount_amount")
	private float discountAmount;

	public CategoryPrice() {

	}

	public int getIdCategoryPrice() {
		return idCategoryPrice;
	}

	public void setIdCategoryPrice(int idCategoryPrice) {
		this.idCategoryPrice = idCategoryPrice;
	}

	public String getNameCategoryPrice() {
		return nameCategoryPrice;
	}

	public void setNameCategoryPrice(String nameCategoryPrice) {
		this.nameCategoryPrice = nameCategoryPrice;
	}

	public boolean isDiscount() {
		return discount;
	}

	public void setDiscount(boolean discount) {
		this.discount = discount;
	}

	public float getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(float discountAmount) {
		this.discountAmount = discountAmount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCategoryPrice, discount, discountAmount, nameCategoryPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoryPrice other = (CategoryPrice) obj;
		return idCategoryPrice == other.idCategoryPrice && discount == other.discount
				&& Float.floatToIntBits(discountAmount) == Float.floatToIntBits(other.discountAmount)
				&& Objects.equals(nameCategoryPrice, other.nameCategoryPrice);
	}

}
