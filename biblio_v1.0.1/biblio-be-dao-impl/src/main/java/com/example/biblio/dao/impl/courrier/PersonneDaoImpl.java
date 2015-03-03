/*

 */
package com.example.biblio.dao.impl.courrier;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import com.sample.frame.be.interceptor.AuthorizationInterceptor;
import com.sample.frame.be.interceptor.LoggingInterceptor;
import com.sample.frame.core.logging.BaseLogger;

import com.sample.biblio.model.courrier.TabPersonne;
import com.sample.biblio.dao.api.courrier.IPersonneDao;
import com.sample.biblio.dao.impl.generic.BiblioGenericDao;

@Stateless
@Interceptors({LoggingInterceptor.class,AuthorizationInterceptor.class})
public class PersonneDaoImpl extends BiblioGenericDao<TabPersonne, String> 
                             implements IPersonneDao {
    
    private static final BaseLogger logger = BaseLogger.getLogger(PersonneDaoImpl.class) ;

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