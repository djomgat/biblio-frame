package com.sample.biblio.dao.impl.securite;

import javax.ejb.Stateless;
import com.sample.frame.core.logging.BaseLogger;

import com.sample.biblio.model.securite.TabMouchard;
import com.sample.biblio.dao.api.securite.IMouchardDao;
import com.sample.biblio.dao.impl.generic.BiblioGenericDao;

/**
 *
 * @author ECHOUPE
 */
@Stateless
//@Interceptors({LoggingInterceptor.class,AuthorizationInterceptor.class})
public class MouchardDaoImpl extends BiblioGenericDao<TabMouchard, String> implements IMouchardDao {
       
    private static final BaseLogger logger = BaseLogger.getLogger(MouchardDaoImpl.class) ;

    @Override
    protected Class<TabMouchard> getEntityClass() {
	return TabMouchard.class;
    }
	
    public MouchardDaoImpl() {
	
    }

    @Override
    protected BaseLogger getLogger() {		
	return logger;
    }

}