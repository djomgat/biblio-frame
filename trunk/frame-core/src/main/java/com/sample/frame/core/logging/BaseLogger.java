package com.sample.frame.core.logging;

import org.apache.log4j.Logger;


/**
 * Classe d'abstraction pour la gestion des logs
 * Elle prend prend en charge 
 *  - logger JAVA : java.util.logging.Logger
 *  - log4J   : org.apache.log4j.Logger
 *    
 * @author pdjomga
 *
 */
public class BaseLogger {
	
	public static BaseLogger getLogger(String loggerName){
		return new BaseLogger(loggerName);
	}
	
	@SuppressWarnings("rawtypes")
	public static BaseLogger getLogger(Class loggerClass){
		return new BaseLogger(loggerClass);
	}
	
	// Logger JAVA
	private java.util.logging.Logger javaLogger;
	
	// Loger Log4J
	private Logger log4jLogger;
	
	// Précise le logger qui sera utilisé par défaut
    private static EnumLoggingMode logMode = EnumLoggingMode.LOG4J;
	
	public static EnumLoggingMode getLogMode() {
		return logMode;
	}

	public static void setLogMode(EnumLoggingMode logMode) {
		BaseLogger.logMode = logMode;
	}

	/**
	 * Constructeur par défaut
	 */
	private BaseLogger(){
		log4jLogger = Logger.getLogger(BaseLogger.class);
		javaLogger = java.util.logging.Logger.getLogger(BaseLogger.class.getName());
	}
	
	/**
	 * 
	 * @param loggerName
	 */
	private BaseLogger(String loggerName){
		log4jLogger = Logger.getLogger(loggerName);
		javaLogger = java.util.logging.Logger.getLogger(loggerName);
		javaLogger.setLevel(java.util.logging.Level.ALL);
	}
	
	/**
	 * 
	 * @param loggerClass
	 */
	@SuppressWarnings("rawtypes")
	private BaseLogger(Class loggerClass){
		log4jLogger = Logger.getLogger(loggerClass);
		javaLogger = java.util.logging.Logger.getLogger(loggerClass.getName());
	}
			
	
	
	public void debug(String message){
		
		if(logMode == EnumLoggingMode.LOG4J)  log4jLogger.debug(message);
		else javaLogger.log(java.util.logging.Level.FINE, message);
	}

	public void debug(String message, Throwable e){
		if(logMode == EnumLoggingMode.LOG4J)  log4jLogger.debug(message, e);
		else javaLogger.log(java.util.logging.Level.FINE, message, e);
	}
	
	public void info(String message){
		if(logMode == EnumLoggingMode.LOG4J) log4jLogger.info(message);
		else javaLogger.log(java.util.logging.Level.INFO, message);
	}

	public void info(String message, Throwable e){
		
		if(logMode == EnumLoggingMode.LOG4J) log4jLogger.info(message, e);
		else javaLogger.log(java.util.logging.Level.INFO, message, e);
	}
	
	public void warn(String message){
		if(logMode == EnumLoggingMode.LOG4J) log4jLogger.warn(message);
		else javaLogger.log(java.util.logging.Level.WARNING, message);
	}

	public void warn(String message, Throwable e){
		if(logMode == EnumLoggingMode.LOG4J) log4jLogger.warn(message, e);
		else javaLogger.log(java.util.logging.Level.WARNING, message, e);
	}
	
	public void error(String message){
		if(logMode == EnumLoggingMode.LOG4J) log4jLogger.error(message);
		else javaLogger.log(java.util.logging.Level.SEVERE, message);
	}

	public void error(String message, Throwable e){
		if(logMode == EnumLoggingMode.LOG4J) log4jLogger.error(message, e);
		else  javaLogger.log(java.util.logging.Level.SEVERE, message, e);
	}
	
	public void fatal(String message){
		if(logMode == EnumLoggingMode.LOG4J) log4jLogger.fatal(message);
		else  javaLogger.log(java.util.logging.Level.SEVERE, message);
	}

	public void fatal(String message, Throwable e){
		if(logMode == EnumLoggingMode.LOG4J) log4jLogger.fatal(message, e);
		else  javaLogger.log(java.util.logging.Level.SEVERE, message, e);
	}
}