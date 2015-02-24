package com.sample.biblio.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sample.frame.core.entity.GenericEntity;

/**
 * The persistent class for the tabuser database table.
 * 
 */
@Entity
public class Tabuser extends GenericEntity {
	private static final long serialVersionUID = 1L;

	@Id
	private String codeUser;

	private String birthDate;

	private String firstName;

	private String lastName;

	private String login;

	private String password;

	//bi-directional many-to-one association to Tabclass
	@ManyToOne
	@JoinColumn(name="CodeClass")
	private Tabclass tabclass;

	public Tabuser() {
	}

	public String getCodeUser() {
		return this.codeUser;
	}

	public void setCodeUser(String codeUser) {
		this.codeUser = codeUser;
	}

	public String getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Tabclass getTabclass() {
		return this.tabclass;
	}

	public void setTabclass(Tabclass tabclass) {
		this.tabclass = tabclass;
	}

}