/*

*/
package com.sample.biblio.fe.core.crude.wrapper.courrier;

import java.io.Serializable;
import com.sample.frame.fe.controller.crude.CrudeBusinessEntityWrapper;
import com.sample.biblio.model.courrier.TabPersonne;

/**
 * Applique le design pattern Wrapper, une variante du design pattern Adapter
 * @author ECHOUPE
 */
public class PersonneWrapper extends CrudeBusinessEntityWrapper<TabPersonne> {
	
    public PersonneWrapper(TabPersonne wrappedEntity) {
	super(wrappedEntity);
    }

    @Override
    public CrudeBusinessEntityWrapper<TabPersonne> getNewInstance() {		
	return new PersonneWrapper(new TabPersonne());
    }

    @Override
    public CrudeBusinessEntityWrapper<TabPersonne> getNewInstance(TabPersonne e) {
	return new PersonneWrapper(e);
    }

    @Override
    public String getShortCutName() {		
	return "Personne";
    }

    @Override
    public void setOffset(long offset) {
	// TODO Auto-generated method stub		
    }

    @Override
    public void setMaxRow(int maxRow) {
	// TODO Auto-generated method stub		
    }
	
    @Override
    public Serializable getId() {
	return this.getWrappedEntity().getIdPersonne();
    }

}
