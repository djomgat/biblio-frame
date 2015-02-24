/**
 * 
 */
package com.sample.frame.core.report.jasper;

import java.util.EnumMap;

/**
 * @author btoko
 *
 */
public class Constants {

	public static final String XML_ENCODING = "ISO-8859-1"; //"UTF-8"; 
	
	public static final String XML_BAD_CHAR_PATTERN = "&#[xX]([0-9a-fA-F]+);";
	
	public static final String XML_REPLACE = " ";
	
	public static final String NUMBER_FORMAT = "#,###.###";
	
	public static final int CHAR_FL = 0x0A; //Marqueur de fin de ligne
	
	private static EnumMap<ReportOutputType, String> outputType;
	
	static{
		outputType = new EnumMap<ReportOutputType, String>(ReportOutputType.class);		
		outputType.put(ReportOutputType.HTML, "html");		
		outputType.put(ReportOutputType.PDF, "pdf");		
		outputType.put(ReportOutputType.RUN, "run");		
	}
	
	public static String getOutputType(ReportOutputType type){
		return outputType.get(type);
	}
}
