/*

 */
package com.sample.frame.core.report.jasper;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ECHOUPE
 * <p:commandButton action="#{sampleBB.printJasper}"
 *   ajax="false" onclick="this.form.target='_blank'"
 *   value="#{msg['generate.report']}" />
 */
public class JasperJSFViewer {
    
//    public void displayFile(String _title, String _filename, 
//                            String _fileExt, String _mimeType) {
//
//        ByteArrayOutputStream out = null;
//        ByteArrayInputStream input = null;
//        BufferedOutputStream output = null;
//
//        FacesContext facesContext = FacesContext.getCurrentInstance();
//        ExternalContext externalContext = facesContext.getExternalContext();
//        HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
//
//        try {
//            FileInputStream fin = new FileInputStream(_filename);
//            output = new BufferedOutputStream(response.getOutputStream(), Constants.DEFAULT_BUFFER_SIZE);
//
//            ServletOutputStream outStream = response.getOutputStream();
//            // SET THE MIME TYPE.
//            response.setHeader("Content-Length", String.valueOf(out.toByteArray().length));
//            response.setContentType("application/" + _mimeType);
//            response.setHeader("Content-Disposition", "attachment;filename="+_title+"."+_fileExt);
//            
//            output = new BufferedOutputStream(response.getOutputStream(), Constants.DEFAULT_BUFFER_SIZE);
//            byte[] buffer = new byte[Constants.DEFAULT_BUFFER_SIZE];
//            int length;
//            while ((length = input.read(buffer)) != -1) {
//                output.write(buffer, 0, length);
//                //System.out.println(buffer);
//            }
//            output.flush();
//        } catch (Exception exception) {
//             /* ... */
//        } finally {
//            try {
//                 if (output != null) {
//                    output.close();
//                 }
//                 if (input != null) {
//                    input.close();
//                 }
//          } catch (Exception exception) {
//                    /* ... */
//         }
//         }
//         facesContext.responseComplete();
//    }
}
