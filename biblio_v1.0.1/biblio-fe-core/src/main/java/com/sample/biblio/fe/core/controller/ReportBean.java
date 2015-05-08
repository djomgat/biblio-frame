/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.biblio.fe.core.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.apache.commons.io.IOUtils;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
/**
 *
 * @author ECHOUPE
 */
// <p:media value="#{ReportBean.streamedContent}" width="100%" height="500px" player="pdf" />
@ManagedBean
@RequestScoped   // pourquoi pas @ApplicationScoped
public class ReportBean {
    private static final long serialVersionUID = 1L;
    private StreamedContent streamedContent;
    
    //@EJB
    //private ReportService service;

    @PostConstruct     
    public void init() {
        try {
        //----------------------------------
        Document doc = new Document();

        OutputStream out = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(doc, out);

        doc.open();
        doc.add(new Paragraph("Hello World. ok........"));
        doc.close(); 
        out.close();

        InputStream in =new ByteArrayInputStream(((ByteArrayOutputStream)out).toByteArray());

        streamedContent = new DefaultStreamedContent(in, "application/pdf");
        //-------
        Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        byte[] b = (byte[]) session.get("reportBytes");
        if (b != null) {
            streamedContent = new DefaultStreamedContent(new ByteArrayInputStream(b), "application/pdf");
        }            
        } catch (Exception e) {
        }

    }
    //==================================================================
    public StreamedContent getStreamedContent() {
        if (FacesContext.getCurrentInstance().getRenderResponse()) {
            return new DefaultStreamedContent();
        } else {
            return streamedContent;
        }
     }
    
    //==================================================================
    public void setStreamedContent(StreamedContent streamedContent) {
        this.streamedContent = streamedContent;
    }
    
    /*
    public void showPDF(jasperPrint)
    {
        try {
            HttpServletResponse httpServletResponse;httpServletResponse = 
                    (HttpServletResponse)  getContext().getExternalContext().getResponse();

            httpServletResponse.setContentType("application/pdf");
            httpServletResponse.addHeader("Content-disposition", "inline;filename=testReport.pdf");
            ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();

            JasperExportManager.exportReportToPdfStream(jasperPrint,servletOutputStream);

            getContext().responseComplete();
            getContext().renderResponse();

        } catch (JRException | IOException ex) {
            Logger.getLogger(CertificateApplicationAddBacking.class.getName()).log(Level.SEVERE, null, ex);
          getContext().addMessage(null, new FacesMessage("Could not generate report")); 
        } 

    }
    */
    
    /*  à vérifier et corriger
    public void showWebViewer (String filePath) {
      
      final FacesContext fc = FacesContext.getCurrentInstance();
      ExternalContext ec = fc.getExternalContext();
      
      System.out.println("Preparing sending file to browser...");
      ec.responseReset(); 
      ec.setResponseContentType(ec.getMimeType(filePath)); 
      ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + filePath + "\""); 

      InputStream input = new FileInputStream(filePath);
      OutputStream output = ec.getResponseOutputStream();
      IOUtils.copy(input, output);
      System.out.println("Sending to browser...");
      fc.responseComplete();
    } 
    */
    
    
}
