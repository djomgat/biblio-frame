package com.sample.frame.fe.exception;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * Exception relative � la recherche des donn�es. <br>
 * Propag�e suite � une recherche de donn�es n'ayant fournit aucun r�sultat
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
