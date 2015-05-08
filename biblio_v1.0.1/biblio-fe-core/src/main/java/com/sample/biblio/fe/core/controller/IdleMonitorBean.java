/*

 */
package com.sample.biblio.fe.core.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
/**
 *
 * @author ECHOUPE
 */
@ManagedBean(name = "IdleMonitorBean")
public class IdleMonitorBean {
    
    private long userTimeout;

    public long getUserTimeout() {
        Subject currentUser = SecurityUtils.getSubject();
        Session userSession = currentUser.getSession(true);
        
        userTimeout = (long)(userSession.getTimeout());
        // Déclencher l'alerte 1 minutes avant le timeout d'inactivité configuré dans shiro
        if (userTimeout >= 60000 * 2)  userTimeout = userTimeout - 60000;
        return userTimeout;
    }

    public void setUserTimeout(long userTimeout) {
        this.userTimeout = userTimeout;

    }
    
    public void welcomeListener() {
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_WARN, 
                    "#{msg['session.timeout.idlemonitor.welcome.header']}", 
                    "#{msg['session.timeout.idlemonitor.welcome.message']}")); 
    }

    public void logoutListener() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().addMessage(
            null,
            new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "#{msg['session.timeout.idlemonitor.logout.header']}", 
                    "#{msg['session.timeout.idlemonitor.logout.message']}"));
        //shiroLoginController.logout();        
        // invalidate session, and redirect to other pages
    }  
    
}