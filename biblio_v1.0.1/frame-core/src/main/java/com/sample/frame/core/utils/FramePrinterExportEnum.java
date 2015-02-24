package com.sample.frame.core.utils;

/**
 * @author Mahoungou
 *
 */
public enum FramePrinterExportEnum {

    PDF,
    EXCEL,
    EXCELX,
    DOC,
    DOCX,
    HTML,
    CSV;
	
    public static FramePrinterExportEnum getByName(String value){
        for(FramePrinterExportEnum prt : FramePrinterExportEnum.class.getEnumConstants()){
            if(prt.name().equalsIgnoreCase(value))
                return prt;
            }
            return null;
    }
    
}