package com.sample.biblio.dao.provider;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.sample.biblio.exception.BiblioDaoExceptionForTestTransact;
import com.sample.biblio.constant.be.BiblioBeConstant;
import com.sample.biblio.constant.be.BiblioDaoMessageKey;

import com.sample.frame.be.dao.generic.GenericDaoJpaImpl;
import com.sample.frame.core.exception.GenericDaoException;
import com.sample.frame.core.logging.BaseLogger;

import com.sample.biblio.dao.api.IUserDao;
import com.sample.biblio.model.Tabuser;

@Stateless
public class UserDaoImpl extends GenericDaoJpaImpl<Tabuser, String> implements IUserDao {

  
        @Inject
        private EntityManager em;

	private static final BaseLogger logger = BaseLogger.getLogger(UserDaoImpl.class) ;

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
		throw new BiblioDaoExceptionForTestTransact(BiblioBeConstant.DAO_MESSAGE_FILE, 
				  BiblioDaoMessageKey.DAOUSER_DEL002, null);	
	}

	@Override
	public <T extends Tabuser> void createNonAuthoriseTestRollbackTransac(T entity)
			throws GenericDaoException {
		throw new BiblioDaoExceptionForTestTransact(BiblioBeConstant.DAO_MESSAGE_FILE, 
				  BiblioDaoMessageKey.DAOUSER_CRE002, null);		
	}
	
	@Override
	public <T extends Tabuser> void deleteNonAuthoriseForExceptionTest(T entity) throws Exception {
		throw new Exception("Suppresion Interdite pour cause de test deleteNonAuthoriseForExceptionTest");	
	}

	@Override
	public <T extends Tabuser> void createNonAuthoriseForExceptionTest(T entity)
			throws Exception {
		throw new Exception("Creation interdite pour code de test createNonAuthoriseForExceptionTest");	
	}

	@Override
	protected BaseLogger getLogger() {		
		return logger;
	}
	
}