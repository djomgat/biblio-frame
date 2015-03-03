package com.sample.biblio.dao.impl.securite;

import javax.ejb.Stateless;
import com.sample.frame.core.logging.BaseLogger;

import com.sample.biblio.model.securite.Tabclass;
import com.sample.biblio.dao.api.securite.IClassDao;
import com.sample.biblio.dao.impl.generic.BiblioGenericDao;

@Stateless
//@Interceptors({LoggingInterceptor.class,AuthorizationInterceptor.class})
public class ClassDaoImpl extends BiblioGenericDao<Tabclass, String> implements IClassDao {
    
    private static final BaseLogger logger = BaseLogger.getLogger(ClassDaoImpl.class) ;

    @Override
    protected Class<Tabclass> getEntityClass() {
	return Tabclass.class;
    }
	
    public ClassDaoImpl() {
	
    }

    @Override
    protected BaseLogger getLogger() {		
	return logger;
    }

}