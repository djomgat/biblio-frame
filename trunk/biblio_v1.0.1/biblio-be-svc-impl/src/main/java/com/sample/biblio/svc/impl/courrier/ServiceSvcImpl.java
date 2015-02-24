/*

 */
package com.sample.biblio.svc.impl.courrier;

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

import com.sample.biblio.model.courrier.TabService;
import com.sample.biblio.dao.api.courrier.IServiceDao;
import com.sample.biblio.svc.api.courrier.IServiceSvcLocal;
import com.sample.biblio.svc.api.courrier.IServiceSvcRemote;

/**
 *
 * @author ECHOUPE
 */
@Stateless(name = "ServiceSvc", mappedName = "ServiceSvc")
@TransactionManagement(TransactionManagementType.CONTAINER)
@Interceptors({TransactionInterceptor.class,
               LoggingInterceptor.class,
               AuthorizationInterceptor.class})

public class ServiceSvcImpl extends GenericSvcImpl<TabService, String> implements
		      IServiceSvcLocal, IServiceSvcRemote {

    private static BaseLogger logger = BaseLogger.getLogger(ServiceSvcImpl.class) ;
    
    @Inject
    IServiceDao dao;
	
    @Override
    protected IGenericDao<TabService, String> getGenericDao() {		
	return dao;
    }

    @Override
    protected BaseLogger getLogger() {
	return logger;
    }

}