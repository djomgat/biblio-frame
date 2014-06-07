package com.sample.biblio.be.impl;

import com.sample.biblio.be.dao.contract.IUserDao;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.sample.biblio.be.impl.exception.BiblioDaoExceptionForTestTransact;
import com.sample.biblio.be.impl.constant.BiblioBeConstant;
import com.sample.biblio.be.impl.constant.BiblioDaoMessageKey;
import com.sample.biblio.entity.Tabuser;
import com.sample.biblio.exception.BiblioDaoException;
import com.sample.frame.be.dao.generic.GenericDaoJpaImpl;
import com.sample.frame.core.exception.GenericDaoException;
import com.sample.frame.core.logging.FrameBaseLogger;

@Stateless
public class UserDaoImpl extends GenericDaoJpaImpl<Tabuser, String> implements IUserDao {

	@Inject
	private EntityManager em;

	private static FrameBaseLogger logger = FrameBaseLogger.getLogger(UserDaoImpl.class) ;

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
	
	@Override
	public <T extends Tabuser> void deleteNonAuthorise(T entity) throws GenericDaoException {
		throw new BiblioDaoExceptionForTestTransact(BiblioBeConstant.DAO_MESSAGE_FILE, BiblioDaoMessageKey.DAOUSER_DEL002, null);	
	}

	@Override
	public <T extends Tabuser> void createNonAuthoriseTestRollbackTransac(T entity)
			throws GenericDaoException {
		throw new BiblioDaoExceptionForTestTransact(BiblioBeConstant.DAO_MESSAGE_FILE, BiblioDaoMessageKey.DAOUSER_CRE002, null);		
	}
	
	@Override
	public <T extends Tabuser> void deleteNonAuthoriseForExceptionTest(T entity) throws Exception {
		throw new Exception("Suppresion Interdite pour cose de test deleteNonAuthoriseForExceptionTest");	
	}

	@Override
	public <T extends Tabuser> void createNonAuthoriseForExceptionTest(T entity)
			throws Exception {
		throw new Exception("Creation interdite pour code de test  createNonAuthoriseForExceptionTest");	
	}

	@Override
	protected FrameBaseLogger getLogger() {		
		return logger;
	}
	
}
