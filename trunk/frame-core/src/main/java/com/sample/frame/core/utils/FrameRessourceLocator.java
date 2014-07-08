package com.sample.frame.core.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class FrameRessourceLocator {
	
		public static String getValue(String v$file, String v$key){			
			ResourceBundle rbFile = ResourceBundle.getBundle(v$file);
			return rbFile.getString(v$key);		
		}
		
		public static String getValue(String v$file, String v$key, Locale v$langage){			
			ResourceBundle rbFile = ResourceBundle.getBundle(v$file,v$langage);
			return rbFile.getString(v$key);		
		}

}
