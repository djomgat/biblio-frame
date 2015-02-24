/**
 * 
 */
package com.sample.frame.fe.controller;

import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 * Bean en charge de la gestion des locales <br>
 * Il peut aussi bien être défini et utilisé aussi bien en Request qu'en Session
 */
@ManagedBean
@RequestScoped
public class LocaleController  extends BaseController {

    private static final long serialVersionUID = 1L;
	
    /**
     * Locale courante
     */
    private String locale = FacesContext.getCurrentInstance().getViewRoot().getLocale().getLanguage();
	
    /**
     * Constructeur par d�faut
     */
    public LocaleController(){
	super();
    }

    /**
     * @return the locale
     */
    public String getLocale() {
    	return locale;
    }

    /**
     * @param locale the locale to set
     */
    public void setLocale(String locale) {
	this.locale = locale;
    }

    /**
     * Définit la locale de l'application
     * 
     */
    public void changeLocale(){
	FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(this.getLocale()));		
    }	
	
    /**
     * Définit la locale de l'application
     * 
     * @param locale	Locale (fr, en, us, de, ...)
     */
    public void changeLocale(String locale){
	FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(locale));
    }

}