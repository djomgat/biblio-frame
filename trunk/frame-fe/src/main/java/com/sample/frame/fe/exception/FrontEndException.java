package com.sample.frame.fe.exception;

/**
 * Classe de base des exceptions niveau front-end. Classe parente de toutes les exceptions front-end
 *
 */
public class FrontEndException extends Exception{
	
    private static final long serialVersionUID = 1L;
	
    public FrontEndException(){}
    
    /**
    * @param msg : message d'exception
    */    
    public FrontEndException(String msg){
        super(msg);
    }
     
    /**
    * @param th  : cause
    */
    public FrontEndException(Throwable th){
        super(th);
    }    
    
    /**
    * @param msg : message d'exception
    * @param th  : cause
    */
    public FrontEndException(String msg, Throwable th){
        super(msg,th);
    }

}