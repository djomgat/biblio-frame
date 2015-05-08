/*
 */
package com.sample.biblio.dao.impl.marche;

import javax.ejb.Stateless;
import com.sample.frame.core.logging.BaseLogger;

import com.sample.biblio.model.marche.TabPlanPassation;
import com.sample.biblio.dao.api.marche.IPlanPassationDao;
import com.sample.biblio.dao.impl.generic.BiblioGenericDao;

/**
 *
 * @author ECHOUPE
 */

@Stateless
//@Interceptors({LoggingInterceptor.class,AuthorizationInterceptor.class})
public class PlanPassationDaoImpl extends BiblioGenericDao<TabPlanPassation, String> 
                                  implements IPlanPassationDao {
    
    private static final BaseLogger logger = BaseLogger.getLogger(PlanPassationDaoImpl.class) ;

    @Override
    protected Class<TabPlanPassation> getEntityClass() {
	return TabPlanPassation.class;
    }
	
    public PlanPassationDaoImpl() {
        
    }

    @Override
    protected BaseLogger getLogger() {		
	return logger;
    }

}