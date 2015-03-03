/*
 */
package com.sample.biblio.dao.impl.marche;

import javax.ejb.Stateless;
import com.sample.frame.core.logging.BaseLogger;

import com.sample.biblio.model.marche.TabMoa;
import com.sample.biblio.dao.api.marche.IMaitreOuvrageDao;
import com.sample.biblio.dao.impl.generic.BiblioGenericDao;

/**
 *
 * @author ECHOUPE
 */

@Stateless
//@Interceptors({LoggingInterceptor.class,AuthorizationInterceptor.class})
public class MaitreOuvrageDaoImpl extends BiblioGenericDao<TabMoa, String> 
                            implements IMaitreOuvrageDao {
       
    private static final BaseLogger logger = BaseLogger.getLogger(MaitreOuvrageDaoImpl.class) ;

    @Override
    protected Class<TabMoa> getEntityClass() {
	return TabMoa.class;
    }
	
    public MaitreOuvrageDaoImpl() {
        
    }

    @Override
    protected BaseLogger getLogger() {		
	return logger;
    }

}
