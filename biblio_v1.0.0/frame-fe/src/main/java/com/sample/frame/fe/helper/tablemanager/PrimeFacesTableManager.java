/**
 * 
 */
package com.sample.frame.fe.helper.tablemanager;

import java.util.Collection;
import java.util.List;






/**
 * Classe de gestion des tables / tableaux de donn�es sp�cialis�e pour PrimeFaces
 * 
 */
public class PrimeFacesTableManager<E> extends AbstractListTableManager<E> {
	

/******************************************************************************************************************************************************************************
 * 
 * Properties 
 * 
 ******************************************************************************************************************************************************************************/
	
	/**
	 * Liste des donn�es filtr�es
	 */
	protected List<E> filteredDatas;
	
	
	
/******************************************************************************************************************************************************************************
 * 
 * Constructor 
 * 
 ******************************************************************************************************************************************************************************/

	/**
	 * Constructeur par d�faut
	 */
	public PrimeFacesTableManager(){
		super();
	}
	
	/**
	 * Constructeur param�tr�
	 * 
	 * @param data Donn�es
	 */
	public PrimeFacesTableManager(Collection<E> data){		
		super(data);
	}

	
	
/******************************************************************************************************************************************************************************
 * 
 * Getter & Setter & Overriden Methods 
 * 
 ******************************************************************************************************************************************************************************/

	
	/**
	 * @return the filteredDatas
	 */
	public List<E> getFilteredDatas() {
		return this.filteredDatas;
	}

	/**
	 * @param filteredDatas the filteredDatas to set
	 */
	public void setFilteredDatas(List<E> filteredDatas) {
		this.filteredDatas = filteredDatas;
	}
	
}
