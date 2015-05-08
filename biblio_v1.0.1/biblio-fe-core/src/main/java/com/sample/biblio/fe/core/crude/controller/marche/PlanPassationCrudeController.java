/*

 */
package com.sample.biblio.fe.core.crude.controller.marche;

import com.sample.frame.fe.controller.crude.BaseCrudeController;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.sample.frame.core.svc.generic.IGenericSvc;
import com.sample.biblio.model.marche.TabPlanPassation;
import com.sample.biblio.svc.api.marche.IPlanPassationSvc;
import com.sample.biblio.svc.api.marche.IPlanPassationSvcRemote;
import com.sample.biblio.fe.core.crude.wrapper.marche.PlanPassationWrapper;
import com.sample.biblio.fe.core.crude.viewhelper.marche.PlanPassationCrudeViewhelper;
import com.sample.frame.fe.locator.SingleCachingServiceLocator;
import com.sample.frame.core.utils.JndiHelper;

/**
 *
 * @author ECHOUPE
 */
@ManagedBean
@SessionScoped
public class PlanPassationCrudeController extends BaseCrudeController<TabPlanPassation, PlanPassationWrapper>{

    IPlanPassationSvc operationSvc;  
	
    @Override
    public IGenericSvc<TabPlanPassation, String> getCurrentSvc() {
	try{
            System.out.println("PlanPassationCrudeController.getCurrentSvc() - Localisation du services");
            if(operationSvc == null) {
		String ejbPath = JndiHelper.lookupRemoteStatelessName("biblio-z-ear", "biblio-be-svc-dao-impl", "", "ContratSvc", IPlanPassationSvcRemote.class);
		operationSvc = (IPlanPassationSvc) SingleCachingServiceLocator.getInstance().lookup(ejbPath);
		System.out.println("PlanPassationCrudeController.getCurrentSvc() - localisation avec succès à priori");
		operationSvc.rechercherTout();
		return operationSvc;
            }
	}catch(Exception e){
            e.printStackTrace();
	}
	System.out.println("PlanPassationCrudeController.getCurrentSvc() - Est-ce-que mon service est localisé ? " + !(operationSvc==null));
		
	return operationSvc;
    }

    public PlanPassationCrudeController() {
	this.viewHelper = new PlanPassationCrudeViewhelper();		
    }
	
}