/*

 */
package com.example.biblio.dao.impl.courrier;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;

import com.sample.frame.be.dao.generic.GenericDaoJpaImpl;
import com.sample.frame.be.interceptor.AuthorizationInterceptor;
import com.sample.frame.be.interceptor.LoggingInterceptor;
import com.sample.frame.core.logging.BaseLogger;

import com.sample.biblio.model.courrier.TabPersonne;
import com.sample.biblio.dao.api.courrier.IPersonneDao;

@Stateless
@Interceptors({LoggingInterceptor.class,AuthorizationInterceptor.class})
public class PersonneDaoImpl extends GenericDaoJpaImpl<TabPersonne, String> implements IPersonneDao {
    
    @Inject
    private EntityManager em;
       
    private static final BaseLogger logger = BaseLogger.getLogger(CourrierDaoImpl.class) ;

    @Override
    protected EntityManager getEntityManager() {
	return em;
    }

    @Override
    protected Class<TabPersonne> getEntityClass() {
	return TabPersonne.class;
    }
	
    public PersonneDaoImpl() {
	
    }

    @Override
    protected BaseLogger getLogger() {		
	return logger;
    }

}