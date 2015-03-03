/*

 */
package com.example.biblio.dao.impl.courrier;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import com.sample.frame.be.interceptor.AuthorizationInterceptor;
import com.sample.frame.be.interceptor.LoggingInterceptor;
import com.sample.frame.core.logging.BaseLogger;

import com.sample.biblio.model.courrier.TabDestinataire;
import com.sample.biblio.dao.api.courrier.IDestinataireDao;
import com.sample.biblio.dao.impl.generic.BiblioGenericDao;

@Stateless
//@Interceptors({LoggingInterceptor.class,AuthorizationInterceptor.class})
public class DestinataireDaoImpl extends BiblioGenericDao<TabDestinataire, String> 
                                 implements IDestinataireDao {
       
    private static final BaseLogger logger = BaseLogger.getLogger(CourrierDaoImpl.class) ;

    @Override
    protected Class<TabDestinataire> getEntityClass() {
	return TabDestinataire.class;
    }
	
    public DestinataireDaoImpl() {
	
    }

    @Override
    protected BaseLogger getLogger() {		
	return logger;
    }

}