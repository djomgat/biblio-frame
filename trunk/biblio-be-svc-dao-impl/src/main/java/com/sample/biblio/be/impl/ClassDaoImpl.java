package com.sample.biblio.be.impl;

import com.sample.biblio.be.dao.contract.IClassDao;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;

import com.sample.biblio.entity.Tabclass;
import com.sample.frame.be.dao.generic.GenericDaoJpaImpl;
import com.sample.frame.be.interceptor.AuthorizationInterceptor;
import com.sample.frame.be.interceptor.LoggingInterceptor;
import com.sample.frame.core.logging.FrameBaseLogger;

@Stateless
@Interceptors({LoggingInterceptor.class,AuthorizationInterceptor.class})
public class ClassDaoImpl extends GenericDaoJpaImpl<Tabclass, String> implements
		IClassDao {

	
	@Inject
	private EntityManager em;

	private static FrameBaseLogger logger = FrameBaseLogger.getLogger(ClassDaoImpl.class) ;

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

	@Override
	protected FrameBaseLogger getLogger() {		
		return logger;
	}

}
