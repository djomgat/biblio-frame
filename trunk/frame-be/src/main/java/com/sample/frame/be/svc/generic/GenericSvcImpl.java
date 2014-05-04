package com.sample.frame.be.svc.generic;

import java.io.Serializable;
import java.util.List;

import com.sample.frame.be.dao.generic.IGenericDao;
import com.sample.frame.core.entity.GenericEntity;
import com.sample.frame.core.exception.GenericException;
import com.sample.frame.core.logging.FrameBaseLogger;
import com.sample.frame.core.svc.generic.IGenericSvc;


//@TransactionManagement(TransactionManagementType.CONTAINER)
//@Interceptors({ TransactionInterceptor.class })
public abstract class GenericSvcImpl<U extends GenericEntity, PK extends Serializable>
		implements IGenericSvc<U, PK> {

	protected abstract IGenericDao<U, PK> getGenericDao();
	
	protected abstract FrameBaseLogger getLogger();

	@Override
	public <T extends U> T creer(T p$entite) throws GenericException {
		return getGenericDao().create(p$entite);
	}

	@Override
	public <T extends U>T modifier(T p$entite) throws GenericException {
		return getGenericDao().update(p$entite);
	}

	@Override
	public <T extends U> void supprimer(T p$entite) throws GenericException {
		getGenericDao().delete(p$entite);
	}

	@Override
	public <T extends U>T rechercher(PK p$valeur) throws GenericException {
		return getGenericDao().retrieve(p$valeur);
	}

	@Override
	public <T extends U>List<T> rechercherParCritere(final T p$critere)
			throws GenericException {
		return getGenericDao().findByExample(p$critere);
	}

	@Override
	public <T extends U>List<T> rechercherTout() throws GenericException {
		return getGenericDao().findAll();
	}

}