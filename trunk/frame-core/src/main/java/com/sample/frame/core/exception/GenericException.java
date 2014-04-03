/**
 * 
 */
package com.sample.frame.core.exception;
/**
 * Exception de base 
 * @author pdjomga
 *
 */
public class GenericException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public GenericException() {
		 
	}

	/**
	 * @param message : message d'exception
	 */
	public GenericException(String message) {
		super(message);
		 
	}

	/**
	 * @param cause
	 */
	public GenericException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message : message d'exception
	 * @param cause
	 */
	public GenericException(String message, Throwable cause) {
		super(message, cause);
	}
	// @Override
	// public String toString() {
	// return super.toString();
	// }
}