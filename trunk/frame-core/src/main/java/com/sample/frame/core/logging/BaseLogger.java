package com.sample.frame.core.logging;

import java.util.Date;

import org.apache.log4j.Logger;

import com.sample.frame.core.utils.DateTools;


public class BaseLogger {
	
	public static BaseLogger getLogger(String loggerName){
		return new BaseLogger(loggerName);
	}
	
	@SuppressWarnings("rawtypes")
	public static BaseLogger getLogger(Class loggerClass){
		return new BaseLogger(loggerClass);
	}
	
	private java.util.logging.Logger javaLogger;
	private Logger log4jLogger;
        private static LoggingMode logMode = LoggingMode.LOG4J;
	
	public static LoggingMode getLogMode() {
		return logMode;
	}

	public static void setLogMode(LoggingMode logMode) {
		BaseLogger.logMode = logMode;
	}

	private BaseLogger(){
		log4jLogger = Logger.getLogger(BaseLogger.class);
		javaLogger = java.util.logging.Logger.getLogger(BaseLogger.class.getName());
	}
	
	private BaseLogger(String loggerName){
		log4jLogger = Logger.getLogger(loggerName);
		javaLogger = java.util.logging.Logger.getLogger(loggerName);
		javaLogger.setLevel(java.util.logging.Level.ALL);
	}
	
	@SuppressWarnings("rawtypes")
	private BaseLogger(Class loggerClass){
		log4jLogger = Logger.getLogger(loggerClass);
		javaLogger = java.util.logging.Logger.getLogger(loggerClass.getName());
	}
			
	public void debug(String message){
		System.out.println(DateTools.formatDate("dd/MM/yyyy HH:mm:ss.SSS", new Date()) +
				" DEBUG " + javaLogger.getName() + " ==> " + message);
		if(logMode == LoggingMode.LOG4J)
			log4jLogger.debug(message);
		else
			javaLogger.log(java.util.logging.Level.FINE, message);
	}

	public void debug(String message, Throwable e){
		System.out.println(DateTools.formatDate("dd/MM/yyyy HH:mm:ss.SSS", new Date()) +
				" DEBUG " + javaLogger.getName() + " ==> " + message + "\n " + e.toString());
		if(logMode == LoggingMode.LOG4J)
			log4jLogger.debug(message, e);
		else
			javaLogger.log(java.util.logging.Level.FINE, message, e);
	}
	
	public void info(String message){
		System.out.println(DateTools.formatDate("dd/MM/yyyy HH:mm:ss.SSS", new Date()) +
				" INFO " + javaLogger.getName() + " ==> " + message);
		if(logMode == LoggingMode.LOG4J)
			log4jLogger.debug(message);
		else
			javaLogger.log(java.util.logging.Level.INFO, message);
	}

	public void info(String message, Throwable e){
		System.out.println(DateTools.formatDate("dd/MM/yyyy HH:mm:ss.SSS", new Date()) +
				" INFO " + javaLogger.getName() + " ==> " + message + "\n " + e.toString());
		if(logMode == LoggingMode.LOG4J)
			log4jLogger.debug(message, e);
		else
			javaLogger.log(java.util.logging.Level.INFO, message, e);
	}
	
	public void warn(String message){
		System.out.println(DateTools.formatDate("dd/MM/yyyy HH:mm:ss.SSS", new Date()) +
				" WARN " + javaLogger.getName() + " ==> " + message);
		if(logMode == LoggingMode.LOG4J)
			log4jLogger.debug(message);
		else
			javaLogger.log(java.util.logging.Level.WARNING, message);
	}

	public void warn(String message, Throwable e){
		System.out.println(DateTools.formatDate("dd/MM/yyyy HH:mm:ss.SSS", new Date()) +
				" WARN " + javaLogger.getName() + " ==> " + message + "\n " + e.toString());
		
		if(logMode == LoggingMode.LOG4J)
			log4jLogger.debug(message, e);
		else
			javaLogger.log(java.util.logging.Level.WARNING, message, e);
	}
	
	public void error(String message){
		System.out.println(DateTools.formatDate("dd/MM/yyyy HH:mm:ss.SSS", new Date()) +
				" ERROR " + javaLogger.getName() + " ==> " + message);
		
		if(logMode == LoggingMode.LOG4J)
			log4jLogger.debug(message);
		else
			javaLogger.log(java.util.logging.Level.SEVERE, message);
	}

	public void error(String message, Throwable e){
		System.out.println(DateTools.formatDate("dd/MM/yyyy HH:mm:ss.SSS", new Date()) +
				" ERROR " + javaLogger.getName() + " ==> " + message + "\n " + e.toString());
		
		if(logMode == LoggingMode.LOG4J)
			log4jLogger.debug(message, e);
		else
			javaLogger.log(java.util.logging.Level.SEVERE, message, e);
	}
	
	public void fatal(String message){
		System.out.println(DateTools.formatDate("dd/MM/yyyy HH:mm:ss.SSS", new Date()) +
				" FATAL " + javaLogger.getName() + " ==> " + message);
		if(logMode == LoggingMode.LOG4J)
			log4jLogger.debug(message);
		else
			javaLogger.log(java.util.logging.Level.SEVERE, message);
	}

	public void fatal(String message, Throwable e){
		System.out.println(DateTools.formatDate("dd/MM/yyyy HH:mm:ss.SSS", new Date()) +
				" FATAL " + javaLogger.getName() + " ==> " + message + "\n " + e.toString());
		if(logMode == LoggingMode.LOG4J)
	            log4jLogger.debug(message, e);
		else
		    javaLogger.log(java.util.logging.Level.SEVERE, message, e);
	}
}