/*

 */
package com.sample.biblio.fe.core.crude.viewhelper.courrier;

import com.sample.biblio.model.courrier.TabDestinataire;
import com.sample.biblio.fe.core.crude.wrapper.courrier.DestinataireWrapper;
import com.sample.frame.fe.controller.crude.CrudeViewHelper;
import com.sample.frame.fe.helper.tablemanager.PrimeFacesTableManager;

/**
 *
 * @author ECHOUPE
 */
public class DestinataireCrudeViewhelper extends CrudeViewHelper<DestinataireWrapper>{

    public DestinataireCrudeViewhelper(){
	super(new DestinataireWrapper(new TabDestinataire()));	
	this.setDataManager(new PrimeFacesTableManager<DestinataireWrapper>());
	this.setSelectionDataManager(new PrimeFacesTableManager<DestinataireWrapper>());
    }
	
    @Override
    public void initializeTestContext() {
	// TODO Auto-generated method stub
    }

}