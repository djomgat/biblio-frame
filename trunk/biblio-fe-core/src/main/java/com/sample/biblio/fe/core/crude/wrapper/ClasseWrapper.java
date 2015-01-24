package com.sample.biblio.fe.core.crude.wrapper;

import java.io.Serializable;

import com.sample.biblio.entity.Tabclass;
import com.sample.frame.fe.controller.crude.CrudeBusinessEntityWrapper;

public class ClasseWrapper  extends CrudeBusinessEntityWrapper<Tabclass> {
	
	public ClasseWrapper(Tabclass wrappedEntity) {
		super(wrappedEntity);
	}

	@Override
	public CrudeBusinessEntityWrapper<Tabclass> getNewInstance() {		
		return new ClasseWrapper(new Tabclass());
	}

	@Override
	public CrudeBusinessEntityWrapper<Tabclass> getNewInstance(Tabclass e) {
		return new ClasseWrapper(e);
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