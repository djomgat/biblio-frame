package com.sample.biblio.fe.core.crude.wrapper;

import java.io.Serializable;

import com.sample.biblio.entity.sample.Tabuser;
import com.sample.frame.fe.controller.crude.CrudeBusinessEntityWrapper;

public class UserWrapper  extends CrudeBusinessEntityWrapper<Tabuser> {

	
	public UserWrapper(Tabuser wrappedEntity) {
		super(wrappedEntity);
	}

	@Override
	public CrudeBusinessEntityWrapper<Tabuser> getNewInstance() {
		
		return new UserWrapper(new Tabuser());
	}

	@Override
	public CrudeBusinessEntityWrapper<Tabuser> getNewInstance(Tabuser e) {
		return new UserWrapper(e);
	}

	@Override
	public String getShortCutName() {
		
		return "User";
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
		return this.getWrappedEntity().getCodeUser();
	}

}
