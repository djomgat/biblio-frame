package com.sample.arquillian;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.sample.biblio.entity.sample.Tabuser;
import com.sample.frame.be.dao.generic.GenericDaoJpaImpl;

@Stateless
public class UserDaoImpl extends GenericDaoJpaImpl<Tabuser, String> implements IUserDao {

	@Inject
	private EntityManager em;

	@Inject
	private Logger log;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	@Override
	protected Class<Tabuser> getEntityClass() {
		return Tabuser.class;
	}
	
	public UserDaoImpl() {
		
	}

	
}
