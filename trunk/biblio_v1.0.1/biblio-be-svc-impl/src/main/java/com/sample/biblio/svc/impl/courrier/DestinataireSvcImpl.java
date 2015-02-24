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

import com.sample.biblio.model.courrier.TabDestinataire;
import com.sample.biblio.dao.api.courrier.IDestinataireDao;
import com.sample.biblio.svc.api.courrier.IDestinataireSvcLocal;
import com.sample.biblio.svc.api.courrier.IDestinataireSvcRemote;

/**
 *
 * @author ECHOUPE
 */
@Stateless(name = "DestinataireSvc", mappedName = "DestinataireSvc")
@TransactionManagement(TransactionManagementType.CONTAINER)
@Interceptors({TransactionInterceptor.class,
               LoggingInterceptor.class,
               AuthorizationInterceptor.class})

public class DestinataireSvcImpl extends GenericSvcImpl<TabDestinataire, String> implements
		      IDestinataireSvcLocal, IDestinataireSvcRemote {

    private static BaseLogger logger = BaseLogger.getLogger(DestinataireSvcImpl.class) ;
    
    @Inject
    IDestinataireDao dao;
	
    @Override
    protected IGenericDao<TabDestinataire, String> getGenericDao() {		
	return dao;
    }

    @Override
    protected BaseLogger getLogger() {
	return logger;
    }

}
