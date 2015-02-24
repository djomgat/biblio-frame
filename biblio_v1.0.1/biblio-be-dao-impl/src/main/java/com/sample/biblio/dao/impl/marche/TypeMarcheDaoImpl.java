/*
 */
package com.sample.biblio.dao.impl.marche;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;

import com.sample.frame.be.dao.generic.GenericDaoJpaImpl;
import com.sample.frame.be.interceptor.AuthorizationInterceptor;
import com.sample.frame.be.interceptor.LoggingInterceptor;
import com.sample.frame.core.logging.BaseLogger;

import com.sample.biblio.model.marche.TabTypeMarche;
import com.sample.biblio.dao.api.marche.ITypeMarcheDao;


/**
 *
 * @author ECHOUPE
 */

@Stateless
@Interceptors({LoggingInterceptor.class,AuthorizationInterceptor.class})
public class TypeMarcheDaoImpl extends GenericDaoJpaImpl<TabTypeMarche, String> 
                            implements ITypeMarcheDao {
    
    @Inject
    private EntityManager em;
       
    private static final BaseLogger logger = BaseLogger.getLogger(TypeMarcheDaoImpl.class) ;

    @Override
    protected EntityManager getEntityManager() {
	return em;
    }

    @Override
    protected Class<TabTypeMarche> getEntityClass() {
	return TabTypeMarche.class;
    }
	
    public TypeMarcheDaoImpl() {
        
    }

    @Override
    protected BaseLogger getLogger() {		
	return logger;
    }

}