package com.sample.frame.core.svc.generic;

import java.io.Serializable;
import java.util.List;

import com.sample.frame.core.entity.GenericEntity;
import com.sample.frame.core.exception.GenericException;

public interface IGenericSvc<U extends GenericEntity, PK extends Serializable> {

	<T extends U>T creer(T p$entite) throws GenericException;

	<T extends U>T rechercher(PK p$valeur) throws GenericException;

	<T extends U>T modifier(T p$entite) throws GenericException;

	<T extends U>void supprimer(T p$entite) throws GenericException;

	<T extends U>List<T> rechercherParCritere(final T p$critere) throws GenericException;

	<T extends U>List<T> rechercherTout() throws GenericException;;

}