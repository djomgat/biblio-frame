/*

 */
package com.example.biblio.dao.impl.courrier;

import javax.ejb.Stateless;
import com.sample.frame.core.logging.BaseLogger;

import com.sample.biblio.model.courrier.TabCompteurCourrier;
import com.sample.biblio.dao.api.courrier.ICompteurCourrierDao;
import com.sample.biblio.dao.impl.generic.BiblioGenericDao;

@Stateless
public class CompteurCourrierDaoImpl extends BiblioGenericDao<TabCompteurCourrier, String> 
                                     implements ICompteurCourrierDao {
       
    private static final BaseLogger logger = BaseLogger.getLogger(CompteurCourrierDaoImpl.class) ;

    @Override
    protected Class<TabCompteurCourrier> getEntityClass() {
	return TabCompteurCourrier.class;
    }
	
    public CompteurCourrierDaoImpl() {
	
    }

    @Override
    protected BaseLogger getLogger() {		
	return logger;
    }

}