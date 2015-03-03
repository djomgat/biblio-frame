/**
 * 
 */
package com.sample.frame.fe.controller.crude;

import com.sample.frame.fe.enums.EnumEditionMode;
import com.sample.frame.fe.helper.tablemanager.ITableManager;

/**
 * Classe ViewHelper générique encapsulant les différents objets bindés sur des vues
 * 
 * @author lkamhoua
 *
 * @param <W> Wrapper d'une entité business (métier)
 */
public abstract class CrudeViewHelper<E extends CrudeBusinessEntityWrapper<?>>  {
	
/*********************************************************************************
 * Properties 
**********************************************************************************/
	
    /**
     * Instance du wrapper ne devant jamais être null
     */
    protected E wrapperInstance;
	
    /**
     * Entité bindée/liée à la vue de création
     */
    protected E entityToCreate;

    /**
     * Entité bindée/liée à la vue de modification
     */
    protected E entityToModify;
		
    /**
     * Entit� bindée/liée à la vue de consultation
     */
    protected E entityToDisplay;
	
    /**
     * Entité bindée/liée au critéres de recherche
     */
    protected E entityToSearch;
	
    /**
     * Gestionnaire des données (de la vue liste) <br>
     */
    protected ITableManager<E> dataManager;
		
    /**
     * Nom du contr�leur de s�lection
     * 
     */
    protected String selectionController;
	
    /**
     * R�gle de navigation de la vue s�lection
     * 
     */
    protected String selectionView;
	
    /**
     * Identifiant de la s�lection
     */
    protected String selectionId;
	
    /**
     * Critères de recherche pour la sélection locale sur une même vue
     */
    protected E selectionCriteria;
	
    /**
     * Gestionnaire de données pour la sélection locale sur une même vue
     */
    protected ITableManager<E> selectionDataManager;
	
    /**
     * Mode d'�dition (Creation, Modification)
     */
    protected EnumEditionMode editionViewMode;
		
/******************************************************************************************************************************************************************************
 * Constructeurs 
 ******************************************************************************************************************************************************************************/
	

    /**
     * Constructeur
     * 
     * @param wrapperInstance Instance (non nulle) d'un wrapper
     */
    @SuppressWarnings("unchecked")
    public CrudeViewHelper(E wrapperInstance){
	super();
	// Initialisation 
	this.wrapperInstance = wrapperInstance;
	this.setEntityToSearch((E) wrapperInstance.getTemplateForSearch());
	this.setSelectionCriteria((E) wrapperInstance.getTemplateForSearch());
    }

/********************************************************************************
 * Getters & Setters 
********************************************************************************/
	
    /**
     * @return the entityToCreate
     */
    public E getEntityToCreate() {
        if(entityToCreate == null)
            entityToCreate = (E)wrapperInstance.getNewInstance();
	return entityToCreate;
    }

    /**
     * @param entityToCreate the entityToCreate to set
     */
    public void setEntityToCreate(E entityToCreate) {
	this.entityToCreate = entityToCreate;
    }
	
    /**
     * @return the entityToModify
     */
    public E getEntityToModify() {
         if(entityToModify == null)
            entityToModify = (E)wrapperInstance.getNewInstance();
	return entityToModify;
    }

    /**
     * @param entityToModify the entityToModify to set
     */
    public void setEntityToModify(E entityToModify) {
	this.entityToModify = entityToModify;
    }
	
    /**
     * Retourne l'entité à éditer
     * @return
     */
    public E getEntityToEdit() {
	// En cr�ation l'on retourne l'entit� de cr�ation
	if(this.isEditionModeIsCreation()) return this.getEntityToCreate();
		
	// En modification l'on retourne l'entit� de modification
	if(this.isEditionModeIsModification()) return this.getEntityToModify();
		
	return this.getEntityToCreate();
    }

    /**
     * @return the entityToDisplay
     */
    public E getEntityToDisplay() {
	return entityToDisplay;
    }

    /**
     * @param entityToDisplay the entityToDisplay to set
     */
    public void setEntityToDisplay(E entityToDisplay) {
	this.entityToDisplay = entityToDisplay;
    }

    /**
     * @return the entityToSearch
     */
    public E getEntityToSearch() {
	return entityToSearch;
    }

    /**
     * @param entityToSearch the entityToSearch to set
     */
    public void setEntityToSearch(E entityToSearch) {
	this.entityToSearch = entityToSearch;
    }

    /**
     * @return the wrapperInstance
     */
    public E getWrapperInstance() {
	return wrapperInstance;
    }

    /**
     * @return the dataManager
     */
    public ITableManager<E> getDataManager() {
	System.out.println("CrudeViewHelper.getDataManager() - Data manager est surement null");
	return dataManager;
    }

    /**
     * @param dataManager the dataManager to set
     */
    public void setDataManager(ITableManager<E> dataManager) {
	this.dataManager = dataManager;
    }

    /**
     * @return the selectionController
     */
    public String getSelectionController() {
	return selectionController;
    }

    /**
     * @param selectionController the selectionController to set
     */
    public void setSelectionController(String selectionController) {
	this.selectionController = selectionController;
    }

    /**
     * @return the selectionId
     */
    public String getSelectionId() {
	return selectionId;
    }

    /**
     * @param selectionId the selectionId to set
     */
    public void setSelectionId(String selectionId) {
    	this.selectionId = selectionId;
    }

    /**
     * @return the selectionView
     */
    public String getSelectionView() {
	return selectionView;
    }

    /**
     * @param selectionView the selectionView to set
     */
    public void setSelectionView(String selectionView) {
	this.selectionView = selectionView;
    }
	
    /**
     * @return the selectionCriteria
     */
    public E getSelectionCriteria() {
	return selectionCriteria;
    }

    /**
     * @param selectionCriteria the selectionCriteria to set
     */
    public void setSelectionCriteria(E selectionCriteria) {
	this.selectionCriteria = selectionCriteria;
    }

    /**
     * @return the selectionDataManager
     */
    public ITableManager<E> getSelectionDataManager() {
	return selectionDataManager;
    }

    /**
     * @param selectionDataManager the selectionDataManager to set
     */
    public void setSelectionDataManager(ITableManager<E> selectionDataManager) {
    	this.selectionDataManager = selectionDataManager;
    }

    /**
     * @return the editionViewMode
     */
    public EnumEditionMode getEditionViewMode() {
        if(editionViewMode == null)
            editionViewMode = EnumEditionMode.CREATION;
	return editionViewMode;
    }

    /**
     * @param editionViewMode the editionViewMode to set
     */
    public void setEditionViewMode(EnumEditionMode editionViewMode) {
	this.editionViewMode = editionViewMode;
    }
	
    /**
     * Indique si le contexte d'édition est celui de la création
     * @return
     */
    public boolean isEditionModeIsCreation(){
	return EnumEditionMode.CREATION.equals(this.getEditionViewMode());
    }

    /**
     * Indique si le contexte d'édition est celui la modification
     * @return
     */
    public boolean isEditionModeIsModification(){
	return EnumEditionMode.MODIFICATION.equals(this.getEditionViewMode());
    }

    /**
     * M�thode d'initialisation des données de test
     */
    public abstract void initializeTestContext();
	
}