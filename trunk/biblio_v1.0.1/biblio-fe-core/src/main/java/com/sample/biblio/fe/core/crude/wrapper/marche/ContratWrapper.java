/*

*/
package com.sample.biblio.fe.core.crude.wrapper.marche;

import java.io.Serializable;
import com.sample.biblio.model.marche.TabContrat;
import com.sample.frame.fe.controller.crude.CrudeBusinessEntityWrapper;

/**
 * Applique le design pattern Wrapper, une variante du design pattern Adapter
 * pour envelopper une entité et en dériver une autre en lui ajoutant des propriétés
 * et des méthodes.
 * @author ECHOUPE
 */
public class ContratWrapper extends CrudeBusinessEntityWrapper<TabContrat> {
	
    public ContratWrapper(TabContrat wrappedEntity) {
	super(wrappedEntity);
    }

    @Override
    public CrudeBusinessEntityWrapper<TabContrat> getNewInstance() {		
	return new ContratWrapper(new TabContrat());
    }

    @Override
    public CrudeBusinessEntityWrapper<TabContrat> getNewInstance(TabContrat e) {
	return new ContratWrapper(e);
    }

    @Override
    public String getShortCutName() {		
	return "Contrat";
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
	return this.getWrappedEntity().getIdContrat();
    }

}