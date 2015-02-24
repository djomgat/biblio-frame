/*

 */
package com.sample.biblio.svc.impl.securite;

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

import com.sample.biblio.model.securite.TabMouchard;
import com.sample.biblio.dao.api.securite.IMouchardDao;
import com.sample.biblio.svc.api.securite.IMouchardSvcLocal;
import com.sample.biblio.svc.api.securite.IMouchardSvcRemote;

@Stateless(name = "MouchardSvc", mappedName = "MouchardSvc")
@TransactionManagement(TransactionManagementType.CONTAINER)
@Interceptors({TransactionInterceptor.class,
               LoggingInterceptor.class,
               AuthorizationInterceptor.class})

public class MouchardSvcImpl extends GenericSvcImpl<TabMouchard, String> implements
		IMouchardSvcLocal, IMouchardSvcRemote {

    private static BaseLogger logger = BaseLogger.getLogger(MouchardSvcImpl.class) ;
    
    @Inject
    IMouchardDao dao;
	
    @Override
    protected IGenericDao<TabMouchard, String> getGenericDao() {		
	return dao;
    }

    @Override
    protected BaseLogger getLogger() {
	return logger;
    }

}