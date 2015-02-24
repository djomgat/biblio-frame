/**
 * 
 */
package com.sample.frame.fe.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import com.sample.frame.fe.helper.FacesUtil;





/**
 * Classe de base de tous les contr�leurs ou bean manag�s (managedbean) <br>
 * Fournit et impl�mente un ensemble d'attributs et m�thodes abstraites et g�n�riques pouvant �tre partag�s par tout contr�leur.
 * 
 *
 */
public abstract class BaseController implements Serializable {

	
	private static final long serialVersionUID = 1L;
	

/******************************************************************************************************************************************************************************
 * 
 * Constructor 
 * 
 ******************************************************************************************************************************************************************************/

	/**
	 * Constructeur par d�faut
	 */
	public BaseController(){
		super();
	}
	

/******************************************************************************************************************************************************************************
 * 
 * Getter & Setter 
 * 
 ******************************************************************************************************************************************************************************/
	
	/**
	 * Retourne le nom du bean manag� <br>
	 * Par d�faut c'est le nom de la classe avec la premi�re lettre en minuscule
	 * 
	 * @return Nom du bean manag�
	 */
	public String getBeanName(){
		
		StringBuilder beanName = new StringBuilder(this.getClass().getSimpleName());
		
		beanName.replace(0, 1, beanName.substring(0, 1).toLowerCase());
				
		return beanName.toString();
	}
	
	
	
/******************************************************************************************************************************************************************************
 * 
 * Life Cycle 
 * 
 ******************************************************************************************************************************************************************************/
	
	/**
	 * M�thode de gestion du cycle de vie appel�e apr�s la cr�ation du bean <br/>
	 * Impl�mentation par d�faut vide afin de ne pas forcer la red�fintion
	 */
	@PostConstruct
	public void postConstruct(){
		// Aucune impl�mentation par d�faut
	}
	
	/**
	 * M�thode de gestion du cycle de vie appel�e avant la destructiion du bean
	 * Impl�mentation par d�faut vide afin de ne pas forcer la red�fintion
	 */
	@PreDestroy
	public void preDestroy(){
		// Aucune impl�mentation par d�faut
	}
	
		
/******************************************************************************************************************************************************************************
 * 
 * M�thodes de pr�sentation des diff�rents types m�ssages 
 * 
 ******************************************************************************************************************************************************************************/
	
	/**
	 * 
	 * @return L'id de la zone de pr�sentation des messages; par d�faut <code>null</code>
	 */
	protected  String getIdMessageArea(){
		return null;
	}
	
	
	/**
	 * Ajout d'un message de s�v�rit� INFO
	 * 
	 * @param summary	Ent�te du message 
	 * @param detail	D�tails du message 
	 */
	protected  void addInfoMessage(String summary,String detail){   
		
		FacesUtil.addInfoMessage(this.getIdMessageArea(), summary, detail);
	}	
	
	/**
	 *Ajout d'un message de s�v�rit� WARNING
	 * 
	 * @param summary	Ent�te du message 
	 * @param detail	D�tails du message 
	 */
	protected  void addWarnMessage(String summary,String detail){    
		
		FacesUtil.addWarnMessage(this.getIdMessageArea(), summary, detail);
	}
	
	/***
	 * Ajout d'un message de s�v�rit� ERROR
	 * 
	 * @param summary	:	Ent�te du m�ssage 
	 * @param detail	:	D�tails du message 
	 */
	protected  void addErrorMessage(String summary,String detail){
        
		FacesUtil.addErrorMessage(this.getIdMessageArea(), summary, detail);
	}	

	/**
	 * Ajout d'un message de s�v�rit� FATAL
	 * 
	 * @param summary	:	Ent�te du m�ssage 
	 * @param detail	:	D�tails du message 
	 */
	protected  void addFatalMessage(String summary,String detail){
        
		FacesUtil.addFatalMessage(this.getIdMessageArea(), summary, detail);
	}	
	
}
