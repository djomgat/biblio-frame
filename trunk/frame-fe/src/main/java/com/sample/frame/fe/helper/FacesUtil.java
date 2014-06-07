package com.sample.frame.fe.helper;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 * Ensemble de méthodes utilitaires pour JSF <br>
 * Toutes les méthodes définies dans cette classe sont des méthodes statiques 
 *  
 *
 */
public class FacesUtil {
	
	/**
	 * Récupération d'un paramètre dans le Scope Request 
	 * 
	 * @param name	Nom du param�tre 
	 * @return	Le param�tre concern� ou <code>null</code> s'il n'existe pas
	 */
	 public static String getRequestParameter(String name) {
		 return (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(name);
	 }
	 
	 /**
	  * Récupération d'un objet dans l'Entête de la requête 
	  * 
	  * @param key	Clé identifiant l'objet.
	  * @return	L'objet concern� ou <code>null</code> s'il n'existe pas.
	  */
	  public static Object getHeaderMapValue(String key) {
	        return FacesContext.getCurrentInstance().getExternalContext().getRequestHeaderMap().get(key);
	    }	 

	  /**
	  * Recupération du Scope Session 
	  * 
	  * @return	Le Map contenant les donn�es de niveau session
	  */
	 public static Map<String,Object> getSessionMap() {
	        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	    }	  
	  
	 /**
	  * Recupération d'un objet dans le scope Session 
	  * 
	  * @param key	Clé identifiant l'objet 
	  * @return	L'objet concern� ou <code>null</code> s'il n'existe pas
	  */
	 public static Object getSessionMapValue(String key) {
	        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(key);
	    }
	   	  
	 /**
	  * Injection d'un objet dans le scope Session
	  * 
	  * @param key		Clé identifiant l'objet.
	  * @param value	Valeur associée à la clé.
	  */
	 public static void setSessionMapValue(String key, Object value) {
	        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(key, value);
	   }
	 
	 
	 /**
	  * Retrait d'un objet  dans le scope Session 
	  * 
	  * @param key	Cl� identifiant l'objet 
	  */
	 public static void removeSessionMapValue(String key) {
	        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(key);
	    }	 
	 
	 /**
	  * Recup�ration d'un objet dans le scope Application 
	  * 
	  * @param key	Cl� identifiant l'objet 
	  * @return		L'objet concern� ou <code>null</code> s'il n'existe pas
	  */
	  public static Object getApplicationMapValue(String key) {
	        return FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get(key);
	    }
	  
	 /**
	  * Injection d'un objet dans le scope Application 
	  * 
	  * @param key      Clé identifiant l'objet 
	  * @param value    Valeur associée à la clé 
	  */
	 public static void setApplicationMapValue(String key, Object value) {
	        FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().put(key, value);
	    }
	 	  	 
	/**
	 * Récupération d'un paramètre dans un objet évènement <code>ActionEvent</code>
	 * 
	 * @param event	Evènement 
	 * @param name	Nom du paramètre
	 * @return	L'attribut associé
	 */
	 public static Object getActionAttribute(ActionEvent event, String name) {
		 return event.getComponent().getAttributes().get(name);
	 }
	  	  
	/**
	 * Recherche et retourne une instance d'un bean managé à partir de son nom<br>
	 * Si ce dernier n'existe pas, il sera créé
	 * 
	 * @param beanName	Nom du bean managé
	 * @param beanClass	Classe du bean managé
	 * @return		Instance du bean managé typé
	 */
	public static <T> T findManagedBean(String beanName, Class<T> beanClass){
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		return beanClass.cast(context.getApplication().evaluateExpressionGet(context, "#{" + beanName + "}", beanClass));
	}
		
	/**
	 * Recherche et retourne une instance d'un bean managé à partir de son nom<br>
	 * Si ce dernier n'existe pas, il sera créé.
	 * 
	 * @param beanName	Nom du bean managé
	 * @return		Instance du bean managé non typé.
	 */	
	public static Object findManagedBean(String beanName){
		FacesContext context = FacesContext.getCurrentInstance();
		return context.getApplication().evaluateExpressionGet(context, "#{" + beanName + "}", Object.class);
	}
		
	/***
	 * Recherche du nom ou de la clé d'une instance d'un bean managé 
	 * 
	 * @param bean	Nom du bean 
	 * @return	Le nom du bean ou <code>null</code> s'il n'existe pas
	 */
	public static String findManagedBeanName(Object bean) {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

        // Get requestmap.
        Map<String, Object> requestMap = externalContext.getRequestMap();
    
        // Lookup the current bean instance in the request scope.
        for (String key : requestMap.keySet()) {
            if (bean.equals(requestMap.get(key))) {
                // The key is the managed bean name.
                return key;
            }
        }
    
        // Bean is not in the request scope. Get the sessionmap then.
        Map<String, Object> sessionMap = externalContext.getSessionMap();

        // Lookup the current bean instance in the session scope.
        for (String key : sessionMap.keySet()) {
            if (bean.equals(sessionMap.get(key))) {
                // The key is the managed bean name.
                return key;
            }
        }

        // Bean is also not in the session scope. Get the applicationmap then.
        Map<String, Object> applicationMap = externalContext.getApplicationMap();

        // Lookup the current bean instance in the application scope.
        for (String key : applicationMap.keySet()) {
            if (bean.equals(applicationMap.get(key))) {
                // The key is the managed bean name.
                return key;
            }
        }

        // Bean is also not in the application scope.
        // Is the bean's instance actually a managed bean instance then? =)
        return null;
    }
	

	 /***
	  * Ajout d'un message applicatif 
	  * 
	  * 
	  * @param id		Id du composant graphique affichant le message 
	  * @param summary	Entête du message 
	  * @param detail	Détails du message 
	  * @param severity	Sévérité du message
	  */
	public static void addMessage(String id,String summary,String detail,FacesMessage.Severity severity){
       
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage();
            facesMessage.setSeverity(severity);
            facesMessage.setSummary(summary);
            facesMessage.setDetail(detail);
            facesContext.addMessage(id, facesMessage);
	}		
	
	/**
	 * Ajout d'un message de sévérité INFO
	 * 
	 * @param id		Id du composant graphique affichant le message  
	 * @param summary	Entéte du message 
	 * @param detail	Détails du message 
	 */
	public static void addInfoMessage(String id, String summary,String detail){
                addMessage(id, summary, detail, FacesMessage.SEVERITY_INFO);
	}	
	
	/**
	 * Ajout d'un message de sévérité WARNING
	 * 
	 * @param id		Id du composant graphique affichant le message  
	 * @param summary	Entêtte du message 
	 * @param detail	Détails du message 
	 */
	public static void addWarnMessage(String id, String summary,String detail){
                addMessage(id, summary, detail, FacesMessage.SEVERITY_WARN);
	}
	
	/***
	 * Ajout d'un message de sévérité ERROR
	 * 
	 * @param id		Id du composant graphique affichant le message 
	 * @param summary	Entête du message 
	 * @param detail	Détails du message 
	 */
	public static void addErrorMessage(String id, String summary,String detail){
                addMessage(id, summary, detail, FacesMessage.SEVERITY_ERROR);
	}	

	/**
	 * Ajout d'un message de sévérité FATAL
	 * 
	 * @param id		Id du composant graphique affichant le message 
	 * @param summary	Entête du message 
	 * @param detail	Détails du message 
	 */
	public static void addFatalMessage(String id, String summary,String detail){
                addMessage(id, summary, detail, FacesMessage.SEVERITY_FATAL);
	}
		
}
