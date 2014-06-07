package com.sample.frame.fe.exception;

/**
 * Exception relative à la validation des données. <br>
 * Propagée lorsque des données controlées ne sont pas valides.
 *
 */
public class DataValidationException extends FrontEndException{

    private static final long serialVersionUID = 1L;

    public DataValidationException(){}
    
    /**
    * @param msg : message d'exception
    */    
    public DataValidationException(String msg){
        super(msg);
    }
     
    /**
    * @param th  : cause
    */
    public DataValidationException(Throwable th){
        super(th);
    }    
    
    /**
    * @param msg : message d'exception
    * @param th  : cause
    */
    public DataValidationException(String msg, Throwable th){
        super(msg,th);
    }

}