/*
 */
package com.sample.biblio.dao.impl.marche;

import javax.ejb.Stateless;
import com.sample.frame.core.logging.BaseLogger;

import com.sample.biblio.model.marche.TabSociete;
import com.sample.biblio.dao.api.marche.ISocieteDao;
import com.sample.biblio.dao.impl.generic.BiblioGenericDao;

/**
 *
 * @author ECHOUPE
 */

@Stateless
//@Interceptors({LoggingInterceptor.class,AuthorizationInterceptor.class})
public class SocieteDaoImpl extends BiblioGenericDao<TabSociete, String> 
                            implements ISocieteDao {
       
    private static final BaseLogger logger = BaseLogger.getLogger(SocieteDaoImpl.class) ;

    @Override
    protected Class<TabSociete> getEntityClass() {
	return TabSociete.class;
    }
	
    public SocieteDaoImpl() {
        
    }

    @Override
    protected BaseLogger getLogger() {		
	return logger;
    }

}