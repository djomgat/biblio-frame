package com.sample.biblio.dao.provider;

import com.sample.biblio.dao.api.IClassDao;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import com.sample.biblio.model.Tabclass;

import com.sample.frame.be.dao.generic.GenericDaoJpaImpl;
import com.sample.frame.be.interceptor.AuthorizationInterceptor;
import com.sample.frame.be.interceptor.LoggingInterceptor;
import com.sample.frame.core.logging.FrameBaseLogger;


@Stateless
@Interceptors({LoggingInterceptor.class,AuthorizationInterceptor.class})
public class ClassDaoImpl extends GenericDaoJpaImpl<Tabclass, String> implements IClassDao {
    
    @Inject
    private EntityManager em;
       
    private static final FrameBaseLogger logger = FrameBaseLogger.getLogger(ClassDaoImpl.class) ;

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