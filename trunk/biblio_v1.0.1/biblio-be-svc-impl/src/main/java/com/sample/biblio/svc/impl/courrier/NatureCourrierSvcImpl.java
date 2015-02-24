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

import com.sample.biblio.model.courrier.TabNatureCourrier;
import com.sample.biblio.dao.api.courrier.INatureCourrierDao;
import com.sample.biblio.svc.api.courrier.INatureCourrierSvcLocal;
import com.sample.biblio.svc.api.courrier.INatureCourrierSvcRemote;

/**
 *
 * @author ECHOUPE
 */
@Stateless(name = "NatureCourrierSvc", mappedName = "NatureCourrierSvc")
@TransactionManagement(TransactionManagementType.CONTAINER)
@Interceptors({TransactionInterceptor.class,
               LoggingInterceptor.class,
               AuthorizationInterceptor.class})

public class NatureCourrierSvcImpl extends GenericSvcImpl<TabNatureCourrier, String> implements
		      INatureCourrierSvcLocal, INatureCourrierSvcRemote {

    private static BaseLogger logger = BaseLogger.getLogger(NatureCourrierSvcImpl.class) ;
    
    @Inject
    INatureCourrierDao dao;
	
    @Override
    protected IGenericDao<TabNatureCourrier, String> getGenericDao() {		
	return dao;
    }

    @Override
    protected BaseLogger getLogger() {
	return logger;
    }

}