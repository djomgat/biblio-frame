/*

 */
package com.example.biblio.dao.impl.courrier;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import com.sample.frame.be.interceptor.AuthorizationInterceptor;
import com.sample.frame.be.interceptor.LoggingInterceptor;
import com.sample.frame.core.logging.BaseLogger;

import com.sample.biblio.model.courrier.TabPieceJointe;
import com.sample.biblio.dao.api.courrier.IPieceJointeDao;
import com.sample.biblio.dao.impl.generic.BiblioGenericDao;

@Stateless
@Interceptors({LoggingInterceptor.class,AuthorizationInterceptor.class})
public class PieceJointeDaoImpl extends BiblioGenericDao<TabPieceJointe, String> 
                                implements IPieceJointeDao {
       
    private static final BaseLogger logger = BaseLogger.getLogger(PieceJointeDaoImpl.class) ;

    @Override
    protected Class<TabPieceJointe> getEntityClass() {
	return TabPieceJointe.class;
    }
	
    public PieceJointeDaoImpl() {
	
    }

    @Override
    protected BaseLogger getLogger() {		
	return logger;
    }

}