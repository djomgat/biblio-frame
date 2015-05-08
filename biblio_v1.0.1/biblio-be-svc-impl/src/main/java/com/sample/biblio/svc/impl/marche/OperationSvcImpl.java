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

import com.sample.biblio.model.marche.TabOperation;
import com.sample.biblio.dao.api.marche.IOperationDao;
import com.sample.biblio.svc.api.marche.IOperationSvcLocal;
import com.sample.biblio.svc.api.marche.IOperationSvcRemote;

/**
 *
 * @author ECHOUPE
 */
@Stateless(name = "OperationSvc", mappedName = "OperationSvc")
@TransactionManagement(TransactionManagementType.CONTAINER)
@Interceptors({TransactionInterceptor.class,
               LoggingInterceptor.class,
               AuthorizationInterceptor.class})

public class OperationSvcImpl extends GenericSvcImpl<TabOperation, String> implements
		      IOperationSvcLocal, IOperationSvcRemote {

    private static BaseLogger logger = BaseLogger.getLogger(OperationSvcImpl.class) ;
    
    @Inject
    IOperationDao dao;
	
    @Override
    protected IGenericDao<TabOperation, String> getGenericDao() {		
	return dao;
    }

    @Override
    protected BaseLogger getLogger() {
	return logger;
    }

}