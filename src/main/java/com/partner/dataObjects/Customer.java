package com.partner.dataObjects;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_customer")
	private int idCustomer;

	private String phone;

	private String FIO;
	
	private String address;

	@Column(name = "legal_company")
	private boolean legalCompany;
	@Column(name = "name_company")
	private String nameCompany;
	@Column(name = "address_company")
	private String addressCompany;

	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_customer")
	private Set<OrderLumber> ordersLumbers = new HashSet<>();

	public Customer() {

	}

	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public Set<OrderLumber> getOrdersLumbers() {
		return ordersLumbers;
	}

	public void setOrdersLumbers(Set<OrderLumber> ordersLumbers) {
		this.ordersLumbers = ordersLumbers;
	}

	@Override
	public int hashCode() {
		return Objects.hash(FIO, address, addressCompany, idCustomer, legalCompany, nameCompany, phone);
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
		return Objects.equals(FIO, other.FIO) && Objects.equals(address, other.address)
				&& Objects.equals(addressCompany, other.addressCompany) && idCustomer == other.idCustomer
				&& legalCompany == other.legalCompany && Objects.equals(nameCompany, other.nameCompany)
				&& Objects.equals(phone, other.phone);
	}
}
