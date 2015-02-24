/*

 */
package com.sample.biblio.fe.core.crude.viewhelper.marche;

import com.sample.biblio.model.marche.TabMoa;
import com.sample.biblio.fe.core.crude.wrapper.marche.MaitreOuvrageWrapper;
import com.sample.frame.fe.controller.crude.CrudeViewHelper;
import com.sample.frame.fe.helper.tablemanager.PrimeFacesTableManager;

/**
 *
 * @author ECHOUPE
 */
public class MaitreOuvrageCrudeViewhelper extends CrudeViewHelper<MaitreOuvrageWrapper>{

    public MaitreOuvrageCrudeViewhelper(){
	super(new MaitreOuvrageWrapper(new TabMoa()));	
	this.setDataManager(new PrimeFacesTableManager<MaitreOuvrageWrapper>());
	this.setSelectionDataManager(new PrimeFacesTableManager<MaitreOuvrageWrapper>());
    }
	
    @Override
    public void initializeTestContext() {
	// TODO Auto-generated method stub
    }

}