/**
 * 
 */
package com.sample.frame.fe.controller.crude;

import java.io.Serializable;
import com.sample.frame.core.entity.GenericEntity;

/**
 * @author lkamhoua
 *
 */
public abstract class BusinessEntityWrapper<E> extends GenericEntity {

    private static final long serialVersionUID = 1L;
	
    /**
     * Entité métier encapsulée niveau FE
     */
    private E wrappedEntity;	
	
    /**
     * Constructeur
     * @param wrappedEntity	: entité m�tier
     */
    public BusinessEntityWrapper(E wrappedEntity){
	super();
	this.wrappedEntity = wrappedEntity;	
    }

    public void setWrappedEntity(E wrappedEntity) {
    	this.wrappedEntity = wrappedEntity;
    }

    public E getWrappedEntity() {
	return wrappedEntity;
    }
	
    /**
     * 
     * @return Classe de l'entité wrappé
     */
    public Class<?> getWrappedEntityClass(){
	return (wrappedEntity != null ? wrappedEntity.getClass() : null);
    }
	
    /**
     * Définit la position de début de sélection de données dans le mécanisme de pagination
     * @param offset Position de d�but de s�lection de donn�es
     */
    public abstract void setOffset(long offset);
	
	
    /**
     * Définit le nombre maximun d'éléments à sélectionner dans le mécanisme de pagination
     * @param maxRow Nombre maximal d'éléments à sélectionner
     */
    public abstract void setMaxRow(int maxRow);
		
    public abstract Serializable getId() ;
	
}