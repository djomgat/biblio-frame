/*

 */
package com.sample.biblio.svc.impl.courrier;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

import com.sample.frame.be.dao.generic.IGenericDao;
import com.sample.frame.be.interceptor.AuthorizationInterceptor;
import com.sample.frame.be.interceptor.LoggingInterceptor;
import com.sample.frame.be.interceptor.TransactionInterceptor;
import com.sample.frame.be.svc.generic.GenericSvcImpl;
import com.sample.frame.core.logging.BaseLogger;

import com.sample.biblio.model.courrier.TabCourrier;
import com.sample.biblio.dao.api.courrier.ICourrierDao;
import com.sample.biblio.svc.api.courrier.ICourrierSvcLocal;
import com.sample.biblio.svc.api.courrier.ICourrierSvcRemote;
import com.sample.frame.core.exception.GenericException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ECHOUPE
 * @date 9 mars 2015
 * 
 */

@Stateless(name = "CourrierSvc", mappedName = "CourrierSvc")
@TransactionManagement(TransactionManagementType.CONTAINER)
@Interceptors({TransactionInterceptor.class,
               LoggingInterceptor.class,
               AuthorizationInterceptor.class})

public class CourrierSvcImpl extends GenericSvcImpl<TabCourrier, String> 
                             implements ICourrierSvcLocal, ICourrierSvcRemote {

    private static  BaseLogger logger = BaseLogger.getLogger(CourrierSvcImpl.class) ;
    
    @Inject
    ICourrierDao dao;
	
    @Override
    protected IGenericDao<TabCourrier, String> getGenericDao() {		
	return dao;
    }

    @Override
    protected BaseLogger getLogger() {
	return logger;
    }    

    @Override
    public <T extends TabCourrier> T creer(T p$entite) throws GenericException {
        // déterminer la date-heure courante
        Timestamp dateCourante = new Timestamp( System.currentTimeMillis() );
        
        // generation du code du corrier
        String datestr = SimpleDateFormat.getInstance().format(new Date());
        
        p$entite.setNumeroCourrier(datestr);
        p$entite.setDateCreaCourrier(dateCourante);
        p$entite.setDateModCourrier(dateCourante); 
        return super.creer(p$entite);
    }   
    

}