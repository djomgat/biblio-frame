/*
 */
package com.sample.biblio.dao.impl.marche;

import com.sample.biblio.dao.impl.securite.ClassDaoImpl;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;

import com.sample.frame.be.dao.generic.GenericDaoJpaImpl;
import com.sample.frame.be.interceptor.AuthorizationInterceptor;
import com.sample.frame.be.interceptor.LoggingInterceptor;
import com.sample.frame.core.logging.BaseLogger;

import com.sample.biblio.model.marche.TabContrat;
import com.sample.biblio.dao.api.marche.IContratDao;

/**
 *
 * @author ECHOUPE
 */

@Stateless
@Interceptors({LoggingInterceptor.class,AuthorizationInterceptor.class})
public class ContratDaoImpl extends GenericDaoJpaImpl<TabContrat, String> 
                            implements IContratDao {
    
    @Inject
    private EntityManager em;
       
    private static final BaseLogger logger = BaseLogger.getLogger(ClassDaoImpl.class) ;

    @Override
    protected EntityManager getEntityManager() {
	return em;
    }

    @Override
    protected Class<TabContrat> getEntityClass() {
	return TabContrat.class;
    }
	
    public ContratDaoImpl() {
        
    }

    @Override
    protected BaseLogger getLogger() {		
	return logger;
    }

}