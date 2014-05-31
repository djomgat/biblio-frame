package com.sample.frame.fe.locator;


import com.sample.frame.fe.exception.ServiceLocatorException;

/**
 * Classe de localisation des services et ressources impl�mentant le pattern Singleton
 * 
 * 
 */
public class SingleCachingServiceLocator implements IServiceLocator {
    
	
	/**
	 * Locator
	 */
    private CachingServiceLocator locator;
    
    /**
     * Single internal instance
     */
    private static SingleCachingServiceLocator instance;
    
     
    /**
     * Constructeur par d�faut <br>
     * Lit les propri�t�s syst�mes si elles sont fournies ou alors le fichier de configuration JNDI par d�faut
     * 
     * @throws ServiceLocatorException
     */
    private SingleCachingServiceLocator() throws ServiceLocatorException {
    	locator = new CachingServiceLocator();
    }
    
    /**
     * Retourne l'unique instance du locator <br>
     * Lit les propri�t�s syst�mes si elles sont fournies ou alors le fichier de configuration JNDI par d�faut
     *
     * @return locator
     */
    public static synchronized SingleCachingServiceLocator getInstance() throws ServiceLocatorException{
    	
    	if(instance == null) instance = new SingleCachingServiceLocator();
    	
    	return instance;
    }
    
 
	@Override
    public Object lookup(String jndiName) throws ServiceLocatorException {
		return this.locator.lookup(jndiName);
    }

    
	@SuppressWarnings("unchecked")
	@Override
	public <T> T lookup(String jndiName, Class<T> type) throws ServiceLocatorException {
		return (T) this.lookup(jndiName);
	}
  
}

