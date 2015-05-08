/*

 */
package com.sample.biblio.fe.core.crude.viewhelper.marche;

import com.sample.biblio.model.marche.TabOperation;
import com.sample.biblio.fe.core.crude.wrapper.marche.OperationWrapper;
import com.sample.frame.fe.controller.crude.CrudeViewHelper;
import com.sample.frame.fe.helper.tablemanager.PrimeFacesTableManager;

/**
 *
 * @author ECHOUPE
 */
public class OperationCrudeViewhelper extends CrudeViewHelper<OperationWrapper>{

    public OperationCrudeViewhelper(){
	super(new OperationWrapper(new TabOperation()));	
	this.setDataManager(new PrimeFacesTableManager<OperationWrapper>());
	this.setSelectionDataManager(new PrimeFacesTableManager<OperationWrapper>());
    }
	
    @Override
    public void initializeTestContext() {
	// TODO Auto-generated method stub
    }

}