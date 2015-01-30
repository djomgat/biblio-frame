package com.sample.biblio.fe.core.crude.viewhelper;

import com.sample.biblio.model.Tabclass;
import com.sample.biblio.fe.core.crude.wrapper.ClasseWrapper;
import com.sample.frame.fe.controller.crude.CrudeViewHelper;
import com.sample.frame.fe.helper.tablemanager.PrimeFacesTableManager;

public class ClassCrudeViewhelper extends CrudeViewHelper<ClasseWrapper>{

	
	public ClassCrudeViewhelper(){
		super(new ClasseWrapper(new Tabclass()));	
		
		this.setDataManager(new PrimeFacesTableManager<ClasseWrapper>());
		this.setSelectionDataManager(new PrimeFacesTableManager<ClasseWrapper>());

	}
	
//	public ClassCrudeViewhelper(ClasseWrapper wrapperInstance) {
//		super(wrapperInstance);
//		
//		// Initialisation
//		this.setDataManager(new PrimeFacesTableManager<ClasseWrapper>());
//		this.setSelectionDataManager(new PrimeFacesTableManager<ClasseWrapper>());
//	}

	@Override
	public void initializeTestContext() {
		// TODO Auto-generated method stub
		
	}

}
