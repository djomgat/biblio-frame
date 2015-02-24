package com.sample.biblio.fe.core.crude.controller.securite;

import com.sample.frame.fe.controller.crude.BaseCrudeController;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sample.biblio.model.securite.Tabclass;
import com.sample.biblio.model.securite.Tabuser;
import com.sample.biblio.fe.core.crude.viewhelper.securite.ClassCrudeViewhelper;
import com.sample.biblio.fe.core.crude.viewhelper.securite.UserCrudeViewhelper;
import com.sample.biblio.fe.core.crude.wrapper.securite.ClassWrapper;
import com.sample.biblio.fe.core.crude.wrapper.securite.UserWrapper;
import com.sample.frame.core.svc.generic.IGenericSvc;

@ManagedBean
@SessionScoped
public class UserCrudeController extends BaseCrudeController<Tabuser, UserWrapper>{

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
