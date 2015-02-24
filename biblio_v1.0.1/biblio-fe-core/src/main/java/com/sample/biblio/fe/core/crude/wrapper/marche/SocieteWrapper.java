/*

*/
package com.sample.biblio.fe.core.crude.wrapper.marche;

import java.io.Serializable;
import com.sample.biblio.model.marche.TabSociete;
import com.sample.frame.fe.controller.crude.CrudeBusinessEntityWrapper;

/**
 * @author ECHOUPE
 */
public class SocieteWrapper extends CrudeBusinessEntityWrapper<TabSociete> {
	
    public SocieteWrapper(TabSociete wrappedEntity) {
	super(wrappedEntity);
    }

    @Override
    public CrudeBusinessEntityWrapper<TabSociete> getNewInstance() {		
	return new SocieteWrapper(new TabSociete());
    }

    @Override
    public CrudeBusinessEntityWrapper<TabSociete> getNewInstance(TabSociete e) {
	return new SocieteWrapper(e);
    }

    @Override
    public String getShortCutName() {		
	return "Societe";
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
	return this.getWrappedEntity().getIdSociete();
    }

}
