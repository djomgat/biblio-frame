/**
 * 
 */
package com.sample.frame.fe.helper.tablemanager;

import java.util.Collection;





/**
 * Classe basique de gestion des tables / tableaux de donn�es 
 * 
 *
 */
public class SimpleTableManager<E> extends AbstractListTableManager<E> {
	
	
/******************************************************************************************************************************************************************************
 * 
 * Constructor 
 * 
 ******************************************************************************************************************************************************************************/

	/**
	 * Constructeur par d�faut
	 */
	public SimpleTableManager(){
		super();
	}
	
	/**
	 * Constructeur param�tr�
	 * 
	 * @param data Donn�es
	 */
	public SimpleTableManager(Collection<E> data){		
		super(data);
	}

}
