/*

*/
package com.sample.biblio.fe.core.crude.wrapper.marche;

import java.io.Serializable;
import com.sample.biblio.model.marche.TabOperation;
import com.sample.frame.fe.controller.crude.CrudeBusinessEntityWrapper;

/**
 * @author ECHOUPE
 */
public class OperationWrapper extends CrudeBusinessEntityWrapper<TabOperation> {
	
    public OperationWrapper(TabOperation wrappedEntity) {
	super(wrappedEntity);
    }

    @Override
    public CrudeBusinessEntityWrapper<TabOperation> getNewInstance() {		
	return new OperationWrapper(new TabOperation());
    }

    @Override
    public CrudeBusinessEntityWrapper<TabOperation> getNewInstance(TabOperation e) {
	return new OperationWrapper(e);
    }

    @Override
    public String getShortCutName() {		
	return "Operation";
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
	return this.getWrappedEntity().getTabOperationPK();
    }

}