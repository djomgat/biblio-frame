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

import com.sample.biblio.model.marche.TabContrat;
import com.sample.biblio.dao.api.marche.IContratDao;
import com.sample.biblio.svc.api.marche.IContratSvcLocal;
import com.sample.biblio.svc.api.marche.IContratSvcRemote;

/**
 *
 * @author ECHOUPE
 */

@Stateless(name = "ContratSvc", mappedName = "ContratSvc")
@TransactionManagement(TransactionManagementType.CONTAINER)
@Interceptors({TransactionInterceptor.class,
               LoggingInterceptor.class,
               AuthorizationInterceptor.class})

public class ContratSvcImpl extends GenericSvcImpl<TabContrat, String> implements
		      IContratSvcLocal, IContratSvcRemote {

    private static BaseLogger logger = BaseLogger.getLogger(ContratSvcImpl.class) ;
    
    @Inject
    IContratDao dao;
	
    @Override
    protected IGenericDao<TabContrat, String> getGenericDao() {		
	return dao;
    }

    @Override
    protected BaseLogger getLogger() {
	return logger;
    }

}