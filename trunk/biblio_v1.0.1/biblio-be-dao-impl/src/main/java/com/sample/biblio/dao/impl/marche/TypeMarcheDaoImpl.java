/*
 */
package com.sample.biblio.dao.impl.marche;

import javax.ejb.Stateless;
import com.sample.frame.core.logging.BaseLogger;

import com.sample.biblio.model.marche.TabTypeMarche;
import com.sample.biblio.dao.api.marche.ITypeMarcheDao;
import com.sample.biblio.dao.impl.generic.BiblioGenericDao;


/**
 *
 * @author ECHOUPE
 */

@Stateless
//@Interceptors({LoggingInterceptor.class,AuthorizationInterceptor.class})
public class TypeMarcheDaoImpl extends BiblioGenericDao<TabTypeMarche, String> 
                            implements ITypeMarcheDao {
       
    private static final BaseLogger logger = BaseLogger.getLogger(TypeMarcheDaoImpl.class) ;

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