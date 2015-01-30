package com.sample.biblio.fe.core.crude.controller;

//import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.sample.biblio.svc.api.IClassSvc;
import com.sample.biblio.svc.api.IClassSvcRemote;
import com.sample.biblio.model.Tabclass;
import com.sample.biblio.fe.core.crude.viewhelper.ClassCrudeViewhelper;
import com.sample.biblio.fe.core.crude.wrapper.ClasseWrapper;
import com.sample.frame.core.svc.generic.IGenericSvc;
import com.sample.frame.core.utils.JndiHelper;
//import com.sample.frame.fe.exception.ServiceLocatorException;
import com.sample.frame.fe.locator.SingleCachingServiceLocator;

@ManagedBean
@SessionScoped
public class ClassCrudeController extends BiblioBaseCrudeController<Tabclass, ClasseWrapper>{

	
	IClassSvc classSvc;  
	
	@Override
	public IGenericSvc<Tabclass, String> getCurrentSvc() {
		try{
			System.out.println("ClassCrudeController.getCurrentSvc() - Localisation du services");
			if(classSvc == null) {
				String ejbPath = JndiHelper.lookupRemoteStatelessName("biblio-z-ear", "biblio-be-svc-dao-impl", "", "ClassSvc", IClassSvcRemote.class);
				classSvc = (IClassSvc) SingleCachingServiceLocator.getInstance().lookup(ejbPath);
			System.out.println("ClassCrudeController.getCurrentSvc() - localisation avec succes a priori");
			classSvc.rechercherTout();
			return classSvc;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("ClassCrudeController.getCurrentSvc() - Est ce que mon service est localisé ? " + !(classSvc==null));
		
		return classSvc;
	}

	public ClassCrudeController() {
		//super();
		
		this.viewHelper = new ClassCrudeViewhelper();		
		
	}
	
}
