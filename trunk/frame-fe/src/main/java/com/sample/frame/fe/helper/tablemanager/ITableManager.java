package com.sample.frame.fe.helper.tablemanager;

import java.util.Collection;
import java.util.List;

/**
 *
 *
 */
public interface ITableManager<E> {
	
	/**
	 * 
	 * @param dataList
	 */
	public void setData(Collection<E> dataList);
	
	/**
	 * 
	 * @return
	 */
	public List<E> getData();	
	
	/**
	 * 
	 * @param e entity
	 * @return
	 */
	public boolean contains(E e);	
	
	/**
	 * 
	 * @param e
	 */
	public void add(E e);
	
	/**
	 * 
	 * @param e
	 * @param index
	 */
	public void add(E e, int index);

	/**
	 * 
	 * @param e
	 * @return
	 */
	public void remove(E e);

	/**
	 * 
	 * @param old
	 * @param new_
	 * @return
	 */
	public void replace(E old, E new_);

		
	/**
	 * Retourne le nombre de données / d'entités managées
	 * 
	 * @return
	 */
	public int getSize();
	
	/**
	 * 
	 * @param e
	 */
	public void setSelectedData(E e);
	
	/**
	 * 
	 * @return
	 */
	public E getSelectedData();

	
	/**
	 * 
	 */
	public void setSelectedDatas(Collection<E> data);

	
	/**
	 * 
	 * @return
	 */
	public List<E> getSelectedDatas();
		
	/**
	 * 
	 * @return
	 */
	public E getFirst();
		
	/**
	 * 
	 * @return
	 */
	public E getLast();
		
	/**
	 * 
	 * @param e
	 * @return
	 */
	public E getNext(E e);
		
	/**
	 * 
	 * @param e
	 * @return
	 */
	public E getPrevious(E e);

	/**
	 * 
	 * @param totalSize
	 */
	public void setPaginationInfos(long totalSize);
	
	/**
	 * 
	 * @param totalSize
	 * @param pasPagination
	 */
	public void setPaginationInfos(long totalSize, int pasPagination);
	
	/**
	 * 
	 * @param paginationStep
	 */
	public void setPaginationStep(int paginationStep);
		
	/**
	 * 
	 * @return
	 */
	public int getPaginationStep();

	/**
	 * 
	 * @return
	 */
	public int getPaginationPage();

	/**
	 * 
	 * @param paginationPage
	 */
	public void setPaginationPage(int paginationPage);

	/**
	 * 
	 * @param totalSize
	 */
	public void setTotalSize(long totalSize);
		
	/**
	 * 
	 * @return
	 */
	public long getTotalSize();

	/**
	 * 
	 * @return
	 */
	public long getOffset();
		
	/**
	 * 
	 * @param selectionMode
	 */
	public void setSelectionMode(String selectionMode);
		
	/**
	 * 
	 * @return selectionMode
	 */
	public String getSelectionMode();
		
	/**
	 * 
	 * @return
	 */
	public boolean isSingleSelectionMode();
	
	/**
	 * 
	 * @param e
	 * @return
	 */
	public int getIndexOf(E e);
		
	/**
	 * 
	 */
	public void clear();
}