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

import com.sample.biblio.model.courrier.TabTypeCourrier;
import com.sample.biblio.dao.api.courrier.ITypeCourrierDao;

@Stateless
@Interceptors({LoggingInterceptor.class,AuthorizationInterceptor.class})
public class TypeCourrierImpl extends GenericDaoJpaImpl<TabTypeCourrier, String> 
                              implements ITypeCourrierDao {
    
    @Inject
    private EntityManager em;
       
    private static final BaseLogger logger = BaseLogger.getLogger(CourrierDaoImpl.class) ;

    @Override
    protected EntityManager getEntityManager() {
	return em;
    }

    @Override
    protected Class<TabTypeCourrier> getEntityClass() {
	return TabTypeCourrier.class;
    }
	
    public TypeCourrierImpl() {
	
    }

    @Override
    protected BaseLogger getLogger() {		
	return logger;
    }

}

