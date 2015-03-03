/**
 * 
 */
package com.sample.frame.core.exception;

import com.sample.frame.core.exception.GenericException;

/**
 * Classe d'exception de la couche des DAO
 * @author pdjomga
 *
 */
public class GenericDaoException extends GenericException {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public GenericDaoException() {
		 
	}

	/**
	 * 
	 * @param message
	 */
	public GenericDaoException(String message) {
		super(message);		 
	}

	/**
	 * @param cause
	 */
	public GenericDaoException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message : message d'exception
	 * @param cause
	 */
	public GenericDaoException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public GenericDaoException(String p$catalogFileName,String p$messageId, Object[] p$params){
		super( p$catalogFileName, p$messageId, p$params);		
	}
	
	public GenericDaoException(String p$catalogFileName, String p$messageId, Object[] p$params, Throwable p$cause){
		super( p$catalogFileName, p$messageId, p$params, p$cause);		
	}
}