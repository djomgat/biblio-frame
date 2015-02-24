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

import com.sample.biblio.dao.impl.securite.ClassDaoImpl;
import com.sample.biblio.model.marche.TabConsultation;
import com.sample.biblio.dao.api.marche.IConsultationDao;

/**
 *
 * @author ECHOUPE
 */

@Stateless
@Interceptors({LoggingInterceptor.class,AuthorizationInterceptor.class})
public class ConsultationDaoImpl extends GenericDaoJpaImpl<TabConsultation, String> 
                            implements IConsultationDao {
    
    @Inject
    private EntityManager em;
       
    private static final BaseLogger logger = BaseLogger.getLogger(ConsultationDaoImpl.class) ;

    @Override
    protected EntityManager getEntityManager() {
	return em;
    }

    @Override
    protected Class<TabConsultation> getEntityClass() {
	return TabConsultation.class;
    }
	
    public ConsultationDaoImpl() {
        
    }

    @Override
    protected BaseLogger getLogger() {		
	return logger;
    }

}