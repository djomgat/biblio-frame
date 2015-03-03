/*
 */
package com.sample.biblio.dao.impl.marche;

import com.sample.biblio.dao.impl.securite.ClassDaoImpl;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import com.sample.frame.be.interceptor.AuthorizationInterceptor;
import com.sample.frame.be.interceptor.LoggingInterceptor;
import com.sample.frame.core.logging.BaseLogger;

import com.sample.biblio.model.marche.TabContrat;
import com.sample.biblio.dao.api.marche.IContratDao;
import com.sample.biblio.dao.impl.generic.BiblioGenericDao;

/**
 *
 * @author ECHOUPE
 */

@Stateless
@Interceptors({LoggingInterceptor.class,AuthorizationInterceptor.class})
public class ContratDaoImpl extends BiblioGenericDao<TabContrat, String> 
                            implements IContratDao {
       
    private static final BaseLogger logger = BaseLogger.getLogger(ClassDaoImpl.class) ;

    @Override
    protected Class<TabContrat> getEntityClass() {
	return TabContrat.class;
    }
	
    public ContratDaoImpl() {
        
    }

    @Override
    protected BaseLogger getLogger() {		
	return logger;
    }

}