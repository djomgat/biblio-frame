/*
 */
package com.sample.biblio.dao.impl.marche;

import javax.ejb.Stateless;
import com.sample.frame.core.logging.BaseLogger;

import com.sample.biblio.model.marche.TabModeSelection;
import com.sample.biblio.dao.api.marche.IModeSelectionDao;
import com.sample.biblio.dao.impl.generic.BiblioGenericDao;

/**
 *
 * @author ECHOUPE
 */

@Stateless
//@Interceptors({LoggingInterceptor.class,AuthorizationInterceptor.class})
public class ModeSelectionDaoImpl extends BiblioGenericDao<TabModeSelection, String> 
                            implements IModeSelectionDao {
       
    private static final BaseLogger logger = BaseLogger.getLogger(ModeSelectionDaoImpl.class) ;

    @Override
    protected Class<TabModeSelection> getEntityClass() {
	return TabModeSelection.class;
    }
	
    public ModeSelectionDaoImpl() {
        
    }

    @Override
    protected BaseLogger getLogger() {		
	return logger;
    }

}