package com.sample.biblio.fe.core.crude.controller.securite;

import com.sample.frame.fe.controller.crude.BaseCrudeController;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sample.biblio.svc.api.securite.IClassSvc;
import com.sample.biblio.svc.api.securite.IClassSvcRemote;
import com.sample.biblio.model.securite.Tabclass;
import com.sample.biblio.fe.core.crude.viewhelper.securite.ClassCrudeViewhelper;
import com.sample.biblio.fe.core.crude.wrapper.securite.ClassWrapper;
import com.sample.biblio.fe.core.utils.BiblioServiceDelegate;
import com.sample.frame.core.svc.generic.IGenericSvc;
import com.sample.frame.core.utils.JndiHelper;
import com.sample.frame.fe.locator.SingleCachingServiceLocator;

@ManagedBean
@SessionScoped
public class ClassCrudeController extends
		BaseCrudeController<Tabclass, ClassWrapper> {

	IClassSvc classSvc;

	@Override
	public IGenericSvc<Tabclass, String> getCurrentSvc() {
		try {
			System.out
					.println("ClassCrudeController.getCurrentSvc() - Localisation du services");
			if (classSvc == null) {
				classSvc = BiblioServiceDelegate.getClassSvc();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out
				.println("ClassCrudeController.getCurrentSvc() - Est-ce-que mon service est localisé ? "
						+ !(classSvc == null));

		return classSvc;
	}

	public ClassCrudeController() {
		this.viewHelper = new ClassCrudeViewhelper();
	}

}