package com.sample.frame.fe.helper;

import java.util.Locale;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

/**
 * Classe d'internationalisation des messages
 * 
 */
public class FacesLocaleMessages extends LocaleMessages {
	
   /**
    * Obtention de la locale courante à partir du contexte d'exécution
    * @param context Contexte d'execution de la requ�te
    * 
    * @return La locale courante sinon la locale par d�faut
    */
   public static Locale getLocale(FacesContext context) {
	   
      Locale locale = null;
      
      UIViewRoot viewRoot = context.getViewRoot();
      if (viewRoot != null) locale = viewRoot.getLocale();
      if (locale == null) locale = Locale.getDefault();
      
      return locale;
   }
   
   /**
    * Méthode d'obtention d'un message (paramétré) configuré dans un fichier d'internationalisation <br>
    * La locale est déterminé à partir du contexte d'exécution de la requête
    *
    * @param bundle		Fichier de configuration des messages
    * @param resourceId	Identifiant du message
    * @param params		Param�tres du message
    * 
    * @return			Message internationalisé
    */
   public static String getString(String bundle, String resourceId, Object... params) {
	  
	  // Contexte d'ex�cution
      FacesContext context = FacesContext.getCurrentInstance();
      
      // Bundle par défaut
      Application app = context.getApplication();
      String appBundle = app.getMessageBundle();
      
      // Locale
      Locale locale = getLocale(context);
      
      // ClassLoader
      ClassLoader loader = getClassLoader();
      
      return getString(appBundle, bundle, resourceId, locale, loader, params);
   }     
      
    
   /**
    * Méthode d'obtention d'un message (avec entête et détail) configuré dans un fichier d'internationalisation <br>
    * La locale est déterminé à partir du contexte d'exécution de la requête
    * 
    * @param bundleName		Fichier de configuration des messages
    * @param summaryResourceId	Identifiant de l'entête du message 
    * @param detailResourceId	Identifiant du détail du  message 
    * @param params		Paramètres du message
    * 
    * @return			Entête & Détail du message
    */
   public static FacesMessage getMessage(String bundleName, String summaryResourceId, String detailResourceId, Object... params) {
	   
      // Contexte d'exécution
      FacesContext context = FacesContext.getCurrentInstance();
      
      // Bundle par d�faut
      Application app = context.getApplication();
      String appBundle = app.getMessageBundle();
      
      // Locale
      Locale locale = getLocale(context);
      
      // ClassLoader
      ClassLoader loader = getClassLoader();
      
      // Entête
      String summary = getString(appBundle, bundleName, summaryResourceId, locale, loader, params);
      if (summary == null) summary = getNotFoundedMessageTemplate(summaryResourceId);
      
      // Détail
      String detail = getString(appBundle, bundleName, detailResourceId, locale, loader, params);
      if (detail == null) detail = getNotFoundedMessageTemplate(detailResourceId);
   
      return new FacesMessage(summary, detail);
   }
 
   
   /**
    * Méthode d'obtention d'un message (avec entête et détail) configuré dans un fichier d'internationalisation <br>
    * La locale est déterminé à partir du contexte d'ex�cution de la requête <br>
    * l'identifiant du détail du message étant celui de l'entête suffixé de <code>_detail</code>
    * 
    * @param bundleName	Fichier de configuration des messages
    * @param resourceId	Identifiant de l'ent�te du message
    * @param params	Paramêtres du message
    * 
    * @return		Entête & D�tail du message
    */
   public static FacesMessage getMessage(String bundleName, String resourceId, Object[] params) {
	   return getMessage(bundleName, resourceId, resourceId + "_detail", params);
   } 
   
}