package com.sample.frame.fe.locator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.sample.frame.fe.exception.ServiceLocatorException;

/**
 * Classe de localisation des services et ressources
 * 
 * 
 */
public class CachingServiceLocator implements IServiceLocator {
    
    /**
     * Contexte JNDI
     */
    private Context context;
    
    /**
     * Cache synchronisé de ressources
     */
    private Map<String,Object> cache = Collections.synchronizedMap(new HashMap<String,Object>());;
    
    /**
     * Constructeur par défaut  <br>
     * Lit les propriétés syst�mes si elles sont fournies ou alors le fichier de configuration JNDI par d�faut
     * 
     * @throws ServiceLocatorException
     */
    public CachingServiceLocator() throws ServiceLocatorException {
    	
    	this.initialize(new Properties());
    }
    
   /**
    *  
    * @param jndiConfig Propriétés de configuration du contexte JNDI
    * @throws ServiceLocatorException
    */
    public CachingServiceLocator(Properties jndiConfig) throws ServiceLocatorException {
	this.initialize(jndiConfig);
    }
    
   /**
    *  
    * @param jndiConfig Propriétés de configuration du contexte JNDI
    * @throws ServiceLocatorException
    */
    public CachingServiceLocator(Map<String,String> jndiConfig) throws ServiceLocatorException {
        // Conversion du map en objet Properties
	Properties contextProperties = new Properties();
	jndiConfig = (jndiConfig == null) ? new HashMap<String, String>() : jndiConfig;
	contextProperties.putAll(jndiConfig);
	      
	this.initialize(contextProperties);
    }
     
   
   /**
    * 
    * @param jndiConfig Chemin d'accès au fichier de configuration JNDI
    * @throws ServiceLocatorException
    */
    public CachingServiceLocator(String jndiConfig) throws ServiceLocatorException {
	   
	Properties contextProperties = new Properties();

	// Lecture du fichier JNDI
	FileReader reader = null;
	   
	try{
            // TODO : R�viser la m�thode de lecture du fichier JNDI
            reader = new FileReader(jndiConfig);
            contextProperties.load(reader);
            this.initialize(contextProperties);	   		   
	}
	catch (FileNotFoundException e) {
            // TODO : Internationaliser ce message
            throw new ServiceLocatorException("Erreur de lecture du fichier de configuration JNDI dont le chemin est sp�cifi� est : " + jndiConfig, e);
	}
	catch (IOException e) {
            // TODO : Internationaliser ce message
            throw new ServiceLocatorException("Erreur de lecture du fichier de configuration JNDI", e);
	}
	finally{
            if(reader != null)
                try {
                    reader.close();
		} catch (IOException e) {}
	}
	   
    } 
    
    private void initialize(Properties contextProperties) throws ServiceLocatorException {
    	
   	// Initialisation si null
        contextProperties = (contextProperties == null) ? new Properties() : contextProperties;
    	
	// Injection des propri�t�s jndi syst�me par d�faut (s'ils ont �t� d�finies)
	if(contextProperties.isEmpty()){
            String INITIAL_CONTEXT_FACTORY = System.getProperty(Context.INITIAL_CONTEXT_FACTORY);
            String URL_PKG_PREFIXES = System.getProperty(Context.URL_PKG_PREFIXES);
            String PROVIDER_URL = System.getProperty(Context.PROVIDER_URL);
			
            if(INITIAL_CONTEXT_FACTORY != null &&  ! INITIAL_CONTEXT_FACTORY.isEmpty()) contextProperties.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
            if(URL_PKG_PREFIXES != null &&  ! URL_PKG_PREFIXES.isEmpty()) contextProperties.put(Context.URL_PKG_PREFIXES, URL_PKG_PREFIXES);
            if(PROVIDER_URL != null &&  ! PROVIDER_URL.isEmpty()) contextProperties.put(Context.PROVIDER_URL, PROVIDER_URL);	
	}
		
	// Initialisation du contexte
	try{
            // Injection des propriétés jndi se trouvant dans un fichier de configuration 
            // jndi positionné en lecture directe lors de l'initialisation du contexte
            if(contextProperties.isEmpty()) context = new InitialContext();
            else context = new InitialContext(contextProperties);
			
	}
	catch (NamingException e) {
            // TODO : Internationaliser le message
            throw new ServiceLocatorException("Une erreur est survenue lors de l'initialisation du contexte JNDI", e); 
	}		
	
    }
    
 
    @Override
    public Object lookup(String jndiName) throws ServiceLocatorException {

        try {
            Object cachedObj = cache.get(jndiName);
            if (cachedObj == null) {
                cachedObj = context.lookup(jndiName);
                cache.put(jndiName, cachedObj);
            }
            return cachedObj;
        }
        catch(NamingException ex) {
            // TODO : Internationaliser le message
            throw new ServiceLocatorException("Service ou Ressource inaccessible",ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public <T> T lookup(String jndiName, Class<T> type) throws ServiceLocatorException {
	return (T) this.lookup(jndiName);
    }
  
}