package com.sample.biblio.svc.api.exception;

import com.sample.frame.core.exception.GenericSvcException;

public class BiblioSvcException extends GenericSvcException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	public BiblioSvcException() {
		 
	}

	/**
	 * @param message : message d'exception
	 */
	public BiblioSvcException(String message) {
		super(message);
		 
	}

	/**
	 * @param cause
	 */
	public BiblioSvcException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message : message d'exception
	 * @param cause
	 */
	public BiblioSvcException(String p$message, Throwable p$cause) {
		super(p$message, p$cause);
	}	
	
	public BiblioSvcException(String p$catalogFileName,String p$messageId, Object[] p$params){
		super(p$catalogFileName, p$messageId, p$params);		
	}
	
	public BiblioSvcException(String p$catalogFileName, String p$messageId, Object[] p$params, Throwable p$cause){
		super(p$catalogFileName, p$messageId, p$params, p$cause);		
	}	

}
