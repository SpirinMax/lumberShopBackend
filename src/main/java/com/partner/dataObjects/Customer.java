package com.partner.dataObjects;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_customer")
	private int idCustomer;

	private String phone;

	private String FIO;

	@Column(name = "legal_company")
	private boolean legalCompany;
	@Column(name = "name_company")
	private String nameCompany;
	@Column(name = "address_company")
	private String addressCompany;

	@OneToMany
	@JoinColumn(name = "id_customer")
	private Set<OrderLumber> ordersLumbers = new HashSet<>();

	public Customer() {

	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFIO() {
		return FIO;
	}

	public void setFIO(String fIO) {
		FIO = fIO;
	}

	public boolean isLegalCompany() {
		return legalCompany;
	}

	public void setLegalCompany(boolean legalCompany) {
		this.legalCompany = legalCompany;
	}

	public String getNameCompany() {
		return nameCompany;
	}

	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}

	public String getAddressCompany() {
		return addressCompany;
	}

	public void setAddressCompany(String addressCompany) {
		this.addressCompany = addressCompany;
	}

	public int getIdCustomer() {
		return idCustomer;
	}

	public Set<OrderLumber> getOrdersLumbers() {
		return ordersLumbers;
	}

	public void setOrdersLumbers(Set<OrderLumber> ordersLumbers) {
		this.ordersLumbers = ordersLumbers;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(FIO, addressCompany, idCustomer, legalCompany, nameCompany, phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return idCustomer == other.idCustomer && Objects.equals(phone, other.phone) && Objects.equals(FIO, other.FIO)
				&& Objects.equals(addressCompany, other.addressCompany) && legalCompany == other.legalCompany
				&& Objects.equals(nameCompany, other.nameCompany);
	}
}
