package com.sample.frame.fe.exception;

/**
 * Exception relative à la localisation des services
 * Propagée suite à une erreur survenue lors de la recherche / localisation d'un service
 * 
 */
public class ServiceLocatorException extends FrontEndException{
	
    /**
    * 
    */
    private static final long serialVersionUID = 1L;
	
    public ServiceLocatorException(){}
    
    /**
    * @param msg : message d'exception
    */    
    public ServiceLocatorException(String msg){
        super(msg);
    }
     
    /**
    * @param th  : cause
    */
    public ServiceLocatorException(Throwable th){
        super(th);
    }    
    
    /**
    * @param msg : message d'exception
    * @param th  : cause
    */
    public ServiceLocatorException(String msg, Throwable th){
        super(msg,th);
    }

}