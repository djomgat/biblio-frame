/**
 * 
 */
package com.sample.frame.fe.helper.tablemanager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.model.SelectItem;


/**
 * Classe abstraite de gestion des tables / tableaux de données 
 * 
 */
public  class AbstractListTableManager<E> implements ITableManager<E> {
	
/******************************************************************************************************************************************************************************
 * 
 * Properties 
 * 
 ******************************************************************************************************************************************************************************/

	/**
	 * Liste des données
	 */
	protected List<E> data = new ArrayList<E>();
		
	/**
	 * Liste des donn�es s�lectionn�es
	 */
	protected List<E> selectedDatas = new ArrayList<E>();

	/**
	 * Donnée sélectionnée
	 */
	protected E selectedData;
	
	/**
	 * Mode de sélection (simple ou multiple)
	 */
	protected String selectionMode = EnumSelectionMode.SINGLE.getValue();
	
	/**
	 * Pas de pagination
	 */
	protected int paginationStep = 100;
	
	/**
	 * N° de Page de la pagination
	 */
	protected int paginationPage = 1;

	/**
	 * Liste des pages de pagination 
	 */
	protected  List<SelectItem> paginationPageList = new ArrayList<SelectItem>();
	
	
	/**
	 * Nombre total des donn�es sans pagination
	 */
	protected long totalSize;
	
/******************************************************************************************************************************************************************************
 * 
 * Constructor 
 * 
 ******************************************************************************************************************************************************************************/
	
	/**
	 * Constructeur par d�faut
	 */
	public AbstractListTableManager(){
		
	}
	
	/**
	 * Constructeur paramétré
	 * 
	 * @param data Données
	 */
	public AbstractListTableManager(Collection<E> data){		
		this.setData(data);
	}	
	
/******************************************************************************************************************************************************************************
 * 
 * Getter & Setter & Overriden Methods 
 * 
 ******************************************************************************************************************************************************************************/
		
	@Override
	public void setData(Collection<E> data) {	
		
		data = (data == null)?  new ArrayList<E>() : data;		
		this.data = new ArrayList<E>(data);	
	}
	
	@Override
	public List<E> getData() {
		return this.data;
	}

	@Override
	public boolean contains(E e) {

		// Index 
		int index = this.getIndexOf(e);
		
		// Si l'index est valide l'on retourne true
		if (0 <= index && index < this.getSize() ) return true;
		
		// Sinon false
		return false;
	}

	@Override
	public void remove(E e) {
		if(e == null) return;
		this.getData().remove(e);
	}

	@Override
	public void replace(E old, E new_) {		
		if(this.contains(old)) this.add(new_, this.getIndexOf(old));
	}

	@Override
	public int getSize() {
		return this.getData().size();
	}
	
	@Override
	public void setSelectedData(E e){
		System.out.println("AbstractListTableManager.setSelectedData() : "  + e);
		this.selectedData = e;
	}	
	
	@Override
	public E getSelectedData() {
		return this.selectedData;
	}
	
	@Override
	public void setSelectedDatas(Collection<E> data){
		this.selectedDatas = new ArrayList<E>(data);
	}

	@Override
	public List<E> getSelectedDatas() {
		return this.selectedDatas;
	}
	
	@Override
	public E getFirst() {
		if(this.getData().isEmpty()) return null;
		return this.getData().get(0);
	}

	@Override
	public E getLast() {
		if(this.getData().isEmpty()) return null;
		return this.getData().get(this.getSize() - 1);
	}

	@Override
	public E getNext(E e) {
		
		// Si la liste est vide ou contient 1 seul �l�ment l'on retourne null
		if(this.getSize() < 2) return null;

		// Sinon l'on retourne l'�l�ment suivant l'�lement courant
		// Si l'�l�ment courant est le dernier �l�ment de la liste l'on retourne le premier �lement
		if(this.contains(e)) {
			int currentIndex =  this.getIndexOf(e);
			int nextIndex = (currentIndex + 1) % this.getSize();
			
			return this.getData().get(nextIndex);
		}
		
		return null;
	}

	@Override
	public E getPrevious(E e) {
		
		// Si la liste est vide ou contient 1 seul �l�ment l'on retourne null
		if(this.getSize() < 2) return null;

		// Sinon l'on retourne l'�l�ment pr�c�dent l'�lement courant
		// Si l'�l�ment courant est le premier �l�ment de la liste l'on retourne le dernier �lement
		if(this.contains(e)) {
			int currentIndex =  this.getIndexOf(e);
			int previousIndex = (currentIndex > 0) ? (currentIndex -1) % this.getSize() : (this.getSize()-1);
			
			return this.getData().get(previousIndex);
		}
		
		return null;
	}

