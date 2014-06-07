package com.sample.biblio.be.impl;

import com.sample.biblio.be.svc.contract.IUserSvcLocal;
import com.sample.biblio.be.svc.contract.IUserSvcRemote;
import com.sample.biblio.be.dao.contract.IUserDao;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

import com.sample.biblio.entity.Tabuser;
import com.sample.frame.be.dao.generic.IGenericDao;
import com.sample.frame.be.interceptor.AuthorizationInterceptor;
import com.sample.frame.be.interceptor.LoggingInterceptor;
import com.sample.frame.be.interceptor.TransactionInterceptor;
import com.sample.frame.be.svc.generic.GenericSvcImpl;
import com.sample.frame.core.logging.FrameBaseLogger;

@Stateless(name = "UserSvc", mappedName = "UserSvc")
@TransactionManagement(TransactionManagementType.CONTAINER)
@Interceptors({TransactionInterceptor.class,LoggingInterceptor.class,AuthorizationInterceptor.class})
public class UserSvcImpl extends GenericSvcImpl<Tabuser, String> implements
		IUserSvcLocal, IUserSvcRemote {

	@Inject
	IUserDao dao;
	
	private static FrameBaseLogger logger = FrameBaseLogger.getLogger(UserSvcImpl.class) ;

	@Override
	protected IGenericDao<Tabuser, String> getGenericDao() {		
		return dao;
	}

	@Override
	protected FrameBaseLogger getLogger() {
	
		return logger;
	}

}
