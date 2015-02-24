package com.sample.frame.fe.exception;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * Exception relative � la validation des donn�es. <br>
 * Propag�e lorsque des donn�es control�es ne sont pas valides
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
