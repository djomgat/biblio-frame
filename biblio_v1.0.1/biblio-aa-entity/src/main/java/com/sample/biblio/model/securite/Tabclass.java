package com.sample.biblio.model.securite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.sample.biblio.model.core.BiblioBaseEntity;

/**
 * The persistent class for the tabclass database table.
 * 
 */
@Entity
public class Tabclass extends BiblioBaseEntity  {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codeClass")
	private String codeClass;

	@Column(name="capacity")
	private int capacity;

	@Column(name="name")
	private String name;

	public Tabclass() {
	}

	public String getCodeClass() {
		return this.codeClass;
	}

	public void setCodeClass(String codeClass) {
		this.codeClass = codeClass;
	}

	public int getCapacity() {
		return this.capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}	

}