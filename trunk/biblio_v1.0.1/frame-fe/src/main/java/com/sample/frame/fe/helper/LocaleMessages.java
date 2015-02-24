package com.sample.frame.fe.helper;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Classe d'internationalisation des messages
 * 
 */
public class LocaleMessages {
	

   /**
    * M�thode d'obtention d'un message (param�tr�) configur� dans un fichier d'internationalisation
    * 
    * @param bundle1 	1er   Fichier de configuration de messages
    * @param bundle2	2i�me Fichier de configuration de messages
    * @param resourceId	Identifiant du message
    * @param locale		Locale � utiliser
    * @param loader		ClassLoader
    * @param params		Param�tres du message
    * 
    * @return			Message internationalis�
    */
   public static String getString(String bundle1, String bundle2, String resourceId, Locale locale, ClassLoader loader, Object... params) {
      
	   // Ressource � retrouver
	  String resource = null;
	  
	  // Fichier de config
      ResourceBundle bundle;
      
      if (bundle1 != null) {
    	 
    	 // Initialisation du fichier 1
         bundle = ResourceBundle.getBundle(bundle1, locale, loader);
         if (bundle != null)
            try {
               // Obtention de la ressource
               resource = bundle.getString(resourceId);
            } 
            catch (MissingResourceException ex) { }
      }

      if (resource == null && bundle2 != null) {
    	  
     	 // Initialisation du fichier 2
         bundle = ResourceBundle.getBundle(bundle2, locale, loader);
         if (bundle != null)
            try {
                // Obtention de la ressource
               resource = bundle.getString(resourceId);
            } 
            catch (MissingResourceException ex) { }
      }

      if (resource == null) return getNotFoundedMessageTemplate(resourceId); // no match
      if (params == null) return resource;
      
      // Formattage du message
      MessageFormat formatter = new MessageFormat(resource, locale);      
      return formatter.format(params);
   }   

   
   /**
    * Obtention du ClassLoader
    * 
    * @return le ClassLoader
    */
   public static ClassLoader getClassLoader() {
	   
	   // Obtention du ClassLoader du thread courant
      ClassLoader loader = Thread.currentThread().getContextClassLoader();
      
      // S'il n'existe pas, obtention du ClassLoader syst�me
      if (loader == null) loader = ClassLoader.getSystemClassLoader();
      
      return loader;
   }
   
   
   /**
    * Retourne un template pour les messages non trouv�s via leur identifiant
    * 
    * @param resourceId Identifiant du message
    * 
    * @return ???<code>resourceId</code>???
    */
   public static String getNotFoundedMessageTemplate(String resourceId){
	   return "???" + resourceId + "???";
   }
    
}