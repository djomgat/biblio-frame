package com.sample.biblio.svc.impl.securite;

import com.sample.biblio.svc.api.securite.IUserSvcLocal;
import com.sample.biblio.svc.api.securite.IUserSvcRemote;
import com.sample.biblio.dao.api.securite.IUserDao;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

import com.sample.biblio.model.securite.Tabuser;
import com.sample.frame.be.dao.generic.IGenericDao;
import com.sample.frame.be.interceptor.AuthorizationInterceptor;
import com.sample.frame.be.interceptor.LoggingInterceptor;
import com.sample.frame.be.interceptor.TransactionInterceptor;
import com.sample.frame.be.svc.generic.GenericSvcImpl;
import com.sample.frame.core.logging.BaseLogger;

@Stateless(name = "UserSvc", mappedName = "UserSvc")
@TransactionManagement(TransactionManagementType.CONTAINER)
@Interceptors({TransactionInterceptor.class,
               LoggingInterceptor.class,
               AuthorizationInterceptor.class})

public class UserSvcImpl extends GenericSvcImpl<Tabuser, String> implements
		IUserSvcLocal, IUserSvcRemote {

    private static BaseLogger logger = BaseLogger.getLogger(UserSvcImpl.class) ;
    
    @Inject
    IUserDao dao;
	
    @Override
    protected IGenericDao<Tabuser, String> getGenericDao() {		
	return dao;
    }

    @Override
    protected BaseLogger getLogger() {
	return logger;
    }

}