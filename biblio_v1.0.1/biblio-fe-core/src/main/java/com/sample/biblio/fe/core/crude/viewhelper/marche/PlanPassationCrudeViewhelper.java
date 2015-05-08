/*

 */
package com.sample.biblio.fe.core.crude.viewhelper.marche;

import com.sample.biblio.model.marche.TabPlanPassation;
import com.sample.biblio.fe.core.crude.wrapper.marche.PlanPassationWrapper;
import com.sample.frame.fe.controller.crude.CrudeViewHelper;
import com.sample.frame.fe.helper.tablemanager.PrimeFacesTableManager;

/**
 *
 * @author ECHOUPE
 */
public class PlanPassationCrudeViewhelper extends CrudeViewHelper<PlanPassationWrapper>{

    public PlanPassationCrudeViewhelper(){
	super(new PlanPassationWrapper(new TabPlanPassation()));	
	this.setDataManager(new PrimeFacesTableManager<PlanPassationWrapper>());
	this.setSelectionDataManager(new PrimeFacesTableManager<PlanPassationWrapper>());
    }
	
    @Override
    public void initializeTestContext() {
	// TODO Auto-generated method stub
    }

}