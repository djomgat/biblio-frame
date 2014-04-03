package com.sample.arquillian;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.sample.biblio.entity.sample.Tabuser;
import com.sample.frame.be.dao.generic.IGenericDao;
import com.sample.frame.be.svc.generic.GenericSvcImpl;

@Stateless
public class UserSvcImpl extends GenericSvcImpl<Tabuser, String> implements
		IUserSvcLocal, IUserSvcRemote {

	@Inject
	IUserDao dao;

	@Override
	protected IGenericDao<Tabuser, String> getGenericDao() {
		
		return dao;
	}

}
