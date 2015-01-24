package com.sample.biblio.fe.core.crude.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sample.biblio.entity.Tabclass;
import com.sample.biblio.entity.Tabuser;
import com.sample.biblio.fe.core.crude.viewhelper.ClassCrudeViewhelper;
import com.sample.biblio.fe.core.crude.viewhelper.UserCrudeViewhelper;
import com.sample.biblio.fe.core.crude.wrapper.ClasseWrapper;
import com.sample.biblio.fe.core.crude.wrapper.UserWrapper;
import com.sample.frame.core.svc.generic.IGenericSvc;

@ManagedBean
@SessionScoped
public class UserCrudeController extends BiblioBaseCrudeController<Tabuser, UserWrapper>{

	@Override
	public IGenericSvc<Tabuser, String> getCurrentSvc() {
		// TODO Auto-generated method stub
		return null;
	}

	public UserCrudeController() {
		super();
		
		UserWrapper wrapp = new UserWrapper(new Tabuser());
		this.setViewHelper(new UserCrudeViewhelper(wrapp));
	}
	
}
