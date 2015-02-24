/*

*/
package com.sample.biblio.fe.core.crude.wrapper.courrier;

import java.io.Serializable;
import com.sample.frame.fe.controller.crude.CrudeBusinessEntityWrapper;
import com.sample.biblio.model.courrier.TabDestinataire;

/**
 * Applique le design pattern Wrapper, une variante du design pattern Adapter
 * @author ECHOUPE
 */
public class DestinataireWrapper extends CrudeBusinessEntityWrapper<TabDestinataire> {
	
    public DestinataireWrapper(TabDestinataire wrappedEntity) {
	super(wrappedEntity);
    }

    @Override
    public CrudeBusinessEntityWrapper<TabDestinataire> getNewInstance() {		
	return new DestinataireWrapper(new TabDestinataire());
    }

    @Override
    public CrudeBusinessEntityWrapper<TabDestinataire> getNewInstance(TabDestinataire e) {
	return new DestinataireWrapper(e);
    }

    @Override
    public String getShortCutName() {		
	return "Destinataire";
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
	return this.getWrappedEntity().getTabDestinatairePK();
    }

}