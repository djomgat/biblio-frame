/*

 */
package com.sample.biblio.fe.core.crude.viewhelper.courrier;

import com.sample.biblio.model.courrier.TabCourrier;
import com.sample.biblio.fe.core.crude.wrapper.courrier.CourrierWrapper;
import com.sample.frame.fe.controller.crude.CrudeViewHelper;
import com.sample.frame.fe.helper.tablemanager.PrimeFacesTableManager;

/**
 * Cette classe conserve toutes les données destinées à l'affichage dans la vue (Pattern ViewHelper)
 * @author ECHOUPE
 */
public class CourrierCrudeViewhelper extends CrudeViewHelper<CourrierWrapper>{

    public CourrierCrudeViewhelper(){
	super(new CourrierWrapper(new TabCourrier()));	
	this.setDataManager(new PrimeFacesTableManager<CourrierWrapper>());
	this.setSelectionDataManager(new PrimeFacesTableManager<CourrierWrapper>());
    }
	
    @Override
    public void initializeTestContext() {
	// TODO Auto-generated method stub
    }

}