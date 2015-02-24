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

import com.sample.biblio.model.marche.TabSociete;
import com.sample.biblio.dao.api.marche.ISocieteDao;

/**
 *
 * @author ECHOUPE
 */

@Stateless
@Interceptors({LoggingInterceptor.class,AuthorizationInterceptor.class})
public class SocieteDaoImpl extends GenericDaoJpaImpl<TabSociete, String> 
                            implements ISocieteDao {
    
    @Inject
    private EntityManager em;
       
    private static final BaseLogger logger = BaseLogger.getLogger(SocieteDaoImpl.class) ;

    @Override
    protected EntityManager getEntityManager() {
	return em;
    }

    @Override
    protected Class<TabSociete> getEntityClass() {
	return TabSociete.class;
    }
	
    public SocieteDaoImpl() {
        
    }

    @Override
    protected BaseLogger getLogger() {		
	return logger;
    }

}