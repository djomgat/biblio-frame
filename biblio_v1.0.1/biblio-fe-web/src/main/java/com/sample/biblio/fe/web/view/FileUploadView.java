/*

 */
package com.sample.biblio.fe.web.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
 
@ManagedBean
public class FileUploadView {
 
    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}

/** Usage 
 * 
 * // Single.xhtml
<h:form>
    <p:fileUpload fileUploadListener="#{fileUploadView.handleFileUpload}" mode="advanced" dragDropSupport="false"
           update="messages" sizeLimit="100000" fileLimit="3" allowTypes="/(\.|\/)(gif|jpe?g|png)$/" />
 
    <p:growl id="messages" showDetail="true" />
</h:form>
* 
*  //Multiple.xhtml
<h:form>
    <p:fileUpload fileUploadListener="#{fileUploadView.handleFileUpload}" mode="advanced" dragDropSupport="false"
           update="messages" sizeLimit="100000" fileLimit="3" allowTypes="/(\.|\/)(gif|jpe?g|png)$/" />
 
    <p:growl id="messages" showDetail="true" />
</h:form>
 */