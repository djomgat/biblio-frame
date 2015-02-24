/*

*/
package com.sample.biblio.fe.core.crude.wrapper.courrier;

import java.io.Serializable;
import com.sample.frame.fe.controller.crude.CrudeBusinessEntityWrapper;
import com.sample.biblio.model.courrier.TabService;

/**
 * Applique le design pattern Wrapper, une variante du design pattern Adapter
 * @author ECHOUPE
 */
public class ServiceWrapper extends CrudeBusinessEntityWrapper<TabService> {
	
    public ServiceWrapper(TabService wrappedEntity) {
	super(wrappedEntity);
    }

    @Override
    public CrudeBusinessEntityWrapper<TabService> getNewInstance() {		
	return new ServiceWrapper(new TabService());
    }

    @Override
    public CrudeBusinessEntityWrapper<TabService> getNewInstance(TabService e) {
	return new ServiceWrapper(e);
    }

    @Override
    public String getShortCutName() {		
	return "Service";
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
	return this.getWrappedEntity().getIdService();
    }

}
