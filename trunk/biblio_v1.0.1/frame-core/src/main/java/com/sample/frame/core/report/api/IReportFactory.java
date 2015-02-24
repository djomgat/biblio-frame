package com.sample.frame.core.report.api;

import java.io.FileInputStream;
import com.sample.frame.core.exception.GenericException;
import ar.com.fdvs.dj.domain.DynamicReport;

/**
 * 
 * @author Peter
 *
 */
public interface IReportFactory {
	
    void setShowViewer(boolean showViewer);
    
   // void setShowWebViewer(boolean showViewer); 

    // Format PRINTER
    byte[] runReportToPrinter(FileInputStream xmlSource, String jasperfile, String printerAlias) 
           throws GenericException;
    
    // Format PDF
    byte[] runReportToPdf(FileInputStream xmlSource, String jasperfile)
           throws GenericException;
    byte[] runReportToPdf(FileInputStream xmlSource, String jasperfile, String licence)
           throws GenericException;
    byte[] runReportToPdf(FileInputStream xmlSource, DynamicReport dynReport, String strQuery)
        throws GenericException;

    // Format Excel
    byte[] runReportToExcel(FileInputStream xmlSource, String jasperfile)
           throws GenericException;    
    byte[] runReportToExcelx(FileInputStream xmlSource, String jasperfile)
        throws GenericException;    
    byte[] runReportToExcel(FileInputStream xmlSource, DynamicReport dynReport, String strQuery)
        throws GenericException;
    byte[] runReportToExcelx(FileInputStream xmlSource, DynamicReport dynReport, String strQuery)
        throws GenericException;
    
    // Format .DOC
    byte[] runReportToDoc(FileInputStream xmlSource, String jasperfile) 
        throws GenericException;
    byte[] runReportToDocx(FileInputStream xmlSource, String jasperfile)
        throws GenericException;
    byte[] runReportToDoc(FileInputStream xmlSource, DynamicReport dynReport, String strQuery)
        throws GenericException;    
    byte[] runReportToDocx(FileInputStream xmlSource, DynamicReport dynReport, String strQuery)
        throws GenericException;	 

    // Format .HTML    
    byte[] runReportToHtml(FileInputStream xmlSource, String jasperfile) 
           throws GenericException;
    byte[] runReportToHtml(FileInputStream xmlSource, DynamicReport dynReport, String strQuery)
        throws GenericException;    

    // Format RTF  
    byte[] runReportToRtf(FileInputStream xmlSource, String jasperfile)
           throws GenericException;
    byte[] runReportToRtf(FileInputStream xmlSource, DynamicReport dynReport, String strQuery)
           throws GenericException;
    
    // Format CSV	
    byte[] runReportToCsv(FileInputStream xmlSource, String jasperfile)
        throws GenericException;
    byte[] runReportToCsv(FileInputStream xmlSource, DynamicReport dynReport, String strQuery)
        throws GenericException;

}