/*

*/
package com.sample.biblio.fe.core.crude.wrapper.marche;

import java.io.Serializable;
import com.sample.biblio.model.marche.TabPlanPassation;
import com.sample.frame.fe.controller.crude.CrudeBusinessEntityWrapper;

/**
 * @author ECHOUPE
 */
public class PlanPassationWrapper extends CrudeBusinessEntityWrapper<TabPlanPassation> {
	
    public PlanPassationWrapper(TabPlanPassation wrappedEntity) {
	super(wrappedEntity);
    }

    @Override
    public CrudeBusinessEntityWrapper<TabPlanPassation> getNewInstance() {		
	return new PlanPassationWrapper(new TabPlanPassation());
    }

    @Override
    public CrudeBusinessEntityWrapper<TabPlanPassation> getNewInstance(TabPlanPassation e) {
	return new PlanPassationWrapper(e);
    }

    @Override
    public String getShortCutName() {		
	return "PlanPassation";
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
	return this.getWrappedEntity().getTabPlanPassationPK();
    }

}