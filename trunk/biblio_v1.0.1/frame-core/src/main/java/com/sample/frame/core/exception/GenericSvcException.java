/**
 * 
 */
package com.sample.frame.core.exception;

import com.sample.frame.core.exception.GenericException;

/**
 * Classe d'exception de la couche des Svc
 * @author pdjomga
 *
 */
public class GenericSvcException extends GenericException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public GenericSvcException() {
		 
	}

	/**
	 * @param message
	 *            : message d'exception
	 */
	public GenericSvcException(String message) {
		super(message);
		 
	}

	/**
	 * @param cause
	 */
	public GenericSvcException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 *            : message d'exception
	 * @param cause
	 */
	public GenericSvcException(String message, Throwable cause) {
		super(message, cause);
	}
	

	
	public GenericSvcException(String p$catalogFileName,String p$messageId, Object[] p$params){
		super( p$catalogFileName, p$messageId, p$params);		
	}
	
	public GenericSvcException(String p$catalogFileName, String p$messageId, Object[] p$params, Throwable p$cause){
		super( p$catalogFileName, p$messageId, p$params, p$cause);		
	}
}