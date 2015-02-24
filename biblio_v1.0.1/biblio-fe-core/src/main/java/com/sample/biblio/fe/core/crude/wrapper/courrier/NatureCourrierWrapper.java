/*

*/
package com.sample.biblio.fe.core.crude.wrapper.courrier;

import java.io.Serializable;
import com.sample.frame.fe.controller.crude.CrudeBusinessEntityWrapper;
import com.sample.biblio.model.courrier.TabNatureCourrier;

/**
 * Applique le design pattern Wrapper, une variante du design pattern Adapter
 * @author ECHOUPE
 */
public class NatureCourrierWrapper extends CrudeBusinessEntityWrapper<TabNatureCourrier> {
	
    public NatureCourrierWrapper(TabNatureCourrier wrappedEntity) {
	super(wrappedEntity);
    }

    @Override
    public CrudeBusinessEntityWrapper<TabNatureCourrier> getNewInstance() {		
	return new NatureCourrierWrapper(new TabNatureCourrier());
    }

    @Override
    public CrudeBusinessEntityWrapper<TabNatureCourrier> getNewInstance(TabNatureCourrier e) {
	return new NatureCourrierWrapper(e);
    }

    @Override
    public String getShortCutName() {		
	return "NatureCourrier";
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
	return this.getWrappedEntity().getCodeNatureCourrier();
    }

}

