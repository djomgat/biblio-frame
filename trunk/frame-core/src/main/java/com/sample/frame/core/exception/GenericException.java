/**
 * 
 */
package com.sample.frame.core.exception;

import java.util.MissingResourceException;

import com.sample.frame.core.utils.FrameRessourceLocator;

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
	
	private static String defaultMessageKey = "default.error.message";

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
	public GenericException(String p$message, Throwable p$cause) {
		super(p$message, p$cause);
	}
	
	
	public GenericException(String p$catalogFileName,String p$messageId, Object[] p$params){
		super( parseMessage(p$catalogFileName, p$messageId, p$params));		
	}
	
	public GenericException(String p$catalogFileName, String p$messageId, Object[] p$params, Throwable p$cause){
		super( parseMessage(p$catalogFileName, p$messageId, p$params), p$cause);		
	}
	
	
	private static String parseMessage(String p$catalogFileName,String p$messageId, Object[] p$params){
		try{
			
		
		String v$messageValue = FrameRessourceLocator.getValue(p$catalogFileName, p$messageId);
		if(p$params != null && p$params.length > 0)
			v$messageValue = String.format(v$messageValue, p$params);
		return v$messageValue;
		}catch(MissingResourceException e){
			
			String v$messageValue = FrameRessourceLocator.getValue(p$catalogFileName, defaultMessageKey);
			return v$messageValue;
		}
		
		
	}
	
}