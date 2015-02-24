/*
 */
package com.sample.biblio.fe.core.controller;
 
import java.util.logging.Logger;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
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

import com.sample.frame.fe.helper.FacesUtil;
 
/**
 * Simple JSF Controller demonstrating Shiro login/logout process.
 *
 * @author Glen Smith
 */
//@Model
@ManagedBean
@RequestScoped
public class ShiroLoginController {
 
    String username;
    String password;
    boolean rememberMe = false;
 
    private static final Logger log = Logger.getLogger(ShiroLoginController.class.getName());
 
    public String authenticate() {
        
        // Règle de navigation
        String navigationRule = null;
        
        // Authentification via base de données
        Realm realm = new JdbcRealm();
        DefaultSecurityManager securityManager = new DefaultSecurityManager(realm);
        
        // Example using most common scenario of username/password pair:
        UsernamePasswordToken token = new UsernamePasswordToken(username,
                password);
 
        // "Remember Me" built-in:
        token.setRememberMe(rememberMe);
 
        Subject currentUser = SecurityUtils.getSubject();
 
        log.info("Before Submitting login with username of " + username
                + " and password of " + password);
 
        try {
            currentUser.login(token);
            navigationRule = "home";
            log.info("Authentication success : " + username);
            
        } catch (UnknownAccountException uae ) {
            //username wasn't in the system, show them an error message?
        	String strMsg = "Login Failed: The username you entered is invalid " + username;
            log.info(strMsg);
            
            FacesUtil.addWarnMessage(null, strMsg, uae.toString());
            log.severe(uae.getMessage());
        } catch ( IncorrectCredentialsException ice ) {
            //password didn't match, try again?
            
            String strMsg = "user password didn't match, try again?";
            log.info(strMsg);
            
            FacesUtil.addWarnMessage(null, strMsg, ice.toString());
            log.severe(ice.getMessage());
            
        } catch ( LockedAccountException lae ) {
            //account for that username is locked - can't login.  Show them a message?
            
            String strMsg = "account for that username is locked - can't login.";
            log.info(strMsg);
            
            FacesUtil.addWarnMessage(null, strMsg, lae.toString());
            log.severe(lae.getMessage());
            
        } catch (AuthenticationException e) {
            // Could catch a subclass of AuthenticationException if you like
            log.warning(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage("Login Failed: " + e.getMessage(), e
                            .toString()));
            return "/login";
        }
        //return "protected?faces-redirect=true";
        return navigationRule;
 
    }
 
    public String logout() {
 
        Subject currentUser = SecurityUtils.getSubject();
        log.info("Log-out the user " + username
                + " and password of " + password);
        try {
            currentUser.logout();
            log.info("Logging-out success for : " + username);
        } catch (Exception e) {
            log.warning(e.toString());
        }
        return "index";
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