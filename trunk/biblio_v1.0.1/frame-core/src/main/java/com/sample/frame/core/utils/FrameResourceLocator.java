package com.sample.frame.core.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class FrameResourceLocator {
    
    public static final String XML_ENCODING = "ISO-8859-1"; //"UTF-8";
	
    public static String getValue(String v$file, String v$key){			
	ResourceBundle rbFile = ResourceBundle.getBundle(v$file);
	return rbFile.getString(v$key);		
    }
		
    public static String getValue(String v$file, String v$key, Locale v$langage){			
	ResourceBundle rbFile = ResourceBundle.getBundle(v$file,v$langage);
	return rbFile.getString(v$key);		
    }

}