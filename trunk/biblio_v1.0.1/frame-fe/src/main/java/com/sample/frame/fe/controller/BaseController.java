/**
 * 
 */
package com.sample.frame.fe.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import com.sample.frame.fe.helper.FacesUtil;

/**
 * Classe de base de tous les contrôleurs ou bean managés (managedbean) <br>
 * Fournit et implémente un ensemble d'attributs et méthodes abstraites et 
 * génériques pouvant être partagés par tout contrôleur.
 * 
 *
 */
public abstract class BaseController implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Constructeur par défaut
     */
    public BaseController(){
	super();
    }

/******************************************************************************
 * Getter & Setter 
 ******************************************************************************/
	
    /**
     * Retourne le nom du bean managé <br>
     * Par défaut c'est le nom de la classe avec la première lettre en minuscule
     * 
     * @return Nom du bean managé
     */
    public String getBeanName(){
	StringBuilder beanName = new StringBuilder(this.getClass().getSimpleName());
	beanName.replace(0, 1, beanName.substring(0, 1).toLowerCase());
	return beanName.toString();
    }
	
/*******************************************************************************
 * 
 * Life Cycle 
 * 
 *******************************************************************************/
	
    /**
     * Méthode de gestion du cycle de vie appelée après la création du bean <br/>
     * Implémentation par défaut vide afin de ne pas forcer la redéfintion
     */
    @PostConstruct
    public void postConstruct(){
	// Aucune impl�mentation par d�faut
    }
	
    /**
     * Méthode de gestion du cycle de vie appelée avant la destructiion du bean
     * Implémentation par défaut vide afin de ne pas forcer la redéfintion
     */
    @PreDestroy
    public void preDestroy(){
	// Aucune impl�mentation par d�faut
    }
		
/*******************************************************************************
 * Méthodes de présentation des différents types messages 
 *******************************************************************************/
	
    /**
     * 
     * @return L'id de la zone de présentation des messages; 
     * par défaut <code>null</code>
     */
    protected  String getIdMessageArea(){
	return null;
    }

    /**
     * Ajout d'un message de sévérité INFO
     * 
     * @param summary	Entête du message 
     * @param detail	Détails du message 
     */
    protected  void addInfoMessage(String summary,String detail){   
	FacesUtil.addInfoMessage(this.getIdMessageArea(), summary, detail);
    }	
	
    /**
     *Ajout d'un message de sévérité WARNING
     * 
     * @param summary	Entête du message 
     * @param detail	Détails du message 
     */
    protected  void addWarnMessage(String summary,String detail){    
	FacesUtil.addWarnMessage(this.getIdMessageArea(), summary, detail);
    }
	
    /***
     * Ajout d'un message de sévérité ERROR
     * 
     * @param summary	:Entête du message 
     * @param detail	:Détails du message 
     */
    protected  void addErrorMessage(String summary,String detail){
    	FacesUtil.addErrorMessage(this.getIdMessageArea(), summary, detail);
    }	

    /**
     * Ajout d'un message de sévérité FATAL
     * 
     * @param summary	:Entête du message 
     * @param detail	:Détails du message 
     */
    protected  void addFatalMessage(String summary,String detail){
        FacesUtil.addFatalMessage(this.getIdMessageArea(), summary, detail);
    }	
	
}