package com.sample.biblio.dao.api.exception;

import com.sample.frame.core.exception.GenericDaoException;

public class BiblioDaoException extends GenericDaoException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	public BiblioDaoException() {
		 
	}

	/**
	 * @param message : message d'exception
	 */
	public BiblioDaoException(String message) {
		super(message);
		 
	}

	/**
	 * @param cause
	 */
	public BiblioDaoException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message : message d'exception
	 * @param cause
	 */
	public BiblioDaoException(String p$message, Throwable p$cause) {
		super(p$message, p$cause);
	}
	
	
	public BiblioDaoException(String p$catalogFileName,String p$messageId, Object[] p$params){
		super(p$catalogFileName, p$messageId, p$params);		
	}
	
	public BiblioDaoException(String p$catalogFileName, String p$messageId, Object[] p$params, Throwable p$cause){
		super(p$catalogFileName, p$messageId, p$params, p$cause);		
	}	

}