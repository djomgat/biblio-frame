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
    * Obtention de la locale courante � partir du contexte d'ex�cution
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
    * M�thode d'obtention d'un message (param�tr�) configur� dans un fichier d'internationalisation <br>
    * La locale est d�termin� � partir du contexte d'ex�cution de la requ�te
	*
    * @param bundle		Fichier de configuration des messages
    * @param resourceId	Identifiant du message
    * @param params		Param�tres du message
    * 
    * @return			Message internationalis�
    */
   public static String getString(String bundle, String resourceId, Object... params) {
	  
	  // Contexte d'ex�cution
      FacesContext context = FacesContext.getCurrentInstance();
      
      // Bundle par d�faut
      Application app = context.getApplication();
      String appBundle = app.getMessageBundle();
      
      // Locale
      Locale locale = getLocale(context);
      
      // ClassLoader
      ClassLoader loader = getClassLoader();
      
      return getString(appBundle, bundle, resourceId, locale, loader, params);
   }     
      
    
   /**
    * M�thode d'obtention d'un message (avec ent�te et d�tail) configur� dans un fichier d'internationalisation <br>
    * La locale est d�termin� � partir du contexte d'ex�cution de la requ�te
    * 
    * @param bundle				Fichier de configuration des messages
    * @param summaryResourceId	Identifiant de l'ent�te du message 
    * @param detailResourceId	Identifiant du d�tail du  message 
    * @param params				Param�tres du message
    * 
    * @return			Ent�te & D�tail du message
    */
   public static FacesMessage getMessage(String bundleName, String summaryResourceId, String detailResourceId, Object... params) {
	   
	  // Contexte d'ex�cution
      FacesContext context = FacesContext.getCurrentInstance();
      
      // Bundle par d�faut
      Application app = context.getApplication();
      String appBundle = app.getMessageBundle();
      
      // Locale
      Locale locale = getLocale(context);
      
      // ClassLoader
      ClassLoader loader = getClassLoader();
      
      // Ent�te
      String summary = getString(appBundle, bundleName, summaryResourceId, locale, loader, params);
      if (summary == null) summary = getNotFoundedMessageTemplate(summaryResourceId);
      
      // Detail
      String detail = getString(appBundle, bundleName, detailResourceId, locale, loader, params);
      if (detail == null) detail = getNotFoundedMessageTemplate(detailResourceId);
   
      return new FacesMessage(summary, detail);
   }
 
   
   /**
    * M�thode d'obtention d'un message (avec ent�te et d�tail) configur� dans un fichier d'internationalisation <br>
    * La locale est d�termin� � partir du contexte d'ex�cution de la requ�te <br>
    * l'identifiant du d�tail du message �tant celui de l'ent�te suffix� de <code>_detail</code>
    * 
    * @param bundle		Fichier de configuration des messages
    * @param resourceId	Identifiant de l'ent�te du message
    * @param params		Param�tres du message
    * 
    * @return			Ent�te & D�tail du message
    */
   public static FacesMessage getMessage(String bundleName, String resourceId, Object[] params) {
	   return getMessage(bundleName, resourceId, resourceId + "_detail", params);
   }
 
   
}