package com.sample.frame.fe.exception;

/**
 * Exception relative à la recherche des données. <br>
 * Propagée suite à une recherche de données n'ayant fournit aucun résultat
 *
 */
public class NoDataFoundException extends FrontEndException{
    /**
    * 
    */
    private static final long serialVersionUID = 1L;
	
    public NoDataFoundException(){}
    
    /**
     * @param msg : message d'exception
     */    
    public NoDataFoundException(String msg){
        super(msg);
    }
     
    /**
     * @param th  : cause
     */
    public NoDataFoundException(Throwable th){
        super(th);
    }    
    
    /**
     * @param msg : message d'exception
     * @param th  : cause
     */
    public NoDataFoundException(String msg, Throwable th){
        super(msg,th);
    }

}