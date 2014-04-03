/**
 * 
 */
package com.sample.frame.core.exception;

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
}