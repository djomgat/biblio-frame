package com.sample.arquillian;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.sample.biblio.constant.be.BiblioBeConstant;
import com.sample.biblio.constant.be.BiblioDaoMessageKey;
import com.sample.biblio.entity.sample.Tabuser;
import com.sample.biblio.exceptions.BiblioDaoException;
import com.sample.frame.be.dao.generic.GenericDaoJpaImpl;
import com.sample.frame.core.exception.GenericDaoException;

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
	
	
	public <T extends Tabuser> void deleteNonAuthorise(T entity) throws GenericDaoException {
		throw new BiblioDaoException(BiblioBeConstant.DAO_MESSAGE_FILE, BiblioDaoMessageKey.DAOCLASS_DEL002.getValue(), null);	
	}

	@Override
	public <T extends Tabuser> void createNonAuthorise(T entity)
			throws GenericDaoException {
		throw new BiblioDaoException(BiblioBeConstant.DAO_MESSAGE_FILE, BiblioDaoMessageKey.DAOCLASS_CRE002.getValue(), null);
		
	}

	
	

	
}
