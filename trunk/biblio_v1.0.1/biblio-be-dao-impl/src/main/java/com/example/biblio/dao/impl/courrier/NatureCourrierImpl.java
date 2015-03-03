/*

 */
package com.example.biblio.dao.impl.courrier;

import javax.ejb.Stateless;

import com.sample.frame.core.logging.BaseLogger;
import com.sample.biblio.model.courrier.TabNatureCourrier;
import com.sample.biblio.dao.api.courrier.INatureCourrierDao;
import com.sample.biblio.dao.impl.generic.BiblioGenericDao;

@Stateless
//@Interceptors({LoggingInterceptor.class,AuthorizationInterceptor.class})
public class NatureCourrierImpl extends BiblioGenericDao<TabNatureCourrier, String> 
                                implements INatureCourrierDao {
       
    private static final BaseLogger logger = BaseLogger.getLogger(CourrierDaoImpl.class) ;

    @Override
    protected Class<TabNatureCourrier> getEntityClass() {
	return TabNatureCourrier.class;
    }
	
    public NatureCourrierImpl() {
	
    }

    @Override
    protected BaseLogger getLogger() {		
	return logger;
    }

}