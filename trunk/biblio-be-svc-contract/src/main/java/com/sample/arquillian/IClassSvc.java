package com.sample.arquillian;

import java.util.List;

import com.sample.biblio.entity.sample.Tabclass;
import com.sample.biblio.entity.sample.Tabuser;
import com.sample.frame.core.svc.generic.IGenericSvc;


public interface IClassSvc extends IGenericSvc<Tabclass, String>{

	Tabclass creationAvecTransaction(Tabclass p$class , List<Tabuser> p$listUser);
}
