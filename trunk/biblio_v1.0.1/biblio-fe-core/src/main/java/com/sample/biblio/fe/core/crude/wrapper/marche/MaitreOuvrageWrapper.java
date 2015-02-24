/*

*/
package com.sample.biblio.fe.core.crude.wrapper.marche;

import java.io.Serializable;
import com.sample.biblio.model.marche.TabMoa;
import com.sample.frame.fe.controller.crude.CrudeBusinessEntityWrapper;

/**
 * @author ECHOUPE
 */
public class MaitreOuvrageWrapper extends CrudeBusinessEntityWrapper<TabMoa> {
	
    public MaitreOuvrageWrapper(TabMoa wrappedEntity) {
	super(wrappedEntity);
    }

    @Override
    public CrudeBusinessEntityWrapper<TabMoa> getNewInstance() {		
	return new MaitreOuvrageWrapper(new TabMoa());
    }

    @Override
    public CrudeBusinessEntityWrapper<TabMoa> getNewInstance(TabMoa e) {
	return new MaitreOuvrageWrapper(e);
    }

    @Override
    public String getShortCutName() {		
	return "MaitreOuvrage";
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
	return this.getWrappedEntity().getIdMoa();
    }

}
