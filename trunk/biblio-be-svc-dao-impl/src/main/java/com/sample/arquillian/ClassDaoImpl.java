package com.sample.arquillian;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.sample.biblio.entity.sample.Tabclass;
import com.sample.frame.be.dao.generic.GenericDaoJpaImpl;

@Stateless
public class ClassDaoImpl extends GenericDaoJpaImpl<Tabclass, String> implements
		IClassDao {

	
	@Inject
	private EntityManager em;

	@Inject
	private Logger log;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	@Override
	protected Class<Tabclass> getEntityClass() {
		return Tabclass.class;
	}
	
	public ClassDaoImpl() {
	
	}

}
