package com.sample.frame.fe.locator;

import com.sample.frame.fe.exception.ServiceLocatorException;

/**
 * Interface de localisation des services et ressources
 * Design Patter Service Locator
 */
public interface IServiceLocator {
	
    /**
     * Recherche un service ou une ressource via son nom jndi
     * 
     * @param jndiName 	Nom de la ressource / service
     * @param type 	Type de la ressource / service 
     * @return Ressource/Service cast� en au type T d�fini
     * @throws ServiceLocatorException
     */
    public <T> T lookup(String jndiName, Class<T> type) throws ServiceLocatorException ;
	
    /**
     * Recherche un service ou une ressource via son nom jndi
     * 
     * @param jndiName Nom de la ressource / service
     * @return Ressource/Service non cast�
     * @throws ServiceLocatorException
     */
	public Object lookup(String jndiName) throws ServiceLocatorException ;
	
}