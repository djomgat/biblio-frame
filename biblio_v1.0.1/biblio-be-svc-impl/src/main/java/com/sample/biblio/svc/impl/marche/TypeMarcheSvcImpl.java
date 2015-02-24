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

import com.sample.biblio.dao.api.marche.ITypeMarcheDao;
import com.sample.biblio.model.marche.TabTypeMarche;
import com.sample.biblio.svc.api.marche.ITypeMarcheSvcLocal;
import com.sample.biblio.svc.api.marche.ITypeMarcheSvcRemote;

/**
 *
 * @author ECHOUPE
 */

@Stateless(name = "TypeMarcheSvc", mappedName = "TypeMarcheSvc")
@TransactionManagement(TransactionManagementType.CONTAINER)
@Interceptors({TransactionInterceptor.class,
               LoggingInterceptor.class,
               AuthorizationInterceptor.class})

public class TypeMarcheSvcImpl extends GenericSvcImpl<TabTypeMarche, String> implements
		      ITypeMarcheSvcLocal, ITypeMarcheSvcRemote {

    private static BaseLogger logger = BaseLogger.getLogger(TypeMarcheSvcImpl.class) ;
    
    @Inject
    ITypeMarcheDao dao;
	
    @Override
    protected IGenericDao<TabTypeMarche, String> getGenericDao() {		
	return dao;
    }

    @Override
    protected BaseLogger getLogger() {
	return logger;
    }

}