/*

 */
package com.sample.biblio.fe.core.crude.viewhelper.courrier;

import com.sample.biblio.model.courrier.TabNatureCourrier;
import com.sample.biblio.fe.core.crude.wrapper.courrier.NatureCourrierWrapper;
import com.sample.frame.fe.controller.crude.CrudeViewHelper;
import com.sample.frame.fe.helper.tablemanager.PrimeFacesTableManager;

/**
 *
 * @author ECHOUPE
 */
public class NatureCourrierCrudeViewhelper extends CrudeViewHelper<NatureCourrierWrapper>{

    public NatureCourrierCrudeViewhelper(){
	super(new NatureCourrierWrapper(new TabNatureCourrier()));	
	this.setDataManager(new PrimeFacesTableManager<NatureCourrierWrapper>());
	this.setSelectionDataManager(new PrimeFacesTableManager<NatureCourrierWrapper>());
    }
	
    @Override
    public void initializeTestContext() {
	// TODO Auto-generated method stub
    }

}
