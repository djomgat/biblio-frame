/*
 * and open the template in the editor.
 */
package com.sample.frame.core.report.viewer;

/**
 *  En cours de test : objectif Affichage d'un rapport jasper dans le browser 
 * @author ECHOUPE
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

public class ServletWebReportViewer extends  HttpServlet{

    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
                                           throws ServletException, IOException{

        ServletOutputStream servletOutputStream = response.getOutputStream();
        InputStream reportStream = getServletConfig().getServletContext().getResourceAsStream("/reports/FirstReport.jasper");

        try{
            JasperRunManager.runReportToPdfStream(reportStream, servletOutputStream, new HashMap(), new JREmptyDataSource());
            response.setContentType("application/pdf");
            servletOutputStream.flush();
            servletOutputStream.close();
        } catch(JRException e){
            //display stack trace in the browser
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            response.setContentType("text/plain");
            response.getOutputStream().print(stringWriter.toString());
        }
    } 
    
    public static void openInBrowser(String url) {
        try {
            
        } catch (Exception e) {
            ////
        }
    }
}