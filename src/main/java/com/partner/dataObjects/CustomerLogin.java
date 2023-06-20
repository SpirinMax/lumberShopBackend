package com.partner.dataObjects;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers_login")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class CustomerLogin {
	@Id
	@Column(name = "id_customer")
	private int idCustomer;

	private String login;

	private String password;

	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCustomer, login, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerLogin other = (CustomerLogin) obj;
		return idCustomer == other.idCustomer && Objects.equals(login, other.login)
				&& Objects.equals(password, other.password);
	}
}
