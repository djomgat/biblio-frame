/*

*/
package com.sample.biblio.fe.core.crude.wrapper.courrier;

import java.io.Serializable;
import com.sample.frame.fe.controller.crude.CrudeBusinessEntityWrapper;
import com.sample.biblio.model.courrier.TabTypeCourrier;

/**
 * Applique le design pattern Wrapper, une variante du design pattern Adapter
 * @author ECHOUPE
 */
public class TypeCourrierWrapper extends CrudeBusinessEntityWrapper<TabTypeCourrier> {
	
    public TypeCourrierWrapper(TabTypeCourrier wrappedEntity) {
	super(wrappedEntity);
    }

    @Override
    public CrudeBusinessEntityWrapper<TabTypeCourrier> getNewInstance() {		
	return new TypeCourrierWrapper(new TabTypeCourrier());
    }

    @Override
    public CrudeBusinessEntityWrapper<TabTypeCourrier> getNewInstance(TabTypeCourrier e) {
	return new TypeCourrierWrapper(e);
    }

    @Override
    public String getShortCutName() {		
	return "TypeCourrier";
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
	return this.getWrappedEntity().getCodeTypeCourrier();
    }

}
