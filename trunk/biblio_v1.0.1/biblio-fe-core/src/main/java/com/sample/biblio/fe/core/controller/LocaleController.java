/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.biblio.fe.core.controller;

import java.io.Serializable;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author ECHOUPE
 */
@ManagedBean
@SessionScoped
public class LocaleController implements Serializable {
    private final Locale FRENCH = Locale.FRENCH;
    private final Locale ENGLISH = Locale.ENGLISH;
    private Locale locale = FRENCH;
    
    public Locale getLocale() {
        return(locale);
    }
    
    public void setFrench(ActionEvent event) {
        locale = FRENCH;
        updateViewLocale();
    }   
    
    public void setEnglish(ActionEvent event) {
        locale = ENGLISH;
        updateViewLocale();
    }
   
    private void updateViewLocale() {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }
    
    public String displayLanguage() {
        return (Locale.getDefault().getDisplayLanguage());
    } 
    
    public String revertLocale() {
       // if locale.toString().equals("ENGLISH")
       // if locale.e.getDisplayLanguage() = ENGLISH) then locale = FRENCH;
       return (Locale.getDefault().getDisplayLanguage());
    }
    
    public String changeUS(){
        FacesContext context = FacesContext.getCurrentInstance();
        context.getViewRoot().setLocale(Locale.US);
        context.getApplication().setDefaultLocale(context.getViewRoot().getLocale()); 
        return null;
    }
}