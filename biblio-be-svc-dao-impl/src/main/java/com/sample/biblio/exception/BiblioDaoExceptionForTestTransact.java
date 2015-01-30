package com.sample.biblio.exception;

import com.sample.biblio.svc.exceptions.BiblioDaoException;

public class BiblioDaoExceptionForTestTransact extends BiblioDaoException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	public BiblioDaoExceptionForTestTransact() {
		 
	}

	/**
	 * @param message : message d'exception
	 */
	public BiblioDaoExceptionForTestTransact(String message) {
		super(message);
		 
	}

	/**
	 * @param cause
	 */
	public BiblioDaoExceptionForTestTransact(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message : message d'exception
	 * @param cause
	 */
	public BiblioDaoExceptionForTestTransact(String p$message, Throwable p$cause) {
		super(p$message, p$cause);
	}
	
	
	public BiblioDaoExceptionForTestTransact(String p$catalogFileName,String p$messageId, Object[] p$params){
		super(p$catalogFileName, p$messageId, p$params);		
	}
	
	public BiblioDaoExceptionForTestTransact(String p$catalogFileName, String p$messageId, Object[] p$params, Throwable p$cause){
		super(p$catalogFileName, p$messageId, p$params, p$cause);		
	}

}
