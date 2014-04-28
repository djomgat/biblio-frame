package com.sample.arquillian;

import javax.ejb.Local;

import com.sample.biblio.entity.sample.Tabuser;
import com.sample.frame.be.dao.generic.IGenericDao;
import com.sample.frame.core.exception.GenericDaoException;

@Local
public interface IUserDao extends IGenericDao<Tabuser, String> {
	
	 <T extends Tabuser> void deleteNonAuthorise(T entity) throws GenericDaoException;
	 
	 <T extends Tabuser> void createNonAuthorise(T entity) throws GenericDaoException;

}
