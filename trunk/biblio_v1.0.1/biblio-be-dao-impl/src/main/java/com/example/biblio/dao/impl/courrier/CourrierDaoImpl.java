/*

 */
package com.example.biblio.dao.impl.courrier;

import javax.ejb.Stateless;
import com.sample.frame.core.logging.BaseLogger;

import com.sample.biblio.model.courrier.TabCourrier;
import com.sample.biblio.dao.api.courrier.ICourrierDao;
import com.sample.biblio.dao.impl.generic.BiblioGenericDao;

@Stateless
public class CourrierDaoImpl extends BiblioGenericDao<TabCourrier, String> implements ICourrierDao {
       
    private static final BaseLogger logger = BaseLogger.getLogger(CourrierDaoImpl.class) ;

    @Override
    protected Class<TabCourrier> getEntityClass() {
	return TabCourrier.class;
    }
	
    public CourrierDaoImpl() {
	
    }

    @Override
    protected BaseLogger getLogger() {		
	return logger;
    }

}