package com.sample.frame.fe.controller.crude;

import java.io.Serializable;
import java.util.List;
import com.sample.frame.core.entity.GenericEntity;
import com.sample.frame.core.exception.GenericException;
import com.sample.frame.core.svc.generic.IGenericSvc;
import com.sample.frame.fe.exception.FrontEndException;
import com.sample.frame.fe.exception.ServiceLocatorException;

public abstract class BaseCrudeController<T 
        extends GenericEntity, E 
        extends CrudeBusinessEntityWrapper<T>> 
        extends CrudeController<E> {

    public abstract IGenericSvc<T, String>  getCurrentSvc();
		
    @Override
    protected Object getBusinessService() throws ServiceLocatorException {
	return getCurrentSvc();
    }

    @Override
    protected E be_persist(E entity) throws FrontEndException {
        try{
            entity.setWrappedEntity(getCurrentSvc().creer(entity.getWrappedEntity()));
            return entity;
	}catch(GenericException e){
            e.printStackTrace();
	}finally{
	}		
	return entity;
    }

    @Override
    protected E be_update(E entity) throws FrontEndException {
        try{
            entity.setWrappedEntity(getCurrentSvc().modifier(entity.getWrappedEntity()));
            return entity;
	}catch(GenericException e){
            e.printStackTrace();
	}finally{			
	}		
	return entity;
    }

    @Override
    protected E be_delete(E entity) throws FrontEndException {
	try{
            getCurrentSvc().supprimer(entity.getWrappedEntity());
            entity.setWrappedEntity(null);
            return null;
	}catch(GenericException e){
            e.printStackTrace();
	}finally{
	
	}
	return entity;
    }

    @Override
    protected long be_countByExample(E entity) throws FrontEndException {
		
        return 0;
    }

    @Override
    protected E be_findById(Serializable Id) throws FrontEndException {
	try{
            T resultEntity = getCurrentSvc().rechercher((String)Id);
            return (E)getViewHelper().getWrapperInstance().getNewInstance(resultEntity);
	}catch(GenericException e){
            e.printStackTrace();
	}finally{
			
	}
		
	return null;
    }

    @Override
    protected List<E> be_findByExample(E entity) throws FrontEndException {
		
        try{
            List<T> resultList = getCurrentSvc().rechercherParCritere(entity.getWrappedEntity());
            System.out.println("BiblioBaseCrudeController.be_findByExample() Nom element trouvé = " + resultList.size() + " - " + resultList.toString());
            return getViewHelper().getWrapperInstance().getNewInstance(resultList);
	}catch(GenericException e){
            e.printStackTrace();
	}finally{
		
	}
	return null;
    }

    @Override
    protected List<E> be_findAll(E entity) throws FrontEndException {
    	try{
            List<T> resultList = getCurrentSvc().rechercherTout();
            return getViewHelper().getWrapperInstance().getNewInstance(resultList);
	}catch(GenericException e){
            e.printStackTrace();
	}finally{
			
	}
	return null;
    }

}