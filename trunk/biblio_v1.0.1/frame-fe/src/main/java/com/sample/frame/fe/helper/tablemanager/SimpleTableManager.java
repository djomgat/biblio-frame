/**
 * 
 */
package com.sample.frame.fe.helper.tablemanager;

import java.util.Collection;

/**
 * Classe basique de gestion des tables / tableaux de données 
 * 
 *
 */
public class SimpleTableManager<E> extends AbstractListTableManager<E> {

    /**
     * Constructeur par défaut
     */
    public SimpleTableManager(){
	super();
    }
	
    /**
     * Constructeur paramétré
     * 
     * @param data Données
     */
    public SimpleTableManager(Collection<E> data){		
	super(data);
    }

}