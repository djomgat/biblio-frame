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
	 * Entit� m�tier encapsul�e niveau FE
	 */
	private E wrappedEntity;
	
	
//	/**
//	 * Constructeur par d�faut
//	 */	
//	public BusinessEntityWrapper(){
//		super();
//	}

	/**
	 * Constructeur
	 * @param wrappedEntity	: entit� m�tier
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
	 * @return Classe de l'entit� wrapp�
	 */
	public Class<?> getWrappedEntityClass(){
		return (wrappedEntity != null ? wrappedEntity.getClass() : null);
	}
	
	
	/**
	 * D�finit la position de d�but de s�lection de donn�es dans le m�canisme de pagination
	 * @param offset Position de d�but de s�lection de donn�es
	 */
	public abstract void setOffset(long offset);
	
	
	/**
	 * D�finit le nombre maximun d'�l�ments � s�lectionner dans le m�canisme de pagination
	 * @param maxRow Nombre maximal d'�l�ments � s�lectionner
	 */
	public abstract void setMaxRow(int maxRow);
	
	
	
	public abstract Serializable getId() ;
	
	
}
