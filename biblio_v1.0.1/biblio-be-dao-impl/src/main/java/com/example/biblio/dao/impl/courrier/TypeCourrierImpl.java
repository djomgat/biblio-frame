/*

*/
package com.example.biblio.dao.impl.courrier;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import com.sample.frame.be.interceptor.AuthorizationInterceptor;
import com.sample.frame.be.interceptor.LoggingInterceptor;
import com.sample.frame.core.logging.BaseLogger;

import com.sample.biblio.model.courrier.TabTypeCourrier;
import com.sample.biblio.dao.api.courrier.ITypeCourrierDao;
import com.sample.biblio.dao.impl.generic.BiblioGenericDao;

@Stateless
//@Interceptors({LoggingInterceptor.class,AuthorizationInterceptor.class})
public class TypeCourrierImpl extends BiblioGenericDao<TabTypeCourrier, String> 
                              implements ITypeCourrierDao {
    
    private static final BaseLogger logger = BaseLogger.getLogger(TypeCourrierImpl.class) ;

    @Override
    protected Class<TabTypeCourrier> getEntityClass() {
	return TabTypeCourrier.class;
    }
	
    public TypeCourrierImpl() {
	
    }

    @Override
    protected BaseLogger getLogger() {		
	return logger;
    }

}

