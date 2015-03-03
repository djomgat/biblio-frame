/*
 */
package com.sample.biblio.dao.impl.marche;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import com.sample.frame.be.interceptor.AuthorizationInterceptor;
import com.sample.frame.be.interceptor.LoggingInterceptor;
import com.sample.frame.core.logging.BaseLogger;

import com.sample.biblio.model.marche.TabConsultation;
import com.sample.biblio.dao.api.marche.IConsultationDao;
import com.sample.biblio.dao.impl.generic.BiblioGenericDao;

/**
 *
 * @author ECHOUPE
 */

@Stateless

public class ConsultationDaoImpl extends BiblioGenericDao<TabConsultation, String> 
                            implements IConsultationDao {
    
    private static final BaseLogger logger = BaseLogger.getLogger(ConsultationDaoImpl.class) ;

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