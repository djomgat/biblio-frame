package com.sample.arquillian;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

import com.sample.biblio.entity.sample.Tabuser;
import com.sample.frame.be.dao.generic.IGenericDao;
import com.sample.frame.be.interceptor.AuthorizationInterceptor;
import com.sample.frame.be.interceptor.LoggingInterceptor;
import com.sample.frame.be.interceptor.TransactionInterceptor;
import com.sample.frame.be.svc.generic.GenericSvcImpl;
import com.sample.frame.core.logging.FrameBaseLogger;

@Stateless
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
