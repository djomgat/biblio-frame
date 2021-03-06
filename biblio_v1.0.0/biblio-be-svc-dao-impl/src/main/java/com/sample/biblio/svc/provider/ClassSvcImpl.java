package com.sample.biblio.svc.provider;

import com.sample.biblio.svc.api.IClassSvcRemote;
import com.sample.biblio.svc.api.IClassSvcLocal;
import com.sample.biblio.dao.api.IUserDao;
import com.sample.biblio.dao.api.IClassDao;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

import com.sample.biblio.interceptor.BiblioExceptionInterceptor;
import com.sample.biblio.model.Tabclass;
import com.sample.biblio.model.Tabuser;
import com.sample.frame.be.dao.generic.IGenericDao;
import com.sample.frame.be.interceptor.AuthorizationInterceptor;
import com.sample.frame.be.interceptor.LoggingInterceptor;
import com.sample.frame.be.interceptor.TransactionInterceptor;
import com.sample.frame.be.svc.generic.GenericSvcImpl;
import com.sample.frame.core.exception.GenericDaoException;
import com.sample.frame.core.logging.BaseLogger;

@Stateless(name = "ClassSvc", mappedName = "ClassSvc")
@TransactionManagement(TransactionManagementType.CONTAINER)
@Interceptors({TransactionInterceptor.class,LoggingInterceptor.class,AuthorizationInterceptor.class,BiblioExceptionInterceptor.class})
public class ClassSvcImpl extends GenericSvcImpl<Tabclass, String> implements
		IClassSvcLocal, IClassSvcRemote {

	@Inject
	IClassDao classDao;
	
	@Inject
	IUserDao userDao;

	private static BaseLogger logger = BaseLogger.getLogger(ClassSvcImpl.class) ;
	
	@Override
	protected IGenericDao<Tabclass, String> getGenericDao() {		
		return classDao;
	}

	@Override
	public Tabclass creationPourTestRollbackTransac(Tabclass p$class, List<Tabuser> p$listUser) throws GenericDaoException {
		
		Tabclass v$class = classDao.create(p$class);
		for (Tabuser tabuser : p$listUser) {
			userDao.createNonAuthoriseTestRollbackTransac(tabuser);  // Cette opération doit roolback la transaction
		}
		return v$class;
	}
	
	@Override
	public Tabclass creationPourTestCommitTransac(Tabclass p$class, List<Tabuser> p$listUser) throws GenericDaoException {
		// Toute cette opération doit se derouler sans pb
		Tabclass v$class = classDao.create(p$class);
		for (Tabuser tabuser : p$listUser) {
			userDao.create(tabuser);
		}
		return v$class;
	}
	
	@Override
	public Tabclass creationPourTestExceptionInterceptor(Tabclass p$class, List<Tabuser> p$listUser) throws Exception {
		// à la sortie de cette exécution on doit avoir traité l'exception 
		// pour qu'elle retourne bien une exception de type BiblioDaoException
		// Traitement réalisé par l'intercepteur
		Tabclass v$class = classDao.create(p$class);
		for (Tabuser tabuser : p$listUser) {
			userDao.createNonAuthoriseForExceptionTest(tabuser);
		}
		return v$class;
	}
	
	@Override
	protected BaseLogger getLogger() {		
		return logger;
	}

}
