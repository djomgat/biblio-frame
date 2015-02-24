package com.sample.biblio.dao.impl.securite;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;

import com.sample.frame.be.dao.generic.GenericDaoJpaImpl;
import com.sample.frame.be.interceptor.AuthorizationInterceptor;
import com.sample.frame.be.interceptor.LoggingInterceptor;
import com.sample.frame.core.logging.BaseLogger;

import com.sample.biblio.model.securite.TabMouchard;
import com.sample.biblio.dao.api.securite.IMouchardDao;

/**
 *
 * @author ECHOUPE
 */
@Stateless
@Interceptors({LoggingInterceptor.class,AuthorizationInterceptor.class})
public class MouchardDaoImpl extends GenericDaoJpaImpl<TabMouchard, String> implements IMouchardDao {
    
    @Inject
    private EntityManager em;
       
    private static final BaseLogger logger = BaseLogger.getLogger(MouchardDaoImpl.class) ;

    @Override
    protected EntityManager getEntityManager() {
	return em;
    }

    @Override
    protected Class<TabMouchard> getEntityClass() {
	return TabMouchard.class;
    }
	
    public MouchardDaoImpl() {
	
    }

    @Override
    protected BaseLogger getLogger() {		
	return logger;
    }

}