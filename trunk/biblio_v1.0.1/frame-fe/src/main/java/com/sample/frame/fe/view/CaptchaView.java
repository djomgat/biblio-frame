/*

*/
package com.sample.frame.fe.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
/**
 *
 * @author ECHOUPE
 * usage dans la vue:
 * <h:form>
 *   <p:messages showDetail="true"/>
 *   <p:captcha label="Captcha" />
 *   <p:commandButton value="Check" actionListener="#{captchaView.submit}" ajax="false" icon="ui-icon-check"/>
 * </h:form>
 * 
 */
@ManagedBean
public class CaptchaView {
     
    public void submit() {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correct", "Correct");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}