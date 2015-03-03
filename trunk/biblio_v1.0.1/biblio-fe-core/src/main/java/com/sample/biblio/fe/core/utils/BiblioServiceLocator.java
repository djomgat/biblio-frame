package com.sample.biblio.fe.core.utils;

import com.sample.frame.core.utils.JndiHelper;
import com.sample.frame.fe.exception.ServiceLocatorException;
import com.sample.frame.fe.locator.SingleCachingServiceLocator;

public class BiblioServiceLocator {
	
	 /**
     * Constructeur par défaut <br>
     * Lit les propriétés systèmes si elles sont fournies ou alors le fichier de 
     * configuration JNDI par défaut
     * 
     * @throws ServiceLocatorException
     */
    private BiblioServiceLocator()  {
    	
    }
    
    private static String earname = "biblio-z-ear";
    private static String svcmodule =  "biblio-be-svc-impl";    
    
    public static Object lookup(String beanName, Class viewClass) throws ServiceLocatorException{
    	
    	String ejbPath = JndiHelper.lookupRemoteStatelessName(earname, svcmodule, "", beanName, viewClass);
    	return SingleCachingServiceLocator.getInstance().lookup(ejbPath);
    	
    }
}