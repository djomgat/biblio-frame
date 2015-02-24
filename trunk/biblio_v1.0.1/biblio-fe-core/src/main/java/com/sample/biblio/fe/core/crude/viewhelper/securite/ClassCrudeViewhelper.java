package com.sample.biblio.fe.core.crude.viewhelper.securite;

import com.sample.biblio.model.securite.Tabclass;
import com.sample.biblio.fe.core.crude.wrapper.securite.ClassWrapper;
import com.sample.biblio.fe.core.crude.wrapper.securite.ClassWrapper;
import com.sample.frame.fe.controller.crude.CrudeViewHelper;
import com.sample.frame.fe.helper.tablemanager.PrimeFacesTableManager;

public class ClassCrudeViewhelper extends CrudeViewHelper<ClassWrapper>{

    public ClassCrudeViewhelper(){
	super(new ClassWrapper(new Tabclass()));	
	this.setDataManager(new PrimeFacesTableManager<ClassWrapper>());
	this.setSelectionDataManager(new PrimeFacesTableManager<ClassWrapper>());
    }
	
    @Override
    public void initializeTestContext() {
	// TODO Auto-generated method stub
    }

}