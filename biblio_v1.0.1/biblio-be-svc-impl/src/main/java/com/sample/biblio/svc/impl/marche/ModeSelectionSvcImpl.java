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

import com.sample.biblio.model.marche.TabModeSelection;
import com.sample.biblio.dao.api.marche.IModeSelectionDao;
import com.sample.biblio.svc.api.marche.IModeSelectionSvcLocal;
import com.sample.biblio.svc.api.marche.IModeSelectionSvcRemote;

/**
 *
 * @author ECHOUPE
 */
@Stateless(name = "ModeSelectionSvc", mappedName = "ModeSelectionSvc")
@TransactionManagement(TransactionManagementType.CONTAINER)
@Interceptors({TransactionInterceptor.class,
               LoggingInterceptor.class,
               AuthorizationInterceptor.class})

public class ModeSelectionSvcImpl extends GenericSvcImpl<TabModeSelection, String> implements
		      IModeSelectionSvcLocal, IModeSelectionSvcRemote {

    private static BaseLogger logger = BaseLogger.getLogger(ModeSelectionSvcImpl.class) ;
    
    @Inject
    IModeSelectionDao dao;
	
    @Override
    protected IGenericDao<TabModeSelection, String> getGenericDao() {		
	return dao;
    }

    @Override
    protected BaseLogger getLogger() {
	return logger;
    }

}