/*

 */
package com.sample.biblio.svc.impl.courrier;

import com.sample.biblio.dao.api.courrier.ICompteurCourrierDao;
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
import com.sample.frame.core.exception.GenericException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sample.biblio.model.courrier.TabCourrier;
import com.sample.biblio.model.courrier.TabCompteurCourrier;
import com.sample.biblio.svc.api.courrier.ICompteurCourrierSvcLocal;
import com.sample.biblio.svc.api.courrier.ICompteurCourrierSvcRemote;
/**
 *
 * @author ECHOUPE
 */
@Stateless(name = "CompteurCourrierSvc", mappedName = "CompteurCourrierSvc")
@TransactionManagement(TransactionManagementType.CONTAINER)
@Interceptors({TransactionInterceptor.class,
               LoggingInterceptor.class,
               AuthorizationInterceptor.class})

public class CompteurCourrierSvcImpl extends GenericSvcImpl<TabCompteurCourrier, String> 
                implements ICompteurCourrierSvcLocal, ICompteurCourrierSvcRemote {

    private static BaseLogger logger = BaseLogger.getLogger(CompteurCourrierSvcImpl.class) ;
    
    @Inject
    ICompteurCourrierDao dao;
	
    @Override
    protected IGenericDao<TabCompteurCourrier, String> getGenericDao() {		
	return dao;
    }

    @Override
    protected BaseLogger getLogger() {
	return logger;
    }    

    @Override
    public <T extends TabCompteurCourrier> T creer(T p$entite) throws GenericException {
//        generation du code du corrier
//        Extraire annee de la date courante sur le serveur;
//        Extraire code_service de l utilisateur courant
//        Extraire code type courrier 
//        Extraire code nature courrier
//        Extraire_numero_db (annee, code_service, code_type_courrier, code nature courrier)
//        Faire numero_courant = numero_courant + 1
//        Retourner le numéro généré à la classe appelante
        
        String datestr = SimpleDateFormat.getInstance().format(new Date());
        //p$entite.setNumeroCourrier(datestr);
        //p$entite.setMotsCles("Mots clés");
        return super.creer(p$entite);
    }   

}