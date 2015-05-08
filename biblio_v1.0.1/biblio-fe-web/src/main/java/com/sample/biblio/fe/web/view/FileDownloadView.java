/*

 */
package com.sample.biblio.fe.web.view;

import java.io.InputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
public class FileDownloadView {
    
    private StreamedContent file;
	
	public FileDownloadView() {        
        InputStream stream = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("/resources/demo/images/optimus.jpg");
		file = new DefaultStreamedContent(stream, "image/jpg", "downloaded_optimus.jpg");
	}

    public StreamedContent getFile() {
        return file;
    }
}

/**  download.xhtml
<p:dialog modal="true" widgetVar="statusDialog" header="Status" draggable="false" closable="false" resizable="false">
    <p:graphicImage name="/demo/images/ajaxloadingbar.gif" />
</p:dialog>

<h:form>
    <p:commandButton value="Download" ajax="false" onclick="PrimeFaces.monitorDownload(start, stop);" icon="ui-icon-arrowthick-1-s">
        <p:fileDownload value="#{fileDownloadView.file}" />
    </p:commandButton>
</h:form>

<script type="text/javascript">
function start() {
    PF('statusDialog').show();
}

function stop() {
    PF('statusDialog').hide();
}
</script>
* 
*/



