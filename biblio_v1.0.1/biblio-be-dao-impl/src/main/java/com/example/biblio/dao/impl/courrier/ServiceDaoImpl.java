/*

 */
package com.example.biblio.dao.impl.courrier;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;

import com.sample.frame.be.dao.generic.GenericDaoJpaImpl;
import com.sample.frame.be.interceptor.AuthorizationInterceptor;
import com.sample.frame.be.interceptor.LoggingInterceptor;
import com.sample.frame.core.logging.BaseLogger;

import com.sample.biblio.model.courrier.TabService;
import com.sample.biblio.dao.api.courrier.IServiceDao;

@Stateless
@Interceptors({LoggingInterceptor.class,AuthorizationInterceptor.class})
public class ServiceDaoImpl extends GenericDaoJpaImpl<TabService, String> implements IServiceDao {
    
    @Inject
    private EntityManager em;
       
    private static final BaseLogger logger = BaseLogger.getLogger(CourrierDaoImpl.class) ;

    @Override
    protected EntityManager getEntityManager() {
	return em;
    }

    @Override
    protected Class<TabService> getEntityClass() {
	return TabService.class;
    }
	
    public ServiceDaoImpl() {
	
    }

    @Override
    protected BaseLogger getLogger() {		
	return logger;
    }

}