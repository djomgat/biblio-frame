package com.sample.arquillian;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.sample.biblio.entity.sample.Tabclass;
import com.sample.biblio.entity.sample.Tabuser;
import com.sample.frame.be.dao.generic.IGenericDao;
import com.sample.frame.be.svc.generic.GenericSvcImpl;

@Stateless
public class ClassSvcImpl extends GenericSvcImpl<Tabclass, String> implements
		IClassSvcLocal, IClassSvcRemote {

	@Inject
	IClassDao dao;

	@Override
	protected IGenericDao<Tabclass, String> getGenericDao() {
		
		return dao;
	}

	@Override
	public Tabclass creationAvecTransaction(Tabclass p$class, List<Tabuser> p$listUser) {
		
		
		
		return null;
	}
	
	
	

}
