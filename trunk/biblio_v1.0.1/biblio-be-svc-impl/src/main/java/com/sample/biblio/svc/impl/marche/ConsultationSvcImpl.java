/*
 */
package com.sample.biblio.svc.impl.marche;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

import com.sample.frame.be.dao.generic.IGenericDao;
import com.sample.frame.be.interceptor.AuthorizationInterceptor;
import com.sample.frame.be.interceptor.LoggingInterceptor;
import com.sample.frame.be.interceptor.TransactionInterceptor;
import com.sample.frame.be.svc.generic.GenericSvcImpl;
import com.sample.frame.core.logging.BaseLogger;

import com.sample.biblio.model.marche.TabConsultation;
import com.sample.biblio.dao.api.marche.IConsultationDao;
import com.sample.biblio.svc.api.marche.IConsultationSvcLocal;
import com.sample.biblio.svc.api.marche.IConsultationSvcRemote;

/**
 *
 * @author ECHOUPE
 */

@Stateless(name = "ConsultationSvc", mappedName = "ConsultationSvc")
@TransactionManagement(TransactionManagementType.CONTAINER)
@Interceptors({TransactionInterceptor.class,
               LoggingInterceptor.class,
               AuthorizationInterceptor.class})

public class ConsultationSvcImpl extends GenericSvcImpl<TabConsultation, String> implements
		      IConsultationSvcLocal, IConsultationSvcRemote {

    private static BaseLogger logger = BaseLogger.getLogger(ConsultationSvcImpl.class) ;
    
    @Inject
    IConsultationDao dao;
	
    @Override
    protected IGenericDao<TabConsultation, String> getGenericDao() {		
	return dao;
    }

    @Override
    protected BaseLogger getLogger() {
	return logger;
    }

}
