/*

 */
package com.sample.biblio.fe.core.crude.viewhelper.marche;

import com.sample.biblio.model.marche.TabModeSelection;
import com.sample.biblio.fe.core.crude.wrapper.marche.ModeSelectionWrapper;
import com.sample.frame.fe.controller.crude.CrudeViewHelper;
import com.sample.frame.fe.helper.tablemanager.PrimeFacesTableManager;

/**
 *
 * @author ECHOUPE
 */
public class ModeSelectionCrudeViewhelper extends CrudeViewHelper<ModeSelectionWrapper>{

    public ModeSelectionCrudeViewhelper(){
	super(new ModeSelectionWrapper(new TabModeSelection()));	
	this.setDataManager(new PrimeFacesTableManager<ModeSelectionWrapper>());
	this.setSelectionDataManager(new PrimeFacesTableManager<ModeSelectionWrapper>());
    }
	
    @Override
    public void initializeTestContext() {
	// TODO Auto-generated method stub
    }

}