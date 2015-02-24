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

import com.sample.biblio.dao.api.marche.ISocieteDao;
import com.sample.biblio.model.marche.TabSociete;
import com.sample.biblio.svc.api.marche.ISocieteSvcLocal;
import com.sample.biblio.svc.api.marche.ISocieteSvcRemote;

/**
 *
 * @author ECHOUPE
 */

@Stateless(name = "SocieteSvc", mappedName = "SocieteSvc")
@TransactionManagement(TransactionManagementType.CONTAINER)
@Interceptors({TransactionInterceptor.class,
               LoggingInterceptor.class,
               AuthorizationInterceptor.class})

public class SocieteSvcImpl extends GenericSvcImpl<TabSociete, String> implements
		      ISocieteSvcLocal, ISocieteSvcRemote {

    private static BaseLogger logger = BaseLogger.getLogger(SocieteSvcImpl.class) ;
    
    @Inject
    ISocieteDao dao;
	
    @Override
    protected IGenericDao<TabSociete, String> getGenericDao() {		
	return dao;
    }

    @Override
    protected BaseLogger getLogger() {
	return logger;
    }

}