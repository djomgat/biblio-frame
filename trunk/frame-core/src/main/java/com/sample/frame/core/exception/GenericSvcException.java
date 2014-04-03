/**
 * 
 */
package com.sample.frame.core.exception;
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
}