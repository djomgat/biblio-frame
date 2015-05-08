/*
 */
package com.sample.biblio.dao.impl.marche;

import javax.ejb.Stateless;
import com.sample.frame.core.logging.BaseLogger;

import com.sample.biblio.model.marche.TabOperation;
import com.sample.biblio.dao.api.marche.IOperationDao;
import com.sample.biblio.dao.impl.generic.BiblioGenericDao;

/**
 *
 * @author ECHOUPE
 */

@Stateless
//@Interceptors({LoggingInterceptor.class,AuthorizationInterceptor.class})
public class OperationDaoImpl extends BiblioGenericDao<TabOperation, String> 
                            implements IOperationDao {
       
    private static final BaseLogger logger = BaseLogger.getLogger(OperationDaoImpl.class) ;

    @Override
    protected Class<TabOperation> getEntityClass() {
	return TabOperation.class;
    }
	
    public OperationDaoImpl() {
        
    }

    @Override
    protected BaseLogger getLogger() {		
	return logger;
    }

}