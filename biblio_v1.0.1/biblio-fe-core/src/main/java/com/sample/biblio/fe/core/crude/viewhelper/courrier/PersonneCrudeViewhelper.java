/*

 */
package com.sample.biblio.fe.core.crude.viewhelper.courrier;

import com.sample.biblio.model.courrier.TabPersonne;
import com.sample.biblio.fe.core.crude.wrapper.courrier.PersonneWrapper;
import com.sample.frame.fe.controller.crude.CrudeViewHelper;
import com.sample.frame.fe.helper.tablemanager.PrimeFacesTableManager;

/**
 *
 * @author ECHOUPE
 */
public class PersonneCrudeViewhelper extends CrudeViewHelper<PersonneWrapper>{

    public PersonneCrudeViewhelper(){
	super(new PersonneWrapper(new TabPersonne()));	
	this.setDataManager(new PrimeFacesTableManager<PersonneWrapper>());
	this.setSelectionDataManager(new PrimeFacesTableManager<PersonneWrapper>());
    }
	
    @Override
    public void initializeTestContext() {
	// TODO Auto-generated method stub
    }

}