	@Override
	public void setPaginationInfos(long totalSize) {
		this.setPaginationInfos(totalSize, this.getPaginationStep());
	}

	@Override
	public void setPaginationInfos(long totalSize, int paginationStep) {
		
		this.setTotalSize(totalSize);
		this.setPaginationStep(paginationStep);
		this.setPaginationPageList(buildPaginationList(totalSize, paginationStep));
	}

	@Override
	public void setPaginationStep(int paginationStep) {
		this.paginationStep = paginationStep;
	}

	@Override
	public int getPaginationStep() {
		return this.paginationStep;
	}

	@Override
	public void setTotalSize(long totalSize) {
		this.totalSize = totalSize;	
	}

	@Override
	public long getTotalSize() {
		return this.totalSize;
	}

	@Override
	public long getOffset() {
		return ( (this.paginationPage - 1) * this.paginationStep) + 1;
	}	

	@Override
	public void setSelectionMode(String selectionMode) {
		this.selectionMode = selectionMode;		
	}

	@Override
	public String getSelectionMode() {
		return selectionMode;
	}

	@Override
	public boolean isSingleSelectionMode() {
		return EnumSelectionMode.SINGLE.getValue().equalsIgnoreCase(this.getSelectionMode());
	}

	@Override
	public void add(E e) {
		if(e == null) return;
		this.getData().add(0,e);
	}

	@Override
	public void add(E e, int index) {
		
		// Si l'�l�ment est null retour
		if(e == null) return;
		
		// Si l'�l�ment existe d�ja retour
		if(this.contains(e)) return;

		// Ajout
		this.getData().add(index,e);		
	}


	@Override
	public int getIndexOf(E e) {
		if(e == null) return -1;
		return getData().indexOf(e);
	}

	
	@Override
	public void clear() {
		this.setData(new ArrayList<E>());
		this.setSelectedData(null);
		this.setSelectedDatas(new ArrayList<E>());
		this.setTotalSize(0);
		this.setPaginationStep(0);
	}

	/**
	 * @return the paginationPage
	 */
	public int getPaginationPage() {
		return paginationPage;
	}

	/**
	 * @param paginationPage the paginationPage to set
	 */
	public void setPaginationPage(int paginationPage) {
		System.out.println("AbstractListTableManager.setPaginationPage() : " + paginationPage);
		this.paginationPage = paginationPage;
	}

	/**
	 * @return the paginationPageList
	 */
	public List<SelectItem> getPaginationPageList() {
		return paginationPageList;
	}

	/**
	 * @param paginationPageList the paginationPageList to set
	 */
	public void setPaginationPageList(List<SelectItem> paginationPageList) {
		this.paginationPageList = paginationPageList;
	}
	
	/**
	 * Contruction de la liste de pagination <br/>
	 * La premi�re page commence � 1
	 * 
	 * @param totalSize			Nombre total de donn�es sans pagination		
	 * @param paginationStep 	Pas de pagination
	 * @return
	 */
	public static List<SelectItem> buildPaginationList(long totalSize, int paginationStep){
		
		// Plage de valeur
		String plage;
		
		// Item du combo
		SelectItem item;
		
		// Liste des pages
		List<SelectItem> paginationList = new ArrayList<SelectItem>();
		
		// S'il n'y a pas de donn�es ou de pagination alors ras
		if(totalSize == 0 || paginationStep == 0) return paginationList;
		
		// Nombre total de pages
		long pages = (totalSize / paginationStep) + (((totalSize % paginationStep) == 0 )? 0:1); 
		
		for(long i=0; i< (pages-1); i++){
			
			// D�finition de la plage
			plage = "" + ((i * paginationStep) + 1) + " - " + ((i + 1) * paginationStep);
			
			// Cr�ation de l'item
			item = new SelectItem("" + (i+1), plage);			
			paginationList.add(item);
		}
		
		long lastPage = pages - 1;
		
		if(lastPage >= 0 ){
			// Définition de la plage
			plage = "" + ((lastPage *paginationStep) + 1) + " - " + totalSize;
			
			// Création de l'item
			item = new SelectItem("" + (lastPage+1) , plage);		
			paginationList.add(item);
		}
		return paginationList;
	}

}