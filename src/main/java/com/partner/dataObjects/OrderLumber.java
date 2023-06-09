package com.partner.dataObjects;

import java.util.Date;
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
@Table(name = "orders_lumbers")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class OrderLumber {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_order")
	private int idOrder;
	
	@Column(name = "id_customer")
	private int idCustomer;

	@ManyToOne
	@JoinColumn(name = "id_price")
	private PriceLumber priceLumber;

	@Column(name = "quantity_by_price_category")
	private double quantity;

	@Column(name = "final_price")
	private double finalPrice;

	@Column(name = "date_order")
	private Date dateOrder;

	public OrderLumber() {

	}

	public PriceLumber getPriceLumber() {
		return priceLumber;
	}

	public void setPriceLumber(PriceLumber priceLumber) {
		this.priceLumber = priceLumber;
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}

	public Date getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}

	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateOrder, finalPrice, idCustomer, idOrder, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderLumber other = (OrderLumber) obj;
		return Objects.equals(dateOrder, other.dateOrder)
				&& Double.doubleToLongBits(finalPrice) == Double.doubleToLongBits(other.finalPrice)
				&& idCustomer == other.idCustomer && idOrder == other.idOrder
				&& Double.doubleToLongBits(quantity) == Double.doubleToLongBits(other.quantity);
	}
}
