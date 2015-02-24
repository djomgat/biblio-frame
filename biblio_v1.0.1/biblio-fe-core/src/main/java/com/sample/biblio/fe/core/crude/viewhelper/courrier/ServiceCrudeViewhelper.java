/*

 */
package com.sample.biblio.fe.core.crude.viewhelper.courrier;

import com.sample.biblio.model.courrier.TabService;
import com.sample.biblio.fe.core.crude.wrapper.courrier.ServiceWrapper;
import com.sample.frame.fe.controller.crude.CrudeViewHelper;
import com.sample.frame.fe.helper.tablemanager.PrimeFacesTableManager;

/**
 *
 * @author ECHOUPE
 */
public class ServiceCrudeViewhelper extends CrudeViewHelper<ServiceWrapper>{

    public ServiceCrudeViewhelper(){
	super(new ServiceWrapper(new TabService()));	
	this.setDataManager(new PrimeFacesTableManager<ServiceWrapper>());
	this.setSelectionDataManager(new PrimeFacesTableManager<ServiceWrapper>());
    }
	
    @Override
    public void initializeTestContext() {
	// TODO Auto-generated method stub
    }

}