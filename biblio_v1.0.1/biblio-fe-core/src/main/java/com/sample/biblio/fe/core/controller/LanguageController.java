
package com.sample.biblio.fe.core.controller;

import com.sample.frame.fe.exception.FrontEndException;
import java.io.Serializable;
import java.util.Locale;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

/**
 * Used for managing i18n in application for each user
 * @author ECHOUPE
 *
 */
@ManagedBean
@SessionScoped
public class LanguageController implements Serializable {
    private static final long serialVersionUID = 2756934361134603857L;
    private static final Logger LOG = Logger.getLogger(LanguageController.class.getName());
   
    //New
    private String localeCode;
    
    private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
    private String selectedLanguage = locale.getLanguage();
    
    private static Map<String, Object> countries;
    static {
        countries = new LinkedHashMap<String, Object>();
        countries.put("Français", Locale.forLanguageTag("fr-FR")); // label, value
        countries.put("English", Locale.ENGLISH); // label, value
        countries.put("Turkey", Locale.forLanguageTag("tr-TR"));
    }    
    /* Pour une construction manuelle dans l'interface
    <h:selectOneMenu value="#{languageController.localeCode}" onchange="submit()" 
         valueChangeListener="#{languageController.countryLocaleCodeChanged}">
         <f:selectItems value="#{languageController.countriesInMap}" />   
     </h:selectOneMenu>
    */
    
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
    
    // New 
    public String getLocaleCode() {
            return localeCode;
    }

    public void setLocaleCode(String localeCode) {
            this.localeCode = localeCode;
    }    
    
    //New
    public Map<String, Object> getCountriesInMap() {
        return countries;
    }    
    
    public void setSelectedLanguage(String _selectedLanguage) throws Exception {
        selectedLanguage = _selectedLanguage;
        locale = new Locale(_selectedLanguage);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
        LOG.info( "selectedLanguage = " + _selectedLanguage + " - locale.getLanguage = " + locale.getLanguage());
    } 
    
    public void countryLocaleCodeChanged(ValueChangeEvent e) {
        System.out.println("locale changed");
        String newLocaleValue = e.getNewValue().toString();

        // loop country map to compare the locale code
        for (Map.Entry<String, Object> entry : countries.entrySet()) {
            if (entry.getValue().toString().equals(newLocaleValue)) {
                    FacesContext.getCurrentInstance().getViewRoot()
                        .setLocale((Locale) entry.getValue());
            }
        }
        //System.out.println("login scoped bean");
        //messageBundle = ResourceBundle.getBundle("com.packt.messages",FacesContext.getCurrentInstance().getViewRoot().getLocale());
        //String loginmessage=messageBundle.getString("login.login"); 
        //loginBean.setLoginmessage(loginmessage);
    }    
  
}