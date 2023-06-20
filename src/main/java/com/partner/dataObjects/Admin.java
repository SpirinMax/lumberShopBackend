package com.partner.dataObjects;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "adms")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_admin")
	private int idAdm;
	private String name;
	private String login;
	private String password;
	@Column(name = "last_entry_time")
	private Date lastEntryTime;

	public int getIdAdm() {
		return idAdm;
	}

	public void setIdAdm(int idAdm) {
		this.idAdm = idAdm;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Date getLastEntryTime() {
		return lastEntryTime;
	}

	public void setLastEntryTime(Date lastEntryTime) {
		this.lastEntryTime = lastEntryTime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idAdm, lastEntryTime, login, name, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		return idAdm == other.idAdm && Objects.equals(lastEntryTime, other.lastEntryTime)
				&& Objects.equals(login, other.login) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password);
	}

}
