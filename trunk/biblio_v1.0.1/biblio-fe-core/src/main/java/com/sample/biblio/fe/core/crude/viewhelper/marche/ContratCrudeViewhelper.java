/*

 */
package com.sample.biblio.fe.core.crude.viewhelper.marche;

import com.sample.biblio.model.marche.TabContrat;
import com.sample.biblio.fe.core.crude.wrapper.marche.ContratWrapper;
import com.sample.frame.fe.controller.crude.CrudeViewHelper;
import com.sample.frame.fe.helper.tablemanager.PrimeFacesTableManager;

/**
 *
 * @author ECHOUPE
 */
public class ContratCrudeViewhelper extends CrudeViewHelper<ContratWrapper>{

    public ContratCrudeViewhelper(){
	super(new ContratWrapper(new TabContrat()));	
	this.setDataManager(new PrimeFacesTableManager<ContratWrapper>());
	this.setSelectionDataManager(new PrimeFacesTableManager<ContratWrapper>());
    }
	
    @Override
    public void initializeTestContext() {
	// TODO Auto-generated method stub
    }

}