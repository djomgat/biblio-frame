/*

*/
package com.sample.biblio.fe.core.crude.wrapper.marche;

import java.io.Serializable;
import com.sample.biblio.model.marche.TabModeSelection;
import com.sample.frame.fe.controller.crude.CrudeBusinessEntityWrapper;

/**
 * @author ECHOUPE
 */
public class ModeSelectionWrapper extends CrudeBusinessEntityWrapper<TabModeSelection> {
	
    public ModeSelectionWrapper(TabModeSelection wrappedEntity) {
	super(wrappedEntity);
    }

    @Override
    public CrudeBusinessEntityWrapper<TabModeSelection> getNewInstance() {		
	return new ModeSelectionWrapper(new TabModeSelection());
    }

    @Override
    public CrudeBusinessEntityWrapper<TabModeSelection> getNewInstance(TabModeSelection e) {
	return new ModeSelectionWrapper(e);
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
	return this.getWrappedEntity().getIdModeSelection();
    }

}
