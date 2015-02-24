/**
 * 
 */
package com.sample.frame.fe.controller.crude;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * @author lkamhoua
 *
 */
public abstract class CrudeBusinessEntityWrapper<E> extends BusinessEntityWrapper<E> {
	
    private static final long serialVersionUID = 1L;
	
    /**
     * Constructeur
     * @param wrappedEntity	entité métier
     */
    public CrudeBusinessEntityWrapper(E wrappedEntity){
	super(wrappedEntity);
    }	
	
    /**
     * D�finit une entit� mod�le ou template pour une nouvelle cr�ation <br>
     * 
     * @return Par d�faut retourne une nouvelle instance du wrapper
     */
    public  CrudeBusinessEntityWrapper<E> getTemplateForCreation(){ 
	return this.getNewInstance();
    }
	
	
    /**
     * Instancie et retourne une entité modèle ou template pour une nouvelle 
     * création par copie <br>
     * 
     * @return Par défaut retourne une nouvelle instance du wrapper
     */
    public  CrudeBusinessEntityWrapper<E> getTemplateForCopy(){
	return this.getNewInstance();
    }
	
    /**
     * Instancie et retourne une entit� mod�le ou template pour une consultation plate <br>
     * 
     * @return Par d�faut retourne une nouvelle instance du wrapper
     */
    public  CrudeBusinessEntityWrapper<E> getTemplateForDisplay(){
	return this.getNewInstance();
    }
	
    /**
     * Instancie et retourne une entit� mod�le ou template pour une recherche (crit�res de recherche) <br>
     * 
     * @return Par d�faut retourne une nouvelle instance du wrapper
     */
    public  CrudeBusinessEntityWrapper<E> getTemplateForSearch(){
	return this.getNewInstance();
    }
	
    /**
     * Instancie et retourne une nouvelle instance du wrapper <br>
     * A red�finir dans une classe concr�te wrappant une entit� m�tier
     * 
     * @return 
     */
    public abstract CrudeBusinessEntityWrapper<E> getNewInstance();
	
    /**
     * Instancie et retourne une nouvelle instance du wrapper <br>
     * A red�finir dans une classe concr�te wrappant une entit� m�tier
     * 
     * @param e Entit� � wrapper
     * @return
     */
    public abstract CrudeBusinessEntityWrapper<E> getNewInstance(E e);
	
    public abstract String getShortCutName();
	
    /**
     * Instancie et retourne une nouvelle instance du wrapper <br>
     * 
     * @param collection Entités à wrapper
     * @return Une liste (vide si <code>collection</code> est <code>null</code> ou vide)
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public <T extends CrudeBusinessEntityWrapper<E>> List<T> getNewInstance(Collection<E> collection){
		
        List result = new ArrayList();
	if(collection == null || collection.isEmpty()) return result;
	for(E e: collection) result.add(this.getNewInstance(e));
	return result;	
    }
		
}