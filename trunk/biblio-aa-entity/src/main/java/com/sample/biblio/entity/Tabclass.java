package com.sample.biblio.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.sample.frame.core.entity.GenericEntity;


/**
 * The persistent class for the tabclass database table.
 * 
 */
@Entity
public class Tabclass extends GenericEntity  {
	private static final long serialVersionUID = 1L;

	@Id
	private String codeClass;

	private int capacity;

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