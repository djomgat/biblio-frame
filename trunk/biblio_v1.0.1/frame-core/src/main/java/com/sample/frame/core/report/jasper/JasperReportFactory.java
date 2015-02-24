/**
 * 
 */
package com.sample.frame.core.report.jasper;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JExcelApiExporterParameter;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRCsvExporterParameter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.query.JRXPathQueryExecuterFactory;
import net.sf.jasperreports.engine.util.JRXmlUtils;
import net.sf.jasperreports.view.JasperViewer;

import org.w3c.dom.Document;
import org.xml.sax.SAXParseException;
import ar.com.fdvs.dj.core.DynamicJasperHelper;
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager;
import ar.com.fdvs.dj.domain.DynamicReport;

import com.sample.frame.core.exception.GenericException;
import com.sample.frame.core.logging.BaseLogger;
import com.sample.frame.core.report.api.IReportFactory;
import com.sample.frame.core.utils.FrameLocaleUtil;

/**
 * @author btoko
 * Génération des rapports avec l'implémentation JasperReport
 */

@SuppressWarnings("unchecked")
public class JasperReportFactory implements IReportFactory {

    private BaseLogger logger = BaseLogger.getLogger(JasperReportFactory.class);
    JasperPrint jasperPrint;
    boolean showViewer;

    public JasperPrint getJasperPrint() {
	return jasperPrint;
    }

    public void setJasperPrint(JasperPrint jasperPrint) {
        this.jasperPrint = jasperPrint;
    }

    public boolean isShowViewer() {
        return showViewer;
    }

    public void setShowViewer(boolean showViewer) {
        this.showViewer = showViewer;
    }

    /* Lancement unique d'un génération du Jasper print sans reprise sur erreur */
    private JasperPrint fillSingleOperation(FileInputStream xmlSource,
    		String jasperfile) throws JRException {

        logger.debug("[SOS LOG : JasperReportFactory ]Fill operation ...");
	Map params = new HashMap();
	Document document = JRXmlUtils.parse(xmlSource);
	params.put(JRXPathQueryExecuterFactory.PARAMETER_XML_DATA_DOCUMENT, document);
	params.put(JRXPathQueryExecuterFactory.XML_DATE_PATTERN, "dd-MM-yyyy");
	params.put(JRXPathQueryExecuterFactory.XML_NUMBER_PATTERN, "#,##0");
	params.put(JRXPathQueryExecuterFactory.XML_LOCALE, Locale.FRENCH);
	params.put(JRParameter.REPORT_LOCALE, Locale.FRANCE);		
	logger.debug("[SOS LOG : JasperReportFactory ]mapping fichier template et fichier de la source de données : Génération du JasperPrint...");
	JasperPrint jasperPrint = JasperFillManager.fillReport(jasperfile, params);		
	if (showViewer) JasperViewer.viewReport(jasperPrint);
	logger.debug("[SOS LOG : JasperReportFactory ]Génération du JasperPrint terminée.");
	return jasperPrint;
    }

    /**/
    /* Lancement unique d'un generation du Jasper print sans reprise sur erreur */
    private JasperPrint fillSingleOperation(FileInputStream xmlSource,
		String jasperfile , String licence) throws JRException {

	logger.debug("[SOS LOG : JasperReportFactory ]Fill op�ration ...");
	Map params = new HashMap();
	Document document = JRXmlUtils.parse(xmlSource);
	params.put(JRXPathQueryExecuterFactory.PARAMETER_XML_DATA_DOCUMENT, document);
	params.put(JRXPathQueryExecuterFactory.XML_DATE_PATTERN, "dd-MM-yyyy");
	params.put(JRXPathQueryExecuterFactory.XML_NUMBER_PATTERN, "#,##0");
	params.put(JRXPathQueryExecuterFactory.XML_LOCALE, Locale.FRENCH);
	params.put(JRParameter.REPORT_LOCALE, Locale.FRANCE);
	logger.debug("[SOS LOG : JasperReportFactory ]Passer le param�tre Type de licence � l'�tat");
	params.put("LICENCE", licence);
	logger.debug("[SOS LOG : JasperReportFactory ]Paramètre licene récupéré est:"+"<< "+licence+" >>");
	// params.put(JRExporterParameter.CHARACTER_ENCODING, "UTF-8");
        
	// mapping fichier template et fichier de la source de donn�es
	logger.debug("[SOS LOG : JasperReportFactory ]mapping fichier template et fichier de la source de donn�es : G�n�ration du JasperPrint ...");
	JasperPrint jasperPrint = JasperFillManager.fillReport(jasperfile, params);		
	if (showViewer)
	JasperViewer.viewReport(jasperPrint);
	logger.debug("[SOS LOG : JasperReportFactory ]G�n�ration du JasperPrint termin�e.");
	return jasperPrint;
    }

    private JasperPrint fillSingleOperation(FileInputStream xmlSource,
		DynamicReport dynReport, String strQuery) throws JRException {

	Map params = new HashMap();
	Document document = JRXmlUtils.parse(xmlSource);
	params.put(JRXPathQueryExecuterFactory.PARAMETER_XML_DATA_DOCUMENT, document);
	params.put(JRXPathQueryExecuterFactory.XML_DATE_PATTERN, "dd-MM-yyyy");
	params.put(JRXPathQueryExecuterFactory.XML_NUMBER_PATTERN, "#,##0");
	params.put(JRXPathQueryExecuterFactory.XML_LOCALE, Locale.FRENCH);
	params.put(JRParameter.REPORT_LOCALE, Locale.FRANCE);

	JRDataSource ds = new JRXmlDataSource(document, strQuery);
	JasperPrint jasperPrint = DynamicJasperHelper.generateJasperPrint(
				dynReport, new ClassicLayoutManager(), ds, params);
	if (showViewer) JasperViewer.viewReport(jasperPrint);
	logger.debug("[SOS LOG : JasperReportFactory ]Génération du JasperPrint terminée.");
	return jasperPrint;
    }
	
    private JasperPrint fillOperation(FileInputStream xmlSource,
		String jasperfile) throws GenericException {
	try {
            return fillSingleOperation(xmlSource, jasperfile);
	} 
	catch (JRException jre) {
	try { 
            logger.warn("Erreur de génération de l'état : " + jre.getMessage() + " !", jre);
            jre.printStackTrace();
				
            // Traitement du cas sp�cifique des caract�res incorrect dans le fichier xml
            if (jre.getCause() instanceof SAXParseException) {
                FileInputStream xmlSourceClean = cleanXmlFile(xmlSource);
		return fillSingleOperation(xmlSourceClean, jasperfile);
            } else
                throw new GenericException(FrameLocaleUtil.getLocalizedString(
                        FrameLocaleKeyConstants.CFRAME_TEXT_88), jre);
	} catch (Exception e) {
		throw new GenericException(
			FrameLocaleUtil.getLocalizedString(FrameLocaleKeyConstants.CFRAME_TEXT_89), e);
	  }
	} catch (Exception e) {
			throw new GenericException(FrameLocaleUtil.getLocalizedString(
                                FrameLocaleKeyConstants.CFRAME_TEXT_90), e);
		}
	}
	
	/***/
	private JasperPrint fillOperation(FileInputStream xmlSource,
			String jasperfile,String licence) throws GenericException {
            try {
		return fillSingleOperation(xmlSource, jasperfile,licence);
            } 
            catch (JRException jre) {
                try { 
                    logger.warn("Erreur de génération de l'état : " + jre.getMessage() + " !", jre);
                    jre.printStackTrace();
                    
                    // Traitement du cas sp�cifique des caract�res incorrect dans le fichier xml
                    if (jre.getCause() instanceof SAXParseException) {
                        FileInputStream xmlSourceClean = cleanXmlFile(xmlSource);
			return fillSingleOperation(xmlSourceClean, jasperfile);
                    } else
			throw new GenericException(FrameLocaleUtil.getLocalizedString(
                                FrameLocaleKeyConstants.CFRAME_TEXT_88),jre);
			} catch (Exception e) {
                            throw new GenericException(
				FrameLocaleUtil.getLocalizedString(
                                        FrameLocaleKeyConstants.CFRAME_TEXT_89),e);
			}
            } 
            catch (Exception e) {
		throw new GenericException(FrameLocaleUtil.getLocalizedString(
                        FrameLocaleKeyConstants.CFRAME_TEXT_90), e);
		}
	}


    private JasperPrint fillOperation(FileInputStream xmlSource,
		DynamicReport dynReport, String strQuery) throws GenericException {
        try {
            return fillSingleOperation(xmlSource, dynReport, strQuery);
	} 
        catch (JRException jre) {
            try { 
            	logger.warn("Erreur de g�n�ration de l'�tat : " + jre.getMessage() + " !", jre);
		jre.printStackTrace();
		// Traitement du cas sp�cifique des caract�res incorrect dans le fichier xml
		if (jre.getCause() instanceof SAXParseException) {
                    FileInputStream xmlSourceClean = cleanXmlFile(xmlSource);
                    return fillSingleOperation(xmlSourceClean, dynReport, strQuery);
		} else
                    throw new GenericException(FrameLocaleUtil.getLocalizedString(
                            FrameLocaleKeyConstants.CFRAME_TEXT_88), jre);
            } 
            catch (Exception e) {
		throw new GenericException(
                    FrameLocaleUtil.getLocalizedString(FrameLocaleKeyConstants.CFRAME_TEXT_89), e);
            }
	} catch (Exception e) {
		throw new GenericException(FrameLocaleUtil.getLocalizedString(
                        FrameLocaleKeyConstants.CFRAME_TEXT_90), e);
		}
	}

	// ---------------------------------------------------------------------------//

	@Override
	public byte[] runReportToDoc(FileInputStream xmlSource, String jasperfile)
			throws GenericException {
            try {
		JasperPrint jasperPrint = fillOperation(xmlSource, jasperfile);

		ByteArrayOutputStream docReport = new ByteArrayOutputStream();
		JRDocxExporter exporter = new JRDocxExporter();
		exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT,jasperPrint);
                exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM,docReport);
		exporter.exportReport();
		// Send response
		byte[] bytes = docReport.toByteArray();

		File sortie = File.createTempFile("docFile", ".doc");
		logger.debug("Fichier doc créé : " + sortie.getAbsolutePath());
		// File sortie = new File("excelFile.xls");
		FileOutputStream myoutput;
		try {
                    myoutput = new FileOutputStream(sortie);
                    docReport.writeTo(myoutput);

		} 
                catch (FileNotFoundException e) {
                    e.printStackTrace();
		} 
                catch (IOException e) {
                    e.printStackTrace();
		}

		return bytes;
            } 
            catch (Exception e) {
		throw new GenericException(e.getMessage(), e);
            }
	}

	@Override
	public byte[] runReportToDoc(FileInputStream xmlSource,
			DynamicReport dynReport, String strQuery) throws GenericException {
            try {
		JasperPrint jasperPrint = fillOperation(xmlSource, dynReport,strQuery);

		ByteArrayOutputStream docReport = new ByteArrayOutputStream();
		JRDocxExporter exporter = new JRDocxExporter();
		exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT,jasperPrint);
		exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM,docReport);
		exporter.exportReport();
		// Send response
		byte[] bytes = docReport.toByteArray();

		File fichier = File.createTempFile("docFile", ".doc");
		System.out.println("Fichier doc cr�� : " + fichier.getAbsolutePath());
		logger.debug("Fichier doc créé : " + fichier.getAbsolutePath());
                // File sortie = new File("excelFile.xls");
		FileOutputStream myoutput;
		try {
                    myoutput = new FileOutputStream(fichier);
                    docReport.writeTo(myoutput);
		} 
                catch (FileNotFoundException e) {
                    e.printStackTrace();
		} 
                catch (IOException e) {
                    e.printStackTrace();
		}

		return bytes;
            } 
            catch (Exception e) {
		throw new GenericException(e.getMessage(), e);
            }
	}

	// ---------------------------------------------------------------------------//
	// ---------------------------------------------------------------------------//

    @Override
    public byte[] runReportToDocx(FileInputStream xmlSource, String jasperfile)
			throws GenericException {
	try {
            JasperPrint jasperPrint = fillOperation(xmlSource, jasperfile);

            ByteArrayOutputStream docxReport = new ByteArrayOutputStream();
            JRDocxExporter exporter = new JRDocxExporter();
            exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT,jasperPrint);
            exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM,docxReport);
            exporter.exportReport();
	    // Send response
            byte[] bytes = docxReport.toByteArray();

            File fichier = File.createTempFile("docxFile", ".docx");
            logger.debug("Fichier doc créé : " + fichier.getAbsolutePath());
            System.out.println("Fichier docx cr�� : "+ fichier.getAbsolutePath());
            FileOutputStream myoutput;
            try {
                myoutput = new FileOutputStream(fichier);
                docxReport.writeTo(myoutput);

            } 
            catch (FileNotFoundException e) {
		e.printStackTrace();
            } 
            catch (IOException e) {
		e.printStackTrace();
            }

            return bytes;
	} 
        catch (Exception e) {
            throw new GenericException(e.getMessage(), e);
	}
    }

    @Override
    public byte[] runReportToDocx(FileInputStream xmlSource,
		DynamicReport dynReport, String strQuery) throws GenericException {
	try {
            JasperPrint jasperPrint = fillOperation(xmlSource, dynReport,strQuery);

            ByteArrayOutputStream docxReport = new ByteArrayOutputStream();
            JRDocxExporter exporter = new JRDocxExporter();
            exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT,jasperPrint);
            exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM,docxReport);
            exporter.exportReport();
            // Send response
            byte[] bytes = docxReport.toByteArray();

            File sortie = File.createTempFile("docxFile", ".docx");
            System.out.println("Fichier docx cr�� : "+ sortie.getAbsolutePath());
            // File sortie = new File("excelFile.xls");
            FileOutputStream myoutput;
            try {
		myoutput = new FileOutputStream(sortie);
		docxReport.writeTo(myoutput);
            } 
            catch (FileNotFoundException e) {
		e.printStackTrace();
            } 
            catch (IOException e) {
		e.printStackTrace();
            }

            return bytes;
	} 
        catch (Exception e) {
            throw new GenericException(e.getMessage(), e);
	}
    }

    // ---------------------------------------------------------------------------//

    @Override
    public byte[] runReportToExcel(FileInputStream xmlSource, String jasperfile)
			throws GenericException {
	try {
            JasperPrint jasperPrint = fillOperation(xmlSource, jasperfile);

            ByteArrayOutputStream xlsReport = new ByteArrayOutputStream();

            try {
		this.getApiXlsExporter(xlsReport, jasperPrint).exportReport();
            } 
            catch (Exception e) {
		logger.warn("Erreur de génération de l'état avec l'API JExcelApi : "
					+ e.getMessage()
					+ "\n Tentative avec l'API POI...", e);
		this.getCommonXlsExporter(xlsReport, jasperPrint).exportReport();
            }

            // Send response
            byte[] bytes = xlsReport.toByteArray();
            return bytes;
            } 
            catch (Exception e) {
		throw new GenericException(e.getMessage(), e);
            }
    }

    @Override
    public byte[] runReportToExcel(FileInputStream xmlSource,
			DynamicReport dynReport, String strQuery) throws GenericException {
	try {
            JasperPrint jasperPrint = fillOperation(xmlSource, dynReport, strQuery);
            ByteArrayOutputStream xlsReport = new ByteArrayOutputStream();
            try {
		this.getApiXlsExporter(xlsReport, jasperPrint).exportReport();
            } 
            catch (Exception e) {
		logger.warn( "Erreur de g�n�ration de l'�tat avec l'API JExcelApi : "
                        + e.getMessage()
			+ "\n Tentative avec l'API POI...", e);
		this.getCommonXlsExporter(xlsReport, jasperPrint).exportReport();
            }

            // Send response
            byte[] bytes = xlsReport.toByteArray();
            return bytes;
	} 
        catch (Exception e) {
            throw new GenericException(e.getMessage(), e);
	}
    }

	// ---------------------------------------------------------------------------//
	// ---------------------------------------------------------------------------//

    @Override
    public byte[] runReportToExcelx(FileInputStream xmlSource, String jasperfile)
			throws GenericException {
        try {
            JasperPrint jasperPrint = fillOperation(xmlSource, jasperfile);
            ByteArrayOutputStream xlsReport = new ByteArrayOutputStream();
            this.getCommonXlsxExporter(xlsReport, jasperPrint).exportReport();

            // get response
            byte[] bytes = xlsReport.toByteArray();
            return bytes;
        } 
        catch (Exception e) {
            throw new GenericException(e.getMessage(), e);
	}
    }

    @Override
    public byte[] runReportToExcelx(FileInputStream xmlSource,
			DynamicReport dynReport, String strQuery) throws GenericException {
	try {
            JasperPrint jasperPrint = fillOperation(xmlSource, dynReport,strQuery);
            ByteArrayOutputStream xlsReport = new ByteArrayOutputStream();
            this.getCommonXlsxExporter(xlsReport, jasperPrint).exportReport();
            // get response
            byte[] bytes = xlsReport.toByteArray();
            return bytes;
	} 
        catch (Exception e) {
            throw new GenericException(e.getMessage(), e);
	}
    }

    // ---------------------------------------------------------------------------//
    // ---------------------------------------------------------------------------//

    @Override
    public byte[] runReportToCsv(FileInputStream xmlSource, String jasperfile)
			throws GenericException {
        try {
            JasperPrint jasperPrint = fillOperation(xmlSource, jasperfile);
            ByteArrayOutputStream csvReport = new ByteArrayOutputStream();
            this.getCommonCsvExporter(csvReport, jasperPrint).exportReport();
            // get response
            byte[] bytes = csvReport.toByteArray();
            return bytes;
	} 
        catch (Exception e) {
            throw new GenericException(e.getMessage(), e);
	}
    }

    @Override
    public byte[] runReportToCsv(FileInputStream xmlSource,
		DynamicReport dynReport, String strQuery) throws GenericException {
	try {
            JasperPrint jasperPrint = fillOperation(xmlSource, dynReport,strQuery);
            ByteArrayOutputStream csvReport = new ByteArrayOutputStream();
            this.getCommonCsvExporter(csvReport, jasperPrint).exportReport();
            // get response
            byte[] bytes = csvReport.toByteArray();

            	return bytes;
	} 
        catch (Exception e) {
            throw new GenericException(e.getMessage(), e);
	}
    }

    // ---------------------------------------------------------------------------//
    @Override
    public byte[] runReportToHtml(FileInputStream xmlSource, String jasperfile)
                    throws GenericException {
        try {
            JasperPrint jasperPrint = fillOperation(xmlSource, jasperfile);
            JasperExportManager.exportReportToHtmlFile(jasperPrint,"./Temp_file.html");
            // FileInputStream fio = new FileInputStream(new
            // File("./Temp_file.html"));
            // byte[] result = fio.
            return null;
        } 
        catch (Exception e) {
            throw new GenericException(e.getMessage(), e);
        }
    }

    @Override
    public byte[] runReportToHtml(FileInputStream xmlSource, 
                DynamicReport dynReport, String strQuery) throws GenericException {
        try {
            JasperPrint jasperPrint = fillOperation(xmlSource, dynReport,strQuery);
            JasperExportManager.exportReportToHtmlFile(jasperPrint,"./Temp_file.html");
            // FileInputStream fio = new FileInputStream(new
            // File("./Temp_file.html"));
            // byte[] result = fio.
            return null;
        } 
        catch (Exception e) {
            throw new GenericException(e.getMessage(), e);
        }
    }

    // ----PDF------------------------------------------------------------//

    @Override
    public byte[] runReportToPdf(FileInputStream xmlSource, String jasperfile)
			throws GenericException {
        try {
            JasperPrint jasperPrint = fillOperation(xmlSource, jasperfile);
            return JasperExportManager.exportReportToPdf(jasperPrint);
        } 
        catch (Exception e) {
            throw new GenericException(FrameLocaleUtil
                .getLocalizedString(FrameLocaleKeyConstants.CFRAME_TEXT_91), e);
        }
    }
	
    @Override
    public byte[] runReportToPdf(FileInputStream xmlSource, String jasperfile, 
              String licence) throws GenericException {
        try {
            JasperPrint jasperPrint = fillOperation(xmlSource, jasperfile,licence);
            return JasperExportManager.exportReportToPdf(jasperPrint);
        } 
        catch (Exception e) {
            throw new GenericException(FrameLocaleKeyConstants.CFRAME_TEXT_91, e);
        }
    }


    @Override
    public byte[] runReportToPdf(FileInputStream xmlSource,
            DynamicReport dynReport, String strQuery) throws GenericException {
        try {
            JasperPrint jasperPrint = fillOperation(xmlSource, dynReport,strQuery);
            return JasperExportManager.exportReportToPdf(jasperPrint);
        } 
        catch (Exception e) {
            throw new GenericException(FrameLocaleKeyConstants.CFRAME_TEXT_91, e);
        }
    }

    // ---RTF-------------------------------------------------------------//

    @Override
    public byte[] runReportToRtf(FileInputStream xmlSource, String jasperfile)
		throws GenericException {
        return null;
    }
    
    @Override
    public byte[] runReportToRtf(FileInputStream xmlSource, 
                DynamicReport dynReport, String strQuery) throws GenericException {
        return null;
    }

    // --PRINTER-------------------------------------------------------------------------//

    @Override
    public byte[] runReportToPrinter(FileInputStream xmlSource,
			String jasperfile, String printerAlias) throws GenericException {
        try {
            // FileInputStream xmlSource = new FileInputStream(xmlFile);
            JasperPrint jasperPrint = fillOperation(xmlSource, jasperfile);
            PrinterJob job = PrinterJob.getPrinterJob();
            // Reccupere le tableau des imprimantes disponibles
            logger.debug("[runReportToPrinter] Reccupere le tableau des imprimantes disponibles");
            PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
            int selectedService = -1;

            for (int i = 0; i < services.length; i++) {
		logger.debug("[runReportToPrinter] Imprimante : "
				+ services[i].getName().toUpperCase());
            }
            // Retrouver l'imprimante concern�

            logger.debug("[runReportToPrinter] Recherche de l'imprimante dans la liste des services dispo : "
							+ printerAlias);
            for (int i = 0; i < services.length; i++) {
		if (services[i].getName().toUpperCase().contains(
			printerAlias.toUpperCase())) {
                    // Si le service est ce qu'il souhaite
                    selectedService = i;
		}
            }

            // D�finit le service d'impression dans le Job
            job.setPrintService(services[selectedService]);

            if (selectedService == -1) throw new GenericException(
		FrameLocaleUtil.getLocalizedString(FrameLocaleKeyConstants.CFRAME_TEXT_95)
		+ printerAlias
		+ FrameLocaleUtil.getLocalizedString(FrameLocaleKeyConstants.CFRAME_TEXT_96));
                logger.debug("[runReportToPrinter] Imprimates Trouv�e : "
		+ services[selectedService].getName());
            // D�finition des attributs de l'impression
            PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
            // MediaSizeName mediaSizeName = MediaSize.findMedia(4, 4,
            // MediaPrintableArea.INCH);
            // printRequestAttributeSet.add(mediaSizeName);
            printRequestAttributeSet.add(new Copies(1));

            JRPrintServiceExporter exporter;
            exporter = new JRPrintServiceExporter();

            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);

            // On pr�cise dans les parametres le service d'impression
            exporter.setParameter(
                JRPrintServiceExporterParameter.PRINT_SERVICE,
                services[selectedService]);
            exporter.setParameter(
                JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET,
                services[selectedService].getAttributes());
            exporter.setParameter(
                JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET,
                printRequestAttributeSet);
            exporter.setParameter(
                JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG,Boolean.FALSE);
            exporter.setParameter(
                JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG,Boolean.FALSE);

            logger.debug("[runReportToPrinter] lance effectivement l'impression");
            exporter.exportReport();

            return null;// JasperExportManager.exportReportToPdf(jasperPrint);
	} 
        catch (Exception e) {
		throw new GenericException(e.getMessage());                        
		}
	}

    private JRCsvExporter getCommonCsvExporter(
		ByteArrayOutputStream outputStream, JasperPrint jprint) {
	JRCsvExporter exporterCSV = new JRCsvExporter();

	exporterCSV.setParameter(JRCsvExporterParameter.JASPER_PRINT, jprint);
	exporterCSV.setParameter(JRCsvExporterParameter.OUTPUT_STREAM, outputStream);

	exporterCSV.setParameter(JRCsvExporterParameter.FIELD_DELIMITER, ";");
	exporterCSV.setParameter(JRCsvExporterParameter.RECORD_DELIMITER, "\n\n");
	return exporterCSV;
    }

    @SuppressWarnings("deprecation")
    private JRXlsxExporter getCommonXlsxExporter(
			ByteArrayOutputStream outputStream, JasperPrint jprint) {
	JRXlsxExporter exporter = new JRXlsxExporter();

	exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jprint);
	exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, outputStream);

	exporter.setParameter(JRXlsExporterParameter.IGNORE_PAGE_MARGINS, Boolean.TRUE);
	exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
	exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
	exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
	exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
	exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
	return exporter;
    }

    @SuppressWarnings( { "deprecation" })
    private JRXlsExporter getCommonXlsExporter(
		ByteArrayOutputStream outputStream, JasperPrint jprint) {
	JRXlsExporter exporter = new JRXlsExporter();

	Map dateFormats = new HashMap();
	dateFormats.put("EEEEE, dd MMMMM yyyy � HH:mm:ss", "ddd, mmm d, yyyy");

	exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jprint);
	exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, outputStream);

	exporter.setParameter(JRXlsExporterParameter.FORMAT_PATTERNS_MAP, dateFormats);
	exporter.setParameter(JRXlsExporterParameter.IGNORE_PAGE_MARGINS, Boolean.TRUE);
	exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
	exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
	exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
	exporter.setParameter(
		JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,Boolean.TRUE);
	exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
	return exporter;
    }

    @SuppressWarnings("deprecation")
    private JExcelApiExporter getApiXlsExporter(
		ByteArrayOutputStream outputStream, JasperPrint jprint) {
        JExcelApiExporter exporter = new JExcelApiExporter();

	exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jprint);
	exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, outputStream);

	exporter.setParameter(JExcelApiExporterParameter.IGNORE_PAGE_MARGINS, Boolean.TRUE);
	exporter.setParameter(JExcelApiExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
	exporter.setParameter(JExcelApiExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
	exporter.setParameter(JExcelApiExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
	exporter.setParameter(JExcelApiExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
	exporter.setParameter(JExcelApiExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);

	return exporter;
    }

    /*
     * Remplace les caractères indésirables d'un FileImputStream XML par un
     * espace et retourne FileImputStrean nettoyé. Ils sont de la forme
     * &#[xX]([0-9a-fA-f]+)
     */

    private FileInputStream cleanXmlFileImputStream(
			FileInputStream xmlSourceStream) throws GenericException {

        try {
            File xmlFileOut = File.createTempFile("tempClean", ".xml");
            FileOutputStream xmlStreamOut = new FileOutputStream(xmlFileOut);

            int c;
            String line = "";
            while ((c = xmlSourceStream.read()) != -1) {
		if (c == Constants.CHAR_FL) { // Si fin d'une ligne atteinite
                    line += (char) c;

                    // Netoyage de la ligne
                    line = line.replaceAll(Constants.XML_BAD_CHAR_PATTERN, Constants.XML_REPLACE);

                    // Ecrire dans le fichier
                    for (int i = 0; i < line.length(); i++) {
			c = (int) line.charAt(i);
			xmlStreamOut.write(c);
                    }
                    line = "";
                    continue; // repart au depart de la boucle
		}
                line += (char) c;
            } 

            // Traitement de la dernière ligne du fichier
            line.replaceAll(Constants.XML_BAD_CHAR_PATTERN, Constants.XML_REPLACE);
            if (!line.equals("")) {
		for (int i = 0; i < line.length(); i++) {
                    c = (int) line.charAt(i);
                    xmlStreamOut.write(c);
		}
		line = "";
            }

            xmlSourceStream.close();
            xmlStreamOut.close();
            return new FileInputStream(xmlFileOut.getAbsolutePath());

	} catch (FileNotFoundException e) {
		System.err.println("Fichier non trouvé :  " + e);
		throw new GenericException(
            		FrameLocaleUtil.getLocalizedString(FrameLocaleKeyConstants.CFRAME_TEXT_92), e);
		}

		catch (Exception e) {
			throw new GenericException(
				FrameLocaleUtil.getLocalizedString(FrameLocaleKeyConstants.CFRAME_TEXT_93), e);
		}

	}

    private FileInputStream cleanXmlFile(FileInputStream xmlSourceStream)
			throws GenericException {
        try {
            StringBuilder xmlStrBuilder = new StringBuilder();
            InputStreamReader streamReader = new InputStreamReader(xmlSourceStream);
            BufferedReader reader = new BufferedReader(streamReader);
            String str = reader.readLine();

            while (str != null) {
                xmlStrBuilder.append(str.replaceAll(
                    Constants.XML_BAD_CHAR_PATTERN, Constants.XML_REPLACE));
            }

            String versionXml = "<?xml version=\"1.0\" encoding=\""
				+ Constants.XML_ENCODING + "\"?>";

            // produire le nouveau fichier Xml
            File xmlFileOut = File.createTempFile("tempClean", ".xml");
            // File xmlFile = new File("temp", ".xml");
            System.out.println(xmlFileOut.getAbsolutePath());

            // Enregistrement du résultat dans un fichier
            FileWriter fw = new FileWriter(xmlFileOut);

            // Ecriture de l'entete du fichier
            fw.write(versionXml);

            // Ecriture du contenu XML
            fw.write(xmlStrBuilder.toString());
            fw.close();

            return new FileInputStream(xmlFileOut);

        } 
        catch (FileNotFoundException e) {
            System.err.println("Fichier non trouv� :  " + e);
            throw new GenericException(FrameLocaleUtil.getLocalizedString(FrameLocaleKeyConstants.CFRAME_TEXT_92), e);
        } 
        catch (Exception e) {
            throw new GenericException(FrameLocaleUtil.getLocalizedString(FrameLocaleKeyConstants.CFRAME_TEXT_93), e);
        }
    }	
}