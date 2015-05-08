/*

 */
package com.sample.biblio.fe.web.view.misc;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
import org.primefaces.util.Constants;

/**
 *
 * @author ECHOUPE
 */
public class JasperViewer {
    public static final int DEFAULT_BUFFER_SIZE = Integer.parseInt(
        System.getProperty("org.apache.jasper.Constants.DEFAULT_BUFFER_SIZE", "8192"));   
    
    public void printJasper() {
       JasperReport compiledTemplate = null;
       JRExporter exporter = null;
       ByteArrayOutputStream out = null;
       ByteArrayInputStream input = null;
       BufferedOutputStream output = null;


       FacesContext facesContext = FacesContext.getCurrentInstance();
       ExternalContext externalContext = facesContext.getExternalContext();
       HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();

       try {
           List<String> sampleList = new ArrayList<String>();
           sampleList.add("Fist sample string");
           sampleList.add("Second sample string");

           JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(sampleList);
           Map<String, Object> reportValues = new HashMap<String, Object>();
           reportValues.put("anyTestValue", "test value");

           facesContext = FacesContext.getCurrentInstance();
           externalContext = facesContext.getExternalContext();
           response = (HttpServletResponse) externalContext.getResponse();

           FileInputStream file = new FileInputStream("/any_dir/sample.jasper");
           compiledTemplate = (JasperReport) JRLoader.loadObject(file);

           out = new ByteArrayOutputStream();
           JasperPrint jasperPrint = JasperFillManager.fillReport(compiledTemplate, reportValues, beanCollectionDataSource);

           exporter = new JRPdfExporter();
           exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
           exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
           // afficher la boîte de dialogue pour l'impression
           exporter.setParameter(JRPdfExporterParameter.PDF_JAVASCRIPT, "this.print();");
           exporter.exportReport();

           input = new ByteArrayInputStream(out.toByteArray());

           response.reset();
           response.setHeader("Content-Type", "application/pdf");
           response.setHeader("Content-Length", String.valueOf(out.toByteArray().length));
           response.setHeader("Content-Disposition", "inline; filename=\"fileName.pdf\"");
           output = new BufferedOutputStream(response.getOutputStream(), DEFAULT_BUFFER_SIZE);

           byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
           int length;
           while ((length = input.read(buffer)) > 0) {
               output.write(buffer, 0, length);
           }
           output.flush();

       } catch (Exception exception) {
           /* ... */
       } finally {
           try {
               if (output != null) {
                   output.close();
               }
               if (input != null) {
                   input.close();
               }
           } catch (Exception exception) {
               /* ... */
           }
       }
       facesContext.responseComplete();
   }   
}

/** Usage
<p:commandButton action="#{sampleBB.printJasper}"
    ajax="false" onclick="this.form.target='_blank'"
    value="#{msg['generate.report']}" >
    <p:printer target="pdf" />
</p:commandButton>

*/
