package com.sample.biblio.svc.api.exception;

public class BiblioSvcExceptionForTestTransact extends BiblioSvcException{
	
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
	
    /**
     * 
     */
    public BiblioSvcExceptionForTestTransact() {
		 
    }

    /**
     * @param message : message d'exception
     */
    public BiblioSvcExceptionForTestTransact(String message) {
	super(message);
    }

    /**
     * @param cause
     */
    public BiblioSvcExceptionForTestTransact(Throwable cause) {
	super(cause);
    }

    /**
     * @param message : message d'exception
     * @param cause
     */
    public BiblioSvcExceptionForTestTransact(String p$message, Throwable p$cause) {
	super(p$message, p$cause);
    }
	
	
    public BiblioSvcExceptionForTestTransact(String p$catalogFileName,String p$messageId, Object[] p$params){
	super(p$catalogFileName, p$messageId, p$params);		
    }
	
    public BiblioSvcExceptionForTestTransact(String p$catalogFileName, String p$messageId, Object[] p$params, Throwable p$cause){
	super(p$catalogFileName, p$messageId, p$params, p$cause);		
    }

}