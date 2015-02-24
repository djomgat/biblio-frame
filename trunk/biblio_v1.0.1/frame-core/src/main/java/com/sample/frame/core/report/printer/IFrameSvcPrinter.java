package com.sample.frame.core.report.printer;

import java.io.File;
import javax.ejb.Local;

import ar.com.fdvs.dj.domain.DynamicReport;
import com.sample.frame.core.entity.FrameOutput;
import com.sample.frame.core.exception.GenericException;
import com.sample.frame.core.utils.FramePrinterExportEnum;

/**
 * 
 * @author Mahoungou
 * 
 * Interface locale EJB IFrameSvcPrinter
 * @Local
 */
@Local
public interface IFrameSvcPrinter {

    /**
     * - Verifie que l'utilisateur a le droit de lancer une telle impression
     * pour ce type de document - Construit le fichier d'etat (merge : xmlData +
     * model) - puis retourne une version exporter du document en fonction du
     * format
     * 
     * @param objectData
     * @param format
     * @param model
     * @param typDoc
     * @param codeUser
     * @return
     * @throws GenericException 
     */
    public FrameOutput fillAndExport(Object objectData, String model,
		FramePrinterExportEnum format, String typDoc, String codeUser)
      throws GenericException ;

	/**
	 * - Verifie que l'utilisateur a le droit de lancer une telle impression
	 * pour ce type de document - Construit le fichier d'etat (merge : xmlData +
	 * model) - puis retourne une version exportée du document en fonction du
	 * format
	 * 
	 * @param xmlData
	 * @param format
	 * @param model
	 * @param typDoc
	 * @param codeUser
	 * @return
     * @throws com.sample.frame.core.exception.GenericException
	 */
    public FrameOutput fillAndExport(File xmlData, String model,
    		  FramePrinterExportEnum format, String typDoc, String codeUser)  
        throws GenericException;
    
   /**
    * - Verifie que l'utilisateur a le droit de lancer une telle impression
    * pour ce type de document - Construit le fichier d'etat (merge : xmlData +
    * model) - puis l'envoi vers une imprimante (printerAlias) pour impression
    * direct
    * 
    * @param xmlData
    * @param printerAlias
    * @param model
    * @param typDoc
    * @param codeUser
    * @return
    * @throws com.sample.frame.core.exception.GenericException
    */
    public FrameOutput fillAndPrint(Object xmlData, String model,
			String printerAlias, String typDoc, String codeUser)  
        throws GenericException;

    /**
     * - Verifie que l'utilisateur a le droit de lancer une telle impression
     * pour ce type de document - Construit le fichier d'etat (merge : xmlData +
     * model) - puis l'envoi vers une imprimante (printerAlias) pour impression
     * direct
     * 
     * @param xmlData
     * @param printerAlias
     * @param model
     * @param typDoc
     * @param codeUser
     * @return
     * @throws com.sample.frame.core.exception.GenericException
     */
     public FrameOutput fillAndPrint(File xmlData, String model,
			String printerAlias, String typDoc, String codeUser)  
        throws GenericException;

    FrameOutput fillAndExport(Object objectData, DynamicReport dynReport,
	    FramePrinterExportEnum format, String typDoc, String codeUser, String strQuery)
	throws GenericException;

}