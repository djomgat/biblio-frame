/**
 * 
 */
package com.sample.frame.fe.controller.crude;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.FacesEvent;

import com.sample.frame.fe.controller.BaseController;
import com.sample.frame.fe.enums.EnumEditionMode;
import com.sample.frame.fe.enums.EnumViewType;
import com.sample.frame.fe.exception.DataValidationException;
import com.sample.frame.fe.exception.FrontEndException;
import com.sample.frame.fe.exception.NoDataFoundException;
import com.sample.frame.fe.exception.ServiceLocatorException;
import com.sample.frame.fe.helper.FacesUtil;
import com.sample.frame.fe.helper.tablemanager.ITableManager;

/**
 * TODO COMMENTER ICI 
 * 
 * @author lkamhoua
 * @since 2013-03-07 - 12:01
 */
public abstract class CrudeController<E extends CrudeBusinessEntityWrapper<?>> extends BaseController implements ICrudeController<E> {

	private static final long serialVersionUID = 1L;
	
/******************************************************************************************************************************************************************************
 * 
 * Properties 
 * 
 ******************************************************************************************************************************************************************************/
	
	
	/**
	 * Helper associ�e aux vues g�r�es par le controlleur <br>
	 * Encapsule essentiellement les donn�es bind�es ou li�es � la vue
	 */
	protected CrudeViewHelper<E> viewHelper;
	

/******************************************************************************************************************************************************************************
 * 
 * Constructor 
 * 
 ******************************************************************************************************************************************************************************/
	
	public CrudeController(){
		super();
	}
	

/******************************************************************************************************************************************************************************
 * 
 * ICRUDActions 
 * 
 ******************************************************************************************************************************************************************************/
	

	/**
	 * Action de cr�ation d'une nouvelle entit�
	 * 
	 * @return	La navigation vers la vue ad�quate (vue de cr�ation)
	 */
	@SuppressWarnings("unchecked")
	public String create(){	
		
		return  this.navigateToCreationView((E) this.getWrapperInstance().getTemplateForCreation());		
	}
	
	
	/**
	 * Action de cr�ation  d'une entit� par copie
	 * 
	 * @return	La navigation vers la page ad�quate (vue de cr�ation)
	 */
	@SuppressWarnings("unchecked")
	public String copy(){
		
		if(this.getCurrentEntity() != null) return  this.navigateToCreationView((E) this.getCurrentEntity().getTemplateForCopy());
		
		// Message d'erreur : TODO - Externaliser ce message
		this.addErrorMessage("", "La donnee a copier est nulle ou inexistante; bien vouloir en specifier une.");
		
		return null;
	}
	
	
	/**
	 * Action de modification d'une entit�
	 * 
	 * @return	La navigation vers la page ad�quate (vue de modification)
	 */
	public String modify(){
		
		return  this.navigateToModificationView((E) this.getCurrentEntity());						
	}
	

	/**
	 * Action d'affichage ou de consultation des infos d'une entit�
	 * 
	 * @return	La navigation vers la page ad�quate (vue de consultation)
	 */
	public String display(){
		
		return  this.navigateToDisplayView((E) this.getCurrentEntity());						
	}
	

	/**
	 * Action de suppression d'une entit�
	 * 
	 * @return	La navigation vers la page ad�quate
	 */
	public String delete(){

		String navigationRule = null;
		
		try {
			
			navigationRule = this.delete_(this.getCurrentEntity(), true);
						
		} 
		catch (FrontEndException e) {
			this.addErrorMessage("", e.getMessage());
		}
		
		return navigationRule;
	}
	
		
	/**
	 * TODO : S'assurer s'il n'est pas necessaire de sp�cialiser cette m�thode par IHM en lieu d'un g�n�rique
	 * Encapsule la logique de suppression d'une entit� quelque soit la vue
	 * 
	 * @param entity Entit� � supprimer
	 * @param displayMessage Si <code> True </code> affiche le message d'information
	 * 
	 * @return
	 * @throws FrontEndException
	 */
	@SuppressWarnings("unchecked")
	protected String delete_(E entity, boolean displayMessage) throws FrontEndException{
		
		// Suppression de l'entit� en BD
		E result = this.be_delete(entity);
		
		// La suppression a effectu� une mise � jour de la donn�e - TODO : Penser � tenir compte du contexte pour optimisation
		if(result != null){
			
			// MAJ de l'entit� parmi les donn�es de la vue liste au cas ou
			this.getViewHelper().getDataManager().replace(entity,result);
			
			// MAJ de l'entit� sur le formulaire de consultation au cas ou on y serait
			this.navigateToDisplayView(result);
		}
		
		// La suppression a �t� effective - TODO : Penser � tenir compte du contexte pour optimisation
		else{
			// Suppression de l'entit� parmi les donn�es de la vue liste au cas ou
			this.getViewHelper().getDataManager().remove(entity);
			
			// MAJ de l'entit� sur le formulaire de consultation au cas ou on y serait
			this.navigateToDisplayView((E) entity.getTemplateForDisplay());
		}
		
		 // Message d'informations
		 this.addInfoMessage("", "Suppression effectu�e avec succes");	// TODO : Externaliser  le message			 
	
		return 	null;
	}	

	
	/**
	 * M�thode de s�lection d'une donn�e dans un (modal) panel sans navigation
	 * 
	 * @return <code>null</code>
	 */
	public String selectOnPanel(){
		
		System.out.println("CrudeController.selectOnPanel()");

		// R�gle de navigation vers la vue � l'origine de la s�lection
		//String navigationRule = this.getViewHelper().getSelectionView();

		// Contr�leur (source) � l'origine de la s�lection
		ICrudeController<?> selectionController = (ICrudeController<?>) FacesUtil.findManagedBean(this.getViewHelper().getSelectionController());
				
		// Si le controleur n'existe pas alors pas de s�lection possible pour �viter les erreurs
		if(selectionController == null){
			// TODO : Il pourrait �tre utile d'informer l'utilisateur via un message de warning
			return null;
		}
				
		// Dans le cas d'une s�lection multiple 
		if(! this.getViewHelper().getSelectionDataManager().isSingleSelectionMode()){
			selectionController.setSelectedData(this.getViewHelper().getSelectionDataManager().getSelectedDatas());
		}
		
		// Dans les autres cas 
		else {
			selectionController.setSelectedData(this.getViewHelper().getSelectionDataManager().getSelectedData());
		}
		
		// R�initialisation des infos de s�lection
		this.resetSelectionContext();
		
		return null;
	}
	
	
	/**
	 * M�thode en charge de la s�lection des donn�es
	 * 
	 * @return La r�gle de navigation vers la vue adequate
	 */
	public String select(){
				
		// R�gle de navigation vers la vue � l'origine de la s�lection
		String navigationRule = this.getViewHelper().getSelectionView();
		
		System.out.println("CrudeController.select() - navigationRule : " + navigationRule);

		
		// Contr�leur (source) � l'origine de la s�lection
		ICrudeController<?> selectionController = (ICrudeController<?>) FacesUtil.findManagedBean(this.getViewHelper().getSelectionController());
				
		// Si le controleur n'existe pas alors pas de s�lection possible pour �viter les erreurs
		if(selectionController == null){
			// TODO : Il pourrait �tre utile d'informer l'utilisateur via un message de warning
			return null;
		}
		
		// Dans le cas d'une s�lection multiple sur la vue liste 
		if(this.isOnListView() && ! this.getViewHelper().getDataManager().isSingleSelectionMode()){
			selectionController.setSelectedData(this.getViewHelper().getDataManager().getSelectedDatas());
		}
		
		// Dans les autres cas 
		else {
			selectionController.setSelectedData(this.getCurrentEntity());
		}
		
		// R�initialisation des infos de s�lection
		this.resetSelectionContext();
		
		return navigationRule;
	}
	
	
	/**
	 * 
	 * @param destinationControllerName Nom du controleur de destination ou s'effectuera la s�lection
	 * @param selectionId				Identifiant de la s�lection
	 * @param currentView				R�gle de navigation de la vue � l'origine de la s�lection
	 * 
	 * @return
	 */
	public String select(String destinationControllerName, String selectionId, String currentView){
			
		System.out.println("CrudeController.select(String destinationControllerName, String selectionId, String currentView) - " + destinationControllerName + " - " + " - " + selectionId + " - " + currentView);
				
		// MAJ des infos  du contexte de s�lection
		this.getViewHelper().setSelectionController(destinationControllerName);		
		this.getViewHelper().setSelectionId(selectionId);
		this.getViewHelper().setSelectionView(currentView);
		
		if(this.getSelectionController() != null) {
			this.getSelectionController().getViewHelper().setSelectionController(this.getBeanName());
			this.getSelectionController().getViewHelper().setSelectionView(currentView);
		} 
	
		return null;
	}
	
	
	/**
	 * Recherche des donn�es pour une s�lection locale
	 * 
	 * @param evt
	 */
	public void searchForSelection(ActionEvent evt){
		
		try{
			search_(this.getViewHelper().getSelectionCriteria(), this.getViewHelper().getSelectionDataManager());	
		}
		catch(NoDataFoundException e){
			this.addWarnMessage("", e.getMessage());
		}		
		catch(FrontEndException e){
			this.addErrorMessage("", e.getMessage());
		}	
	}
	
	
	/**
	 * R�intialise les donn�es li�es au contexte de s�lection
	 */
	protected void resetSelectionContext(){
		
		System.out.println("CrudeController.resetSelectionContext()");
		
		this.getViewHelper().setSelectionController(null);
		this.getViewHelper().setSelectionView(null);
		this.getViewHelper().setSelectionId(null);
	}
	
	
/******************************************************************************************************************************************************************************
 * 
 * ICrudeController Contract : M�thodes communes au contr�leur Crude
 * 
 ******************************************************************************************************************************************************************************/


	/**
	 * Mets � jour des donn�es suite � une s�lection <br>
	 * Devra en g�n�ral �tre au besoin red�finie
	 * 
	 * @param e Donn�e s�lectionn�e
	 * @return La r�gle de navigation vers la vue ad�quate
	 */	
	@Override
	public void setSelectedData(CrudeBusinessEntityWrapper<?> e){
		
		// Impl�mentation par d�faut - aucune action
	}
	
	
	/**
	 * Mets � jour des donn�es suite � une s�lection <br>
	 * Devra en g�n�ral �tre au besoin red�finie
	 * 
	 * @param l Donn�es s�lectionn�es
	 * @return La r�gle de navigation vers la vue ad�quate
	 */
	@Override
	public void setSelectedData(Collection<? extends CrudeBusinessEntityWrapper<?>> l){
		
		// Impl�mentation par d�faut - aucune action		
	}

	
/******************************************************************************************************************************************************************************
 * 
 * Navigation logic to the same controller's views
 * 
 ******************************************************************************************************************************************************************************/
	

	/**
	 * Encapsule la logique de navigation ou d'acc�s � la vue de cr�ation / d'ajout <br>
	 * Par d�faut effectue la navigation vers la vue d'�dition en mode cr�ation 
	 * 
	 * @param entity Entit� � cr�er
	 * @return	La r�gle de navigation vers la vue ad�quate (vue de cr�ation)
	 */	
	public String navigateToCreationView(E entity){
				
		return this.navigateToEditionView(entity, EnumEditionMode.CREATION);
	}


	/**
	 * Encapsule la logique de navigation ou d'acc�s � la vue de modification <br>
	 * Par d�faut effectue la navigation vers la vue d'�dition en mode modification 
	 * 
	 * @param entity Entit� � modifier
	 * @return
	 */		
	public String navigateToModificationView(E entity){

		return this.navigateToEditionView(entity, EnumEditionMode.MODIFICATION);
	}
	
	
	/**
	 * Encapsule la logique de navigation ou d'acc�s vers la vue d'�dition (cr�ation ou modification)
	 * 
	 * @param entity		Entit� � �diter
	 * @param editionMode 	Mode d'�dition (Create, Modify, ... )
	 * 
	 * @return
	 */
	public String navigateToEditionView(E entity, EnumEditionMode editionViewMode){
		
		// Si la donn�e est nulle
		if(entity == null){
			
			// TODO Message d'informations
			
			return null;
		}
	
		// MAJ du contexte d'�dition
		this.getViewHelper().setEditionViewMode(editionViewMode);
		
		// Si nous sommes en mode cr�ation
		if(EnumEditionMode.CREATION.equals(editionViewMode)){
						
			// MAJ de l'entit� bind�e sur la vue
			this.getViewHelper().setEntityToCreate(entity);
			
			// Navigation
			return this.getNavigationRuleToCreationView();
		}
		
		// Si nous sommes en mode modification
		else if(EnumEditionMode.MODIFICATION.equals(editionViewMode)){

			// MAJ de l'entit� bind�e sur la vue
			this.getViewHelper().setEntityToModify(entity);
			
			// Navigation
			return this.getNavigationRuleToModificationView();
		}
		
		return null;
	}
	
	/**
	 * Encapsule la logique de navigation ou d'acc�s � la vue de consultation
	 * 
	 * @param entity Entit� � afficher/consulter
	 * @return
	 */
	public String navigateToDisplayView(E entity){
				
		// MAJ de l'entit� bind�e sur la vue
		this.getViewHelper().setEntityToDisplay(entity);
		
		// Navigation
		return this.getNavigationRuleToDisplayView();
	}	

	
	/**
	 * Encapsule la logique de navigation ou d'acc�s � la vue de liste
	 * 
	 * @return La r�gle de navigation vers la vue de liste
	 */
	public String navigateToListView(){

		return this.getNavigationRuleToListView();
	}	

	
	/**
	 * Encapsule la logique de navigation ou d'acc�s � la vue de liste
	 * 
	 * @param criteria
	 * @return
	 */
	public String navigateToListView(E criteria){
		
		// Maj des crtit�res
		this.getViewHelper().setEntityToSearch(criteria);
		
		// Recherche des donn�es	
		try {
			this.search_(criteria, this.getViewHelper().getDataManager());
		} 
		catch(NoDataFoundException e){
			this.addWarnMessage("", e.getMessage());
		}		
		catch(FrontEndException e){
			this.addErrorMessage("", e.getMessage());
		}	
				
		return this.navigateToListView();
	}	
	
	
	@Override
	public String navigateToSelectionView(String selectionController, String selectionView) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	public String navigateToSelectionView() {
		return this.navigateToListView();
	}
	
	
	/**
	 * Encapsule la logique de navigation ou d'acc�s � la page d'acceuil de l'entit�
	 * 
	 * @return La r�gle de navigation vers la vue appropri�e
	 */
	public String navigateToLocalHomeView(){
		
		return getNavigationRuleToLocalHomeView();
	}

/******************************************************************************************************************************************************************************
 * 
 * ICoreViewContract 
 * 
 ******************************************************************************************************************************************************************************/
	
	
	
	
/******************************************************************************************************************************************************************************
 * 
 * IListViewContract 
 * 
 ******************************************************************************************************************************************************************************/
	

	/**
	 * Recherche des donn�es sur la vue de liste
	 * 
	 * @param evt
	 */
	public void search(ActionEvent evt){
		try{
			System.out.println("CrudeController.search() - J'ai lancé le search");
			search_(this.getViewHelper().getEntityToSearch(), this.getViewHelper().getDataManager());	
		}
		catch(NoDataFoundException e){
			this.addWarnMessage("", e.getMessage());
		}		
		catch(FrontEndException e){
			this.addErrorMessage("", e.getMessage());
		}	
	}
	

	
	/**
	 * Encapsule la logique de recherche des donn�es avec ou sans pagination
	 *  
	 * @param criteria Crit�re de recherche
	 * @param dataManager Gestionnaire de donn�es � mettre � jour
	 * @param paginationStep Pas de pagination. S'il est <= 0, la pagination n'est pas int�gr�e.
	 * 
	 * @throws NoDataFoundException
	 * @throws FrontEndException
	 */
	protected void search_(E criteria, ITableManager<E> dataManager, int paginationStep) throws NoDataFoundException, FrontEndException{
				
		boolean paginate = (paginationStep > 0 ? true : false);
		
		Collection<E> dataList = null;
		
		long dataSize = 0;
					
		// D�sactivation de la pagination
		criteria.setOffset(-1);
		criteria.setMaxRow(-1);
		
		if(paginate){
			// Comptage du nombre d'�lements
			dataSize = this.be_countByExample(criteria);

			// D�finition de la plage pour la pagination
			criteria.setOffset(1);
			criteria.setMaxRow(paginationStep);
		}
		
		// Recherche des donn�es
		dataList = this.be_findByExample(criteria);
		
		// MAJ des donn�es
		dataManager.setData(dataList);
		
		// MAJ infos de pagination
		dataManager.setPaginationInfos(dataSize, paginationStep);			

		
		// Si la liste de recherche est vide, pr�cisez que la recherche n'a retourn� aucun r�sultat
		if(dataList == null || dataList.isEmpty()){
			throw new NoDataFoundException("Aucune donn�e n'a �t� retrouv�e"); // TODO G�rer les messages en configuration
		} 			
	}	
	
	
	/**
	 * Encapsule la logique de recherche des donn�es avec ou sans pagination <br>
	 * Le pas de pagination est celui du gestionnaire de donn�es
	 * 
	 * @param criteria Crit�re de recherche
	 * @param dataManager Gestionnaire de donn�es � mettre � jour
	 * 
	 * @throws NoDataFoundException
	 * @throws FrontEndException
	 */
	protected void search_(E criteria, ITableManager<E> dataManager) throws NoDataFoundException, FrontEndException{
		this.search_(criteria, dataManager, dataManager.getPaginationStep());
	}	

	
	/**
	 * Pagination sur la vue de liste <br/>
	 * Peut �tre associ� � plusieurs types d'�v�nements (ActionEvent, ValueChangeEvent, AjaxBehaviorEvent, ...)
	 * 
	 * @param evt : Ev�nement de type FacesEvent 
	 */
	public void paginate(FacesEvent evt){
		
		try{
			this.paginate_(this.getViewHelper().getEntityToSearch(), this.getViewHelper().getDataManager());
		}
		catch(NoDataFoundException e){
			this.addWarnMessage("", e.getMessage());
		}		
		catch(FrontEndException e){
			this.addErrorMessage("", e.getMessage());
		}	
	}

	
	/**
	 * Encapsule la logique de pagination des donn�es <br>
	 * Le pas de pagination est celui du gestionnaire de donn�es
	 * 
	 * @param criteria Crit�re de recherche
	 * @param dataManager Gestionnaire de donn�es � mettre � jour
	 * 
	 * @throws NoDataFoundException
	 * @throws FrontEndException
	 */
	protected void paginate_(E criteria, ITableManager<E> dataManager) throws NoDataFoundException, FrontEndException{
		
		// D�finition de la plage pour la pagination
		criteria.setOffset(dataManager.getOffset());
		criteria.setMaxRow(dataManager.getPaginationStep());
	
		// Recherche des donn�es
		Collection<E> dataList = this.be_findByExample(criteria);
		
		// MAJ des donn�es
		dataManager.setData(dataList);
				
		// Si la liste de recherche est vide, pr�cisez que la recherche n'a retourn� aucun r�sultat
		if(dataList == null || dataList.isEmpty()){
			throw new NoDataFoundException("Aucune donn�e n'a �t� retrouv�e"); // TODO G�rer les messages en configuration
		} 					
	}	
	
	
	/**
	 * R�initialise les crit�res de recherche (sur la vue de liste)
	 * 
	 * @param evt
	 */
	@SuppressWarnings("unchecked")
	public void initializeCriteria(ActionEvent evt){
		this.getViewHelper().setEntityToSearch((E) this.getWrapperInstance().getTemplateForSearch());
	}		

	/**
	 * Ferme et quitte la vue liste <br/>
	 * Redirige vers le homepage local s'il est diff�rent du formulaire liste sinon vers le homepage global
	 * 
	 * @return Par d�faut redirige le homepage local s'il est diff�rent
	 */
	public String closeListView(){
		
		// R�gle de navigation
		String navigationRule = null;
		
		navigationRule = (this.getNavigationRuleToLocalHomeView().equals(this.getNavigationRuleToListView())) ? this.getNavigationRuleToHomeView() : this.navigateToLocalHomeView(); 
				
		return navigationRule;
	}

	
/******************************************************************************************************************************************************************************
 * 
 * IDisplayViewContract : 
 * 
 ******************************************************************************************************************************************************************************/
	
	/****
	 * Affiche en consultation le premier �lement de la liste des donn�es disponibles  
	 * 
	 * @param evt
	 */	
	public void  displayFirst(ActionEvent evt){
			
		// Nombre d'�lements
		int size = this.getViewHelper().getDataManager().getSize();
		
		// S'il y'a au moins 1 element
		if(size > 1){
									
			// Affichage de l'entit�
			this.navigateToDisplayView(this.getViewHelper().getDataManager().getFirst());			
		}				
	}	
	
	/****
	 * Affiche en consultation le dernier �lement de la liste des donn�es disponibles  
	 * 
	 * @param evt
	 */	
	public void  displayLast(ActionEvent evt){
				
		// Nombre d'�lements
		int size = this.getViewHelper().getDataManager().getSize();
		
		// S'il y'a au moins 1 element
		if(size > 1){
					
			// Affichage de l'entit�
			this.navigateToDisplayView(this.getViewHelper().getDataManager().getLast());			
		}				

	}		
	
	
	/****
	 * Affiche en consultation l'element suivant relativement � l'element courant 
	 * 
	 * @param evt
	 */	
	public void displayNext(ActionEvent evt){

		// Nombre d'�lements de la liste
		int size = this.getViewHelper().getDataManager().getSize();
		
		// S'il y'a au moins 1 element	et que l'element courant est contenu dans la liste
		if(size > 1 && this.getViewHelper().getDataManager().contains(this.getViewHelper().getEntityToDisplay())){
						
			// Affichage de l'entit�
			this.navigateToDisplayView(this.getViewHelper().getDataManager().getNext(this.getViewHelper().getEntityToDisplay()));			
		}		
	}	
	
	
	/****
	 * Affiche en consultation l'element pr�c�dent relativement � l'element courant 
	 * 
	 * @param evt
	 */	
	public void displayPrevious(ActionEvent evt){
				
		// Nombre d'�lements de la liste
		int size = this.getViewHelper().getDataManager().getSize();
		
		// S'il y'a au moins 1 element	et que l'element courant est contenu dans la liste
		if(size > 1 && this.getViewHelper().getDataManager().contains(this.getViewHelper().getEntityToDisplay())){
						
			// Affichage de l'entit�
			this.navigateToDisplayView(this.getViewHelper().getDataManager().getPrevious(this.getViewHelper().getEntityToDisplay()));			
		}			
	}			
	
	
	/**
	 * Ferme et quitte le formulaire de consultation
	 * 
	 * @return Par d�faut redirige vers la vue liste
	 */
	public String closeDisplayView(){
		
		return this.navigateToListView();
	}
	
	
/******************************************************************************************************************************************************************************
 * 
 * IEditionViewContract : ICreationViewContract & IModificationViewContract
 * 
 ******************************************************************************************************************************************************************************/
	
	
	/**
	 * Effectue la validation des donn�es d'une entit� � enregistrer (en cr�ation ou modification) <br>
	 * Par d�faut aucun controle n'est effectu�
	 * 
	 * @param entity
	 * @throws DataValidationException
	 */
	protected  void validateData(E entity) throws DataValidationException{
		// Validation par d�faut : aucun controle
	}

	
	/**
	 * Enregistre une entit� cr��e <br>
	 * 
	 * @param entity Donn�e a enregistr�e
	 * @param displayMessage Si <code>true</code> affiche le message de succ�s de l'enregistrement
	 * @return
	 * @throws FrontEndException
	 */
	protected E saveCreation(E entity, boolean displayMessage) throws FrontEndException{
					
		// Validation des donn�es
		this.validateData(entity);
										 
		// Enregistrement de l'entit�
		entity = this.be_persist(entity);
		 
		if(displayMessage){
			// Message d'informations
			this.addInfoMessage("", "Cr�ation effectu�e avec succ�s");	// TODO : Externaliser ou Sp�cialiser le message			
		}
		 		
		return entity;
	}
	
	
	/**
	 * Enregistre une entit� modifi�e <br>
	 * 
	 * @param entity 			Donn�e � enregistrer
	 * @param displayMessage 	Si <code>true</code> affiche le message de succ�s de l'enregistrement
	 * @return
	 * @throws FrontEndException
	 */
	protected E saveModification(E entity, boolean displayMessage) throws FrontEndException{
					
		// Validation des donn�es
		this.validateData(entity);
										 
		// Enregistrement de l'entit�
		entity = this.be_update(entity);
		 
		if(displayMessage){
			// Message d'informations
			this.addInfoMessage("", "Modification effectu�e avec succ�s");	// TODO : Externaliser ou Sp�cialiser le message			
		}
		 		
		return entity;
	}
	

	/**
	 * Enregistre une entit� �dit�e (cr��e ou modifi�e)  <br>
	 * 
	 * @param entity 			Donn�e � enregistrer
	 * @param displayMessage 	Si <code>true</code> affiche le message de succ�s de l'enregistrement
	 * @return
	 * @throws FrontEndException
	 */
	protected E saveEdition(E entity, boolean displayMessage) throws FrontEndException{
		
		// Si nous sommes en cr�ation
		if(this.getViewHelper().isEditionModeIsCreation()) return this.saveCreation(entity, displayMessage);
		
		// Si nous sommes en modification
		if(this.getViewHelper().isEditionModeIsModification()) return this.saveModification(entity, displayMessage);
		
		throw new FrontEndException("Les donn�es n'ont pu �tre enregistr�es");
	}
	
	
	/**
	 * Enregistre une entit� �dit�e (cr��e ou modifi�e) <br>
	 * Apr�s enregistrement l'entit� est affich�e en consultation
	 * 
	 * @return Redirige vers la vue de consultation
	 */
	public String saveEditionAndDisplay(){
		
		// R�gle de navigation
		String navigationRule = null;
		
		try{
			
			// Enregistrement de l'entit�
			E entity = this.saveEdition(this.getViewHelper().getEntityToEdit(), true);
			 			 
			// Consultation des donn�es l'entit�
			navigationRule = this.navigateToDisplayView(entity);
			
		}
		catch(DataValidationException e){
			this.addWarnMessage("", e.getMessage());
		}	
		catch(FrontEndException e){
			this.addErrorMessage("", e.getMessage());
		}
		
		return navigationRule;
	}
	
	
	/**
	 * Enregistre une entit� �dit�e (cr��e ou modifi�e)  <br>
	 * Et positionne a nouveau dans un contexte de cr�ation simple
	 * 
	 * @return Redirige vers la vue de cr�ation
	 */
	@SuppressWarnings("unchecked")
	public String saveEditionAndCreate(){
		
		String navigationRule = null;
		
		try{
			
			// Enregistrement de l'entit�
			E entity = this.saveEdition(this.getViewHelper().getEntityToEdit(), true);
			 			
			// Pr�sentation de la vue de nouveau en mode cr�ation simple
			this.navigateToCreationView((E) entity.getTemplateForCreation());

		}
		catch(DataValidationException e){
			this.addWarnMessage("", e.getMessage());
		}	
		catch(FrontEndException e){
			this.addErrorMessage("", e.getMessage());
		}
		
		return navigationRule;
	}	
	
	
	/**
	 * Enregistre une entit� �dit�e (cr��e ou modifi�e)  <br>
	 * Et positionne a nouveau dans un contexte de cr�ation par copie
	 * 
	 * @return Redirige vers la vue de cr�ation
	 */
	@SuppressWarnings("unchecked")
	public String saveEditionAndCopy(){
		
		String navigationRule = null;
		
		try{
			
			// Enregistrement de l'entit�
			E entity = this.saveEdition(this.getViewHelper().getEntityToEdit(), true);
			 			
			// Pr�sentation de la vue de nouveau en mode cr�ation simple
			this.navigateToCreationView((E) entity.getTemplateForCopy());

		}
		catch(DataValidationException e){
			this.addWarnMessage("", e.getMessage());
		}	
		catch(FrontEndException e){
			this.addErrorMessage("", e.getMessage());
		}
		
		return navigationRule;
	}
	
	
	
	/**
	 * Annule un processus de cr�ation ou de modification
	 * 
	 * @return Redirige vers la vue liste par d�faut
	 */
	public String cancelEdition(){
		
		return this.navigateToListView();
	}
	
	
/******************************************************************************************************************************************************************************
 * 
 * Getters & Setters 
 * 
 ******************************************************************************************************************************************************************************/

	/**
	 * @return the viewHelper
	 */
	public CrudeViewHelper<E> getViewHelper() {
		return viewHelper;
	}


	/**
	 * @param viewHelper the viewHelper to set
	 */
	public void setViewHelper(CrudeViewHelper<E> viewHelper) {
		this.viewHelper = viewHelper;
	}
	
	/**
	 * Retourne le contr�leur de s�lection
	 * 
	 * @return
	 */
	public CrudeController<?> getSelectionController(){
		
		Object selectionController = FacesUtil.findManagedBean(this.getViewHelper().getSelectionController());
		
		if(selectionController instanceof CrudeController) return (CrudeController<?>) selectionController;
			
		return this;		
	}

	/**
	 * Retourne l'entit� courante relativement � la vue courante
	 * 
	 * @return l'entit� courante sinon <code>null</code>
	 */
	public  E getCurrentEntity(){
		
		// Entit� courante
		E current = null;
		
		// Si la vue courante est la vue de liste
		if(this.isOnListView())				current = this.getViewHelper().getDataManager().getSelectedData();
		
		// Si la vue courante est la vue de consultation
		else if(this.isOnDisplayView())		current = this.getViewHelper().getEntityToDisplay();
	
		// Si la vue courante est la vue d'edition
		else if(this.isOnEditionView())		current = this.getViewHelper().getEntityToEdit();

		// Si la vue courante est la vue de cr�ation
		else if(this.isOnCreationView())	current = this.getViewHelper().getEntityToCreate();
		
		// Si la vue courante est la vue de modification
		else if(this.isOnModificationView()) current = this.getViewHelper().getEntityToModify();
		
		System.out.println("CrudeController.getCurrentEntity() : " + current);
		
		return current;
	}

	/**
	 * Indique si la vue courante est la vue liste
	 * 
	 * @return <code>True</code> si la vue courante est la vue de liste sinon <code>False</code>
	 */
	protected boolean isOnListView(){
		
		return this.isOnView(this.getNavigationRuleToListView());
	}
	
	
	/**
	 * Indique si la vue courante est la vue de consultation
	 * 
	 * @return <code>True</code> si la vue courante est la vue de consultation sinon <code>False</code>
	 */
	protected boolean isOnDisplayView(){
		
		return this.isOnView(this.getNavigationRuleToDisplayView());
	}
	
	
	/**
	 * Indique si la vue courante est la vue de cr�ation
	 * 
	 * @return <code>True</code> si la vue courante est la vue de cr�ation sinon <code>False</code>
	 */
	protected boolean isOnCreationView(){
		
		return this.isOnView(this.getNavigationRuleToCreationView());
	}	
	
	
	/**
	 * Indique si la vue courante est la vue de modification
	 * 
	 * @return <code>True</code> si la vue courante est la vue de modification sinon <code>False</code>
	 */
	protected boolean isOnModificationView(){
		
		return this.isOnView(this.getNavigationRuleToModificationView());
	}	
	
	
	/**
	 * Indique si la vue courante est la vue d'edition (cr�ation ou modification)
	 * 
	 * @return <code>True</code> si la vue courante est la vue de modification sinon <code>False</code>
	 */
	protected boolean isOnEditionView(){
		
		return this.isOnView(this.getNavigationRuleToEditionView());
	}	
	
	
	/**
	 * Indique si la vue pass�e en param�tre est la  vue courante 
	 * 
	 * @param view un identifiant de la vue (r�gle de navigation, type, ...)
	 * @return
	 */
	protected boolean isOnView(String view){
		
		// Id de la vue courante
		String viewId = FacesContext.getCurrentInstance().getViewRoot().getViewId();
		
		System.out.println("CrudeController.isOnView() : viewId = " + viewId + " - view = " + view);
		
		// Si l'ID est null ou vide alors on retourne false
		if(viewId == null || viewId.trim().isEmpty() || view == null || view.trim().isEmpty()) return false;
		
		return (viewId.indexOf( view + ".") > -1);
		
	}

	/**
	 * Retourne une instance non null du wrapper
	 * 
	 * @return
	 */
	protected E getWrapperInstance(){
		return this.getViewHelper().getWrapperInstance();
	}
	
/******************************************************************************************************************************************************************************
 * 
 * Navigation Rules 
 * 
 ******************************************************************************************************************************************************************************/
	
	/**
	 * Getter de la r�gle de navigation vers d'un type de vue
	 * 
	 * @param viewType Type de vue
	 * @return
	 */
	public String getNavigationRule(EnumViewType viewType){
		
		return getNavigationRule(viewType.getValue());
	}
	
	
	/**
	 * Getter de la r�gle de navigation d'un type de vue
	 * 
	 * @param 	viewType Type de la vue
	 * @return	viewType + nom court de la donn�e ( Ex : listUser, displayUser, editUser, createUser, modifyUser, ...) 
	 */
	public String getNavigationRule(String viewType){
		
		String navigationRule = null;
		
		viewType = (viewType == null) ? "" : viewType.trim();
		
		StringBuilder builder = new StringBuilder(viewType.toLowerCase());
		
		navigationRule = builder.append(this.getWrapperInstance().getShortCutName()).toString();
				
		return navigationRule;
	}
	
	/**
	 * Getter de la r�gle de navigation vers la vue de consultation
	 * @return
	 */
	public String getNavigationRuleToDisplayView(){
		
		return this.getNavigationRule(EnumViewType.DISPLAY);
	}
	
	/**
	 * Getter de la r�gle de navigation vers la vue de cr�ation
	 * @return Par d�faut c'est la vue d'�dition
	 */
	public String getNavigationRuleToCreationView(){
		
		return this.getNavigationRuleToEditionView();
	}
	
	/**
	 * Getter de la r�gle de navigation vers la vue de modification
	 * @return Par d�faut c'est la vue d'�dition
	 */
	public String getNavigationRuleToModificationView(){
		
		return this.getNavigationRuleToEditionView();
	}
	
	
	/**
	 * Getter de la r�gle de navigation vers la vue d'edition
	 * @return
	 */
	public String getNavigationRuleToEditionView(){
		
		return this.getNavigationRule(EnumViewType.EDITION);
	}
	
	
	/**
	 * Getter de la r�gle de navigation vers la vue liste
	 * @return
	 */
	public String getNavigationRuleToListView(){
		
		return this.getNavigationRule(EnumViewType.LIST);
	}
	
	/**
	 * Getter de la r�gle de navigation vers la vue d'acceuil de l'entit�
	 * 
	 * @return Par d�faut la r�gle de navigation vers le vue de liste
	 */
	public String getNavigationRuleToLocalHomeView(){
		
		return this.getNavigationRuleToListView();
	}
		

	/**
	 * Getter de la r�gle de navigation vers la vue d'acceuil de l'application
	 * 
	 * @return <code>home</code> comme par valeur d�faut
	 */
	public String getNavigationRuleToHomeView(){
		
		return "home";
	}

/******************************************************************************************************************************************************************************
 * 
 * BE Methods Encapsulation 
 * 
 ******************************************************************************************************************************************************************************/	

	/**
	 * Retourne l'interface de service en charge de la gestion de l'entit�
	 * @return
	 */
	protected abstract Object getBusinessService() throws ServiceLocatorException;

	/**
	 * 
	 * @param entity
	 * @return
	 * @throws FrontEndException
	 */
	protected abstract E be_persist(E entity) throws FrontEndException;
	
	
	/**
	 * 
	 * @param entity
	 * @return
	 * @throws FrontEndException
	 */
	protected abstract E be_update(E entity) throws FrontEndException;
	
	
	/**
	 * 
	 * @param entity
	 * @return
	 * @throws FrontEndException
	 */
	protected abstract E be_delete(E entity) throws FrontEndException;
	
			
	/**
	 * 
	 * @param entity
	 * @return
	 * @throws FrontEndException
	 */
	protected abstract long be_countByExample(E entity) throws FrontEndException;
	
	/**
	 * 
	 * @param Id
	 * @return
	 * @throws FrontEndException
	 */
	protected abstract E be_findById(Serializable Id) throws FrontEndException;
	
	
	/**
	 * 
	 * @param entity
	 * @return
	 * @throws FrontEndException
	 */
	protected abstract List<E> be_findByExample(E entity) throws FrontEndException;

		
	/**
	 * 
	 * @param entity
	 * @return
	 * @throws FrontEndException
	 */
	protected abstract List<E> be_findAll(E entity) throws FrontEndException;
	
	
/******************************************************************************************************************************************************************************
 * 
 * Life Cycle 
 * 
 ******************************************************************************************************************************************************************************/
	
	@Override
	@PostConstruct
	public void postConstruct() {
		System.out.println("CrudeController.postConstruct() : " + this.getBeanName());
		
		// Initialisation du contexte de test
		if(true){
			this.getViewHelper().initializeTestContext();
		}
	}
	
}
