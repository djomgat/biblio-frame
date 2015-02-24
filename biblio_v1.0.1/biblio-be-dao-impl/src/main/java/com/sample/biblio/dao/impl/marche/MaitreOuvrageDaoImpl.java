/*
 */
package com.sample.biblio.dao.impl.marche;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;

import com.sample.frame.be.dao.generic.GenericDaoJpaImpl;
import com.sample.frame.be.interceptor.AuthorizationInterceptor;
import com.sample.frame.be.interceptor.LoggingInterceptor;
import com.sample.frame.core.logging.BaseLogger;

import com.sample.biblio.model.marche.TabMoa;
import com.sample.biblio.dao.api.marche.IMaitreOuvrageDao;

/**
 *
 * @author ECHOUPE
 */

@Stateless
@Interceptors({LoggingInterceptor.class,AuthorizationInterceptor.class})
public class MaitreOuvrageDaoImpl extends GenericDaoJpaImpl<TabMoa, String> 
                            implements IMaitreOuvrageDao {
    
    @Inject
    private EntityManager em;
       
    private static final BaseLogger logger = BaseLogger.getLogger(MaitreOuvrageDaoImpl.class) ;

    @Override
    protected EntityManager getEntityManager() {
	return em;
    }

    @Override
    protected Class<TabMoa> getEntityClass() {
	return TabMoa.class;
    }
	
    public MaitreOuvrageDaoImpl() {
        
    }

    @Override
    protected BaseLogger getLogger() {		
	return logger;
    }

}
