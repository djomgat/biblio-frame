/*
 */
package com.sample.biblio.fe.core.controller;
 
import com.sample.frame.fe.controller.AbstractLoginController;
import com.sample.frame.fe.exception.FrontEndException;
import com.sample.frame.core.logging.BaseLogger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.session.Session;

import com.sample.frame.fe.helper.FacesUtil;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
 
/**
 * Simple JSF Controller demonstrating Shiro login/logout process.
 *
 * @author Glen Smith
 */
//@Model
@ManagedBean
@RequestScoped
public class ShiroLoginController extends AbstractLoginController {
     
    String username;
    String password;
    boolean rememberMe = false;
	
    private static final long serialVersionUID = 1L;
    
    public static final String HOME_URL = "login.xhtml";

    private static final BaseLogger log = BaseLogger.getLogger(ShiroLoginController.class) ;
    
    @Override
    protected String be_login(String login, String password1) throws FrontEndException {

        // Les paramètres passés sont ignorés !!!!
        
        // Règle de navigation
        String navigationRule = null;
        
        // Authentification via base de données
        Realm realm = new JdbcRealm();
        DefaultSecurityManager securityManager = new DefaultSecurityManager(realm);
        
        // Example using most common scenario of username/password pair:
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
 
        // "Remember Me" built-in:
        token.setRememberMe(rememberMe);
 
        Subject currentUser = SecurityUtils.getSubject();
 
        try {
            String strMsg ="Before Submitting login with username of " + username
                + " and password of " + password;
            log.info(strMsg);
            currentUser.login(token);
            navigationRule = "home";
            strMsg="Authentication success : " + username;
            log.info(strMsg);
            
            //  Récupérer de la session de l'utilisateur 
            Session userSession = currentUser.getSession(true);
            userSession.setAttribute( "username", username );
            
            if(currentUser.isAuthenticated()){
                Date loginTime = userSession.getStartTimestamp();
                //Date lastAccessTime = userSession.getLastAccessTime(); //last active time
                long timeout = (long)(userSession.getTimeout()* 0.001); // get sessiontime out in seconds
                long oneMinleft = timeout - 60 ; // get time to show timeout dialog before 1 min of session timeout
                String userHost = userSession.getHost();
                log.info("User login time is: " + loginTime);
                log.info("User session idle time-out is (s): " + timeout);
                log.info("User seconds left to timeout(s) is: " + oneMinleft);
                log.info("User login host is : " + userHost);
            }              
            
            
        } catch (UnknownAccountException uae ) {
            //username wasn't in the system, show them an error message?
            String strMsg = "Login Failed: The username you entered is invalid " + username;
            log.info(strMsg);
            
            FacesUtil.addWarnMessage(null, strMsg, uae.toString());
            log.warn(uae.getMessage());
        } catch ( IncorrectCredentialsException ice ) {
            //password didn't match, try again?
            
            String strMsg = "user password didn't match, try again?";
            log.info(strMsg);
            
            FacesUtil.addWarnMessage(null, strMsg, ice.toString());
            log.warn(ice.getMessage());
            
        } catch ( LockedAccountException lae ) {
            //account for that username is locked - can't login.  Show them a message?
            
            String strMsg = "account for that username is locked - can't login.";
            log.info(strMsg);
            
            FacesUtil.addWarnMessage(null, strMsg, lae.toString());
            log.warn(lae.getMessage());
            
        } catch (AuthenticationException e) {
            // Could catch a subclass of AuthenticationException if you like
            log.warn(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage("Login Failed: " + e.getMessage(), e.toString()));
            return "/login";
        }
        //return "protected?faces-redirect=true";
        return navigationRule;
 
    }
 
    @Override
    protected void be_logout() throws FrontEndException{
        //Shiro removes all identifying information and invalidates their session too.
        Subject currentUser = SecurityUtils.getSubject();

        try {

            // Détermine la durée de la session de l'utilisateur
            Session userSession = currentUser.getSession();
                        
            Date startTime = userSession.getStartTimestamp(); //login time
            long timeout = (long)(userSession.getTimeout()* 0.001); // get sessiontime out in seconds
            //long oneMinleft =    timeout - 60 ; // get time to show timeout dialog before 1 min of session timeout
            log.info("User Login time is: " + startTime);
            log.info("User session time-out is (s): " + timeout);
            Date date = new Date();
            log.info("Log out time is (s): " + date.toString() );
            //Convert Date to new java 8 format
            //Instant instant = Instant.ofEpochMilli(startTime.getTime());
            
//            Problème de version de Java
//            LocalDateTime dt1 = LocalDateTime.ofInstant(startTime.toInstant(), ZoneId.systemDefault());
//            LocalDateTime dtf = LocalDateTime.now(); 
//            Period p = Period.between(dt1.toLocalDate(), dtf.toLocalDate());
//            log.info("Session duratio is " + p.getYears() + " years, " + p.getMonths() + " months, and " + p.getDays() );

            username=(String)userSession.getAttribute("username");
            String strMsg ="Log-out the user " + username;
            log.info(strMsg);
            
            //removes all identifying information and invalidates their session too.
            currentUser.logout();
            
            strMsg="Logging-out success for : " + username;
            log.info(strMsg);
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            //FacesContext.getCurrentInstance().getExternalContext().redirect(HOME_URL);
            
            
        } catch (Exception e) {
            log.warn(e.toString());
        }

    }
    
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public boolean getRememberMe() {
        return rememberMe;
    }
 
    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }
 
}