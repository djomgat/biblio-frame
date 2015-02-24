package com.sample.frame.fe.controller.crude;

import java.util.Collection;


/**
 * 
 * @author lkamhoua
 *
 * @param <E>
 */
public interface ICrudeController<E> {
	
		
	public void setSelectedData(CrudeBusinessEntityWrapper<?> e);
	

	public void setSelectedData(Collection<? extends CrudeBusinessEntityWrapper<?>> l);

	
	public String navigateToSelectionView(String selectionController, String selectionView);
}
