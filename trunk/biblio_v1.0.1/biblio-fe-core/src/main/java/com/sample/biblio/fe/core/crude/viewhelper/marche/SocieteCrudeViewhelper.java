/*

 */
package com.sample.biblio.fe.core.crude.viewhelper.marche;

import com.sample.biblio.model.marche.TabSociete;
import com.sample.biblio.fe.core.crude.wrapper.marche.SocieteWrapper;
import com.sample.frame.fe.controller.crude.CrudeViewHelper;
import com.sample.frame.fe.helper.tablemanager.PrimeFacesTableManager;

/**
 *
 * @author ECHOUPE
 */
public class SocieteCrudeViewhelper extends CrudeViewHelper<SocieteWrapper>{

    public SocieteCrudeViewhelper(){
	super(new SocieteWrapper(new TabSociete()));	
	this.setDataManager(new PrimeFacesTableManager<SocieteWrapper>());
	this.setSelectionDataManager(new PrimeFacesTableManager<SocieteWrapper>());
    }
	
    @Override
    public void initializeTestContext() {
	// TODO Auto-generated method stub
    }

}