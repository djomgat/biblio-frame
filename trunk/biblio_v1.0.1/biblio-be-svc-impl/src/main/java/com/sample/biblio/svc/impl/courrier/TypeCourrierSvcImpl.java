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

import com.sample.biblio.model.courrier.TabTypeCourrier;
import com.sample.biblio.dao.api.courrier.ITypeCourrierDao;
import com.sample.biblio.svc.api.courrier.ITypeCourrierSvcLocal;
import com.sample.biblio.svc.api.courrier.ITypeCourrierSvcRemote;

/**
 *
 * @author ECHOUPE
 */
@Stateless(name = "TypeCourrierSvc", mappedName = "TypeCourrierSvc")
@TransactionManagement(TransactionManagementType.CONTAINER)
@Interceptors({TransactionInterceptor.class,
               LoggingInterceptor.class,
               AuthorizationInterceptor.class})

public class TypeCourrierSvcImpl extends GenericSvcImpl<TabTypeCourrier, String> implements
		      ITypeCourrierSvcLocal, ITypeCourrierSvcRemote {

    private static BaseLogger logger = BaseLogger.getLogger(TypeCourrierSvcImpl.class) ;
    
    @Inject
    ITypeCourrierDao dao;
	
    @Override
    protected IGenericDao<TabTypeCourrier, String> getGenericDao() {		
	return dao;
    }

    @Override
    protected BaseLogger getLogger() {
	return logger;
    }

}