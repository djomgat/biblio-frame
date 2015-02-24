/*

*/
package com.sample.biblio.fe.core.crude.wrapper.marche;

import java.io.Serializable;
import com.sample.biblio.model.marche.TabConsultation;
import com.sample.frame.fe.controller.crude.CrudeBusinessEntityWrapper;

/**
 * @author ECHOUPE
 */
public class ConsultationWrapper extends CrudeBusinessEntityWrapper<TabConsultation> {
	
    public ConsultationWrapper(TabConsultation wrappedEntity) {
	super(wrappedEntity);
    }

    @Override
    public CrudeBusinessEntityWrapper<TabConsultation> getNewInstance() {		
	return new ConsultationWrapper(new TabConsultation());
    }

    @Override
    public CrudeBusinessEntityWrapper<TabConsultation> getNewInstance(TabConsultation e) {
	return new ConsultationWrapper(e);
    }

    @Override
    public String getShortCutName() {		
	return "Consultation";
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
	return this.getWrappedEntity().getIdConsultation();
    }

}
