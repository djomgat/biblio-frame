/*

 */
package com.sample.biblio.fe.core.crude.controller.marche;

import com.sample.frame.fe.controller.crude.BaseCrudeController;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.sample.biblio.model.marche.TabOperation;
import com.sample.frame.core.svc.generic.IGenericSvc;
import com.sample.biblio.svc.api.marche.IOperationSvc;
import com.sample.biblio.svc.api.marche.IOperationSvcRemote;
import com.sample.biblio.fe.core.crude.wrapper.marche.OperationWrapper;
import com.sample.biblio.fe.core.crude.viewhelper.marche.OperationCrudeViewhelper;
import com.sample.frame.fe.locator.SingleCachingServiceLocator;
import com.sample.frame.core.utils.JndiHelper;

/**
 *
 * @author ECHOUPE
 */
@ManagedBean
@SessionScoped
public class OperationCrudeController extends BaseCrudeController<TabOperation, OperationWrapper>{

    IOperationSvc operationSvc;  
	
    @Override
    public IGenericSvc<TabOperation, String> getCurrentSvc() {
	try{
            System.out.println("OperationCrudeController.getCurrentSvc() - Localisation du services");
            if(operationSvc == null) {
		String ejbPath = JndiHelper.lookupRemoteStatelessName("biblio-z-ear", "biblio-be-svc-dao-impl", "", "ContratSvc", IOperationSvcRemote.class);
		operationSvc = (IOperationSvc) SingleCachingServiceLocator.getInstance().lookup(ejbPath);
		System.out.println("OperationCrudeController.getCurrentSvc() - localisation avec succès à priori");
		operationSvc.rechercherTout();
		return operationSvc;
            }
	}catch(Exception e){
            e.printStackTrace();
	}
	System.out.println("OperationCrudeController.getCurrentSvc() - Est-ce-que mon service est localisé ? " + !(operationSvc==null));
		
	return operationSvc;
    }

    public OperationCrudeController() {
	this.viewHelper = new OperationCrudeViewhelper();		
    }
	
}