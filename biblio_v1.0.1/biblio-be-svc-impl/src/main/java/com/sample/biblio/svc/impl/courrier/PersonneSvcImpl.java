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

import com.sample.biblio.model.courrier.TabPersonne;
import com.sample.biblio.dao.api.courrier.IPersonneDao;
import com.sample.biblio.svc.api.courrier.IPersonneSvcLocal;
import com.sample.biblio.svc.api.courrier.IPersonneSvcRemote;

/**
 *
 * @author ECHOUPE
 */
@Stateless(name = "PersonneSvc", mappedName = "PersonneSvc")
@TransactionManagement(TransactionManagementType.CONTAINER)
@Interceptors({TransactionInterceptor.class,
               LoggingInterceptor.class,
               AuthorizationInterceptor.class})

public class PersonneSvcImpl extends GenericSvcImpl<TabPersonne, String> implements
		      IPersonneSvcLocal, IPersonneSvcRemote {

    private static BaseLogger logger = BaseLogger.getLogger(PersonneSvcImpl.class) ;
    
    @Inject
    IPersonneDao dao;
	
    @Override
    protected IGenericDao<TabPersonne, String> getGenericDao() {		
	return dao;
    }

    @Override
    protected BaseLogger getLogger() {
	return logger;
    }

}