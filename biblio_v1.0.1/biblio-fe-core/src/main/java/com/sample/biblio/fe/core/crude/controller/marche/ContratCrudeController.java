/*

 */
package com.sample.biblio.fe.core.crude.controller.marche;

import com.sample.frame.fe.controller.crude.BaseCrudeController;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.sample.biblio.model.marche.TabContrat;
import com.sample.frame.core.svc.generic.IGenericSvc;
import com.sample.biblio.svc.api.marche.IContratSvc;
import com.sample.biblio.svc.api.marche.IContratSvcRemote;
import com.sample.biblio.fe.core.crude.wrapper.marche.ContratWrapper;
import com.sample.biblio.fe.core.crude.viewhelper.marche.ContratCrudeViewhelper;
import com.sample.frame.fe.locator.SingleCachingServiceLocator;
import com.sample.frame.core.utils.JndiHelper;

/**
 *
 * @author ECHOUPE
 */
@ManagedBean
@SessionScoped
public class ContratCrudeController extends BaseCrudeController<TabContrat, ContratWrapper>{

    IContratSvc contratSvc;  
	
    @Override
    public IGenericSvc<TabContrat, String> getCurrentSvc() {
	try{
            System.out.println("ContratCrudeController.getCurrentSvc() - Localisation du services");
            if(contratSvc == null) {
		String ejbPath = JndiHelper.lookupRemoteStatelessName("biblio-z-ear", "biblio-be-svc-dao-impl", "", "ContratSvc", IContratSvcRemote.class);
		contratSvc = (IContratSvc) SingleCachingServiceLocator.getInstance().lookup(ejbPath);
		System.out.println("ContratCrudeController.getCurrentSvc() - localisation avec succès à priori");
		contratSvc.rechercherTout();
		return contratSvc;
            }
	}catch(Exception e){
            e.printStackTrace();
	}
	System.out.println("ContratCrudeController.getCurrentSvc() - Est-ce-que mon service est localisé ? " + !(contratSvc==null));
		
	return contratSvc;
    }

    public ContratCrudeController() {
	this.viewHelper = new ContratCrudeViewhelper();		
    }
	
}