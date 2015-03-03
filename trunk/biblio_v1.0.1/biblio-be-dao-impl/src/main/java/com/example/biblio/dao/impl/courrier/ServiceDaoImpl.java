/*

 */
package com.example.biblio.dao.impl.courrier;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import com.sample.frame.be.interceptor.AuthorizationInterceptor;
import com.sample.frame.be.interceptor.LoggingInterceptor;
import com.sample.frame.core.logging.BaseLogger;

import com.sample.biblio.model.courrier.TabService;
import com.sample.biblio.dao.api.courrier.IServiceDao;
import com.sample.biblio.dao.impl.generic.BiblioGenericDao;

@Stateless
@Interceptors({LoggingInterceptor.class,AuthorizationInterceptor.class})
public class ServiceDaoImpl extends BiblioGenericDao<TabService, String> 
                            implements IServiceDao {
       
    private static final BaseLogger logger = BaseLogger.getLogger(ServiceDaoImpl.class) ;

    @Override
    protected Class<TabService> getEntityClass() {
	return TabService.class;
    }
	
    public ServiceDaoImpl() {
	
    }

    @Override
    protected BaseLogger getLogger() {		
	return logger;
    }

}