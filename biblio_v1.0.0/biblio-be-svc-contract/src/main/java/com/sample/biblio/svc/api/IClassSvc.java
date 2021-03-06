package com.sample.biblio.svc.api;

import java.util.List;

import com.sample.biblio.model.Tabclass;
import com.sample.biblio.model.Tabuser;
import com.sample.frame.core.exception.GenericDaoException;
import com.sample.frame.core.svc.generic.IGenericSvc;


public interface IClassSvc extends IGenericSvc<Tabclass, String>{

    Tabclass creationPourTestRollbackTransac(Tabclass p$class,
			List<Tabuser> p$listUser) throws GenericDaoException;

    Tabclass creationPourTestCommitTransac(Tabclass p$class,
			List<Tabuser> p$listUser) throws GenericDaoException;

    Tabclass creationPourTestExceptionInterceptor(Tabclass p$class,
			List<Tabuser> p$listUser) throws GenericDaoException, Exception;
}