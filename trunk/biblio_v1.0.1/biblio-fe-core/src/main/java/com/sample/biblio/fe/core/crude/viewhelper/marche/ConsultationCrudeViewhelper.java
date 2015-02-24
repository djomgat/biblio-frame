/*

 */
package com.sample.biblio.fe.core.crude.viewhelper.marche;

import com.sample.biblio.model.marche.TabConsultation;
import com.sample.biblio.fe.core.crude.wrapper.marche.ConsultationWrapper;
import com.sample.frame.fe.controller.crude.CrudeViewHelper;
import com.sample.frame.fe.helper.tablemanager.PrimeFacesTableManager;

/**
 *
 * @author ECHOUPE
 */
public class ConsultationCrudeViewhelper extends CrudeViewHelper<ConsultationWrapper>{

    public ConsultationCrudeViewhelper(){
	super(new ConsultationWrapper(new TabConsultation()));	
	this.setDataManager(new PrimeFacesTableManager<ConsultationWrapper>());
	this.setSelectionDataManager(new PrimeFacesTableManager<ConsultationWrapper>());
    }
	
    @Override
    public void initializeTestContext() {
	// TODO Auto-generated method stub
    }

}