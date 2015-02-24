package com.sample.biblio.dao.api.securite;

import javax.ejb.Local;

import com.sample.biblio.model.securite.Tabuser;
import com.sample.frame.be.dao.generic.IGenericDao;
import com.sample.frame.core.exception.GenericDaoException;

@Local
public interface IUserDao extends IGenericDao<Tabuser, String> {
	
    <T extends Tabuser> void deleteNonAuthorise(T entity) throws GenericDaoException;
    <T extends Tabuser> void createNonAuthoriseTestRollbackTransac(T entity) throws GenericDaoException;
    <T extends Tabuser> void deleteNonAuthoriseForExceptionTest(T entity) throws GenericDaoException, Exception;
    <T extends Tabuser> void createNonAuthoriseForExceptionTest(T entity) throws GenericDaoException, Exception;
    
}