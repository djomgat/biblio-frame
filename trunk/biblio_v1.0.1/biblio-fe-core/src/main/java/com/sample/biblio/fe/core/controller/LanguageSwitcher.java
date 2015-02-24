
package com.sample.biblio.fe.core.controller;

import com.sample.frame.fe.exception.FrontEndException;
import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 * Used for managing i18n in application for each user
 * @author ECHOUPE
 *
 */
@ManagedBean
@SessionScoped
public class LanguageSwitcher implements Serializable {
    private static final long serialVersionUID = 2756934361134603857L;
    private static final Logger LOG = Logger.getLogger(LanguageSwitcher.class.getName());
   
    private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
    private String selectedLanguage = locale.getLanguage();
    
    public Locale getLocale() {
        return locale;        
    }

    public String getLanguage() {
        return locale.getLanguage();
    }   

    public String getDisplayLanguage() {
        return locale.getDisplayLanguage();
    }
    
    public String getSelectedLanguage() {
        return selectedLanguage;
    }
    
    public void setSelectedLanguage(String _selectedLanguage) throws Exception {
        selectedLanguage = _selectedLanguage;
        locale = new Locale(_selectedLanguage);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
        LOG.info( "selectedLanguage = " + _selectedLanguage + " - locale.getLanguage = " + locale.getLanguage());
    }  
  
}