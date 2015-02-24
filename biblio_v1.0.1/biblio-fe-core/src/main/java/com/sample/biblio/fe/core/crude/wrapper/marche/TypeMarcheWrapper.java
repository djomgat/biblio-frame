/*

*/
package com.sample.biblio.fe.core.crude.wrapper.marche;

import java.io.Serializable;
import com.sample.biblio.model.marche.TabTypeMarche;
import com.sample.frame.fe.controller.crude.CrudeBusinessEntityWrapper;

/**
 * @author ECHOUPE
 */
public class TypeMarcheWrapper extends CrudeBusinessEntityWrapper<TabTypeMarche> {
	
    public TypeMarcheWrapper(TabTypeMarche wrappedEntity) {
	super(wrappedEntity);
    }

    @Override
    public CrudeBusinessEntityWrapper<TabTypeMarche> getNewInstance() {		
	return new TypeMarcheWrapper(new TabTypeMarche());
    }

    @Override
    public CrudeBusinessEntityWrapper<TabTypeMarche> getNewInstance(TabTypeMarche e) {
	return new TypeMarcheWrapper(e);
    }

    @Override
    public String getShortCutName() {		
	return "TypeMarche";
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
	return this.getWrappedEntity().getCodeTypeMarche();
    }

}