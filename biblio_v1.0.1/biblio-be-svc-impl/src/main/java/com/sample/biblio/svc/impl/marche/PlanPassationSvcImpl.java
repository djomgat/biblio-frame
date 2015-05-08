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

import com.sample.biblio.model.marche.TabPlanPassation;
import com.sample.biblio.dao.api.marche.IPlanPassationDao;
import com.sample.biblio.svc.api.marche.IPlanPassationSvcLocal;
import com.sample.biblio.svc.api.marche.IPlanPassationSvcRemote;

/**
 *
 * @author ECHOUPE
 */
@Stateless(name = "PlanPassationSvc", mappedName = "PlanPassationSvc")
@TransactionManagement(TransactionManagementType.CONTAINER)
@Interceptors({TransactionInterceptor.class,
               LoggingInterceptor.class,
               AuthorizationInterceptor.class})

public class PlanPassationSvcImpl extends GenericSvcImpl<TabPlanPassation, String> implements
		      IPlanPassationSvcLocal, IPlanPassationSvcRemote {

    private static BaseLogger logger = BaseLogger.getLogger(PlanPassationSvcImpl.class) ;
    
    @Inject
    IPlanPassationDao dao;
	
    @Override
    protected IGenericDao<TabPlanPassation, String> getGenericDao() {		
	return dao;
    }

    @Override
    protected BaseLogger getLogger() {
	return logger;
    }

}