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

import com.sample.biblio.model.marche.TabMoa;
import com.sample.biblio.dao.api.marche.IMaitreOuvrageDao;
import com.sample.biblio.svc.api.marche.IMaitreOuvrageSvcLocal;
import com.sample.biblio.svc.api.marche.IMaitreOuvrageSvcRemote;

/**
 *
 * @author ECHOUPE
 */

@Stateless(name = "MaitreOuvrageSvc", mappedName = "MaitreOuvrageSvc")
@TransactionManagement(TransactionManagementType.CONTAINER)
@Interceptors({TransactionInterceptor.class,
               LoggingInterceptor.class,
               AuthorizationInterceptor.class})

public class MaitreOuvrageSvcImpl extends GenericSvcImpl<TabMoa, String> implements
		      IMaitreOuvrageSvcLocal, IMaitreOuvrageSvcRemote {

    private static BaseLogger logger = BaseLogger.getLogger(MaitreOuvrageSvcImpl.class) ;
    
    @Inject
    IMaitreOuvrageDao dao;
	
    @Override
    protected IGenericDao<TabMoa, String> getGenericDao() {		
	return dao;
    }

    @Override
    protected BaseLogger getLogger() {
	return logger;
    }

}