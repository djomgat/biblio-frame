package com.sample.biblio.fe.core.crude.wrapper.securite;

import java.io.Serializable;
import com.sample.biblio.model.securite.Tabclass;
import com.sample.frame.fe.controller.crude.CrudeBusinessEntityWrapper;

public class ClassWrapper extends CrudeBusinessEntityWrapper<Tabclass> {
	
    public ClassWrapper(Tabclass wrappedEntity) {
	super(wrappedEntity);
    }

    @Override
    public CrudeBusinessEntityWrapper<Tabclass> getNewInstance() {		
	return new ClassWrapper(new Tabclass());
    }

    @Override
    public CrudeBusinessEntityWrapper<Tabclass> getNewInstance(Tabclass e) {
	return new ClassWrapper(e);
    }

    @Override
    public String getShortCutName() {		
	return "Class";
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
	return this.getWrappedEntity().getCodeClass();
    }

}