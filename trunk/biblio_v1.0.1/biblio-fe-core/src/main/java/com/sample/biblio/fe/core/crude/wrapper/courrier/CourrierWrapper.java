/*

*/
package com.sample.biblio.fe.core.crude.wrapper.courrier;

import java.io.Serializable;
import com.sample.biblio.model.courrier.TabCourrier;
import com.sample.frame.fe.controller.crude.CrudeBusinessEntityWrapper;

/**
 * Applique le design pattern Wrapper, une variante du design pattern Adapter
 * Cette classe adapte l'interface de la classe enveloppée afin que cette dernière puisse
 * être utilisée par les objets existants contrôleur et vue
 * @author ECHOUPE
 */
public class CourrierWrapper extends CrudeBusinessEntityWrapper<TabCourrier> {
	
    public CourrierWrapper(TabCourrier wrappedEntity) {
	super(wrappedEntity);
    }

    @Override
    public CrudeBusinessEntityWrapper<TabCourrier> getNewInstance() {		
	return new CourrierWrapper(new TabCourrier());
    }

    @Override
    public CrudeBusinessEntityWrapper<TabCourrier> getNewInstance(TabCourrier e) {
	return new CourrierWrapper(e);
    }

    @Override
    public String getShortCutName() {		
	return "Courrier";
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
	return this.getWrappedEntity().getNumeroCourrier();
    }

}