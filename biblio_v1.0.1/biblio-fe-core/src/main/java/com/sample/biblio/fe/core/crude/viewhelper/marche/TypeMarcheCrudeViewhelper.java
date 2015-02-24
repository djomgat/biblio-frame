/*

 */
package com.sample.biblio.fe.core.crude.viewhelper.marche;

import com.sample.biblio.model.marche.TabTypeMarche;
import com.sample.biblio.fe.core.crude.wrapper.marche.TypeMarcheWrapper;
import com.sample.frame.fe.controller.crude.CrudeViewHelper;
import com.sample.frame.fe.helper.tablemanager.PrimeFacesTableManager;

/**
 *
 * @author ECHOUPE
 */
public class TypeMarcheCrudeViewhelper extends CrudeViewHelper<TypeMarcheWrapper>{

    public TypeMarcheCrudeViewhelper(){
	super(new TypeMarcheWrapper(new TabTypeMarche()));	
	this.setDataManager(new PrimeFacesTableManager<TypeMarcheWrapper>());
	this.setSelectionDataManager(new PrimeFacesTableManager<TypeMarcheWrapper>());
    }
	
    @Override
    public void initializeTestContext() {
	// TODO Auto-generated method stub
    }

}