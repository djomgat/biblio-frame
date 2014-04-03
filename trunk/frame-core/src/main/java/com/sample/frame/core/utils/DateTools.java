/**
 * 
 */
package com.sample.frame.core.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author btoko
 *
 */
public class DateTools {
	// Constante représentant les formats de date
	
	public static String DATEFORMAT_JJMMYYYY = "ddMMyyyy";
	public static String DATEFORMAT_YYYYMMJJ = "yyyyMMdd";
	public static String DATEFORMAT_yyyyMMddHHmmssSSSSSS = "yyyyMMddHHmmssSSSSSS";	
	
	private static String DEFAULT_DATE_FORMAT = DATEFORMAT_yyyyMMddHHmmssSSSSSS;	
	/***
	 * Format de date courant
	 */
	private static String CURRENT_DATE_FORMAT = DEFAULT_DATE_FORMAT;	
	
	/***
	 * Formate une date suivant le format de date courant
	 * @param date : Date à formater
	 * @return : Retourne la chaine de caractère représentant la date formatée
	 */
	public static String formatDate(Date date){
		SimpleDateFormat formater = new SimpleDateFormat(CURRENT_DATE_FORMAT);
		return formater.format(date);
	}
	
	public static void setCurrentDateFormat(String dateFormat){
		CURRENT_DATE_FORMAT = dateFormat;
	}
	
	public static String getCurrentDateFormat(){
		return CURRENT_DATE_FORMAT;
	}
	
	public static String getDefaultDateFormat(){
		return DEFAULT_DATE_FORMAT;
	}	
	
	public static String formatDate(String format, Date date){
		SimpleDateFormat formt = new SimpleDateFormat(format);
		if(date == null)
			return null;
		
		return formt.format(date);
	}
	
	/***
	 * Récupere une date à partir d'une chaine de caractère au format courant
	 * @param p$strDate : Chaine de caractère représentant la date au format courant
	 * @return Date : Date construite à partir de la valeur fournie
	 * @throws ParseException
	 */
	public static Date getDateValue(String p$strDate) throws ParseException{
		Date date;
		SimpleDateFormat formater = new SimpleDateFormat(CURRENT_DATE_FORMAT);
		if(p$strDate == null || p$strDate.trim().isEmpty())
			return null;		
		date = formater.parse(p$strDate);
		return date;
	}
	
	/***
	 * Récupere une date à partir d'une chaine de caractère 
	 * @param p$strDate : Chaine de caractere representant la date
	 * @param format : Format de date sur lequel se trouve la chaine de caractere fournie
	 * @return Date : Date construite a partie de la valeur fournie 
	 * @throws ParseException
	 */
	public static Date getDateValue(String p$strDate, String format) throws ParseException{
		Date date;
		if(p$strDate == null || format == null || p$strDate.trim().isEmpty() || format.trim().isEmpty())
			return null;
		
		SimpleDateFormat formater = new SimpleDateFormat(format);
		date = formater.parse(p$strDate);
		return date;
	}
        
}