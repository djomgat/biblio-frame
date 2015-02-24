package com.sample.frame.fe.helper;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


/**
 * Ensemble de m�thodes utilitaires pour JSF <br>
 * Toutes les m�thodes d�finies dans cette classe sont des m�thodes statiques 
 *  
 *
 */
public class FacesUtil {

	
	/**
	 * R�cup�ration d'un param�tre dans le Scope Request 
	 * 
	 * @param name	Nom du param�tre 
	 * @return		Le param�tre concern� ou <code>null</code> s'il n'existe pas
	 */
	 public static String getRequestParameter(String name) {
		 return (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(name);
	 }

	 
	 /**
	  * R�cuperation d'un objet dans l'Ent�te de la requete 
	  * 
	  * @param key	Cl� identifiant l'objet
	  * @return		L'objet concern� ou <code>null</code> s'il n'existe pas
	  */
	  public static Object getHeaderMapValue(String key) {
	        return FacesContext.getCurrentInstance().getExternalContext().getRequestHeaderMap().get(key);
	    }	 
	 

	  /**
	  * Recup�ration du Scope Session 
	  * 
	  * @return		Le Map contenant les donn�es de niveau session
	  */
	 public static Map<String,Object> getSessionMap() {
	        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	    }	  
	  
	 /**
	  * Recup�ration d'un objet  dans le scope Session 
	  * 
	  * @param key	Cl� identifiant l'objet 
	  * @return		L'objet concern� ou <code>null</code> s'il n'existe pas
	  */
	 public static Object getSessionMapValue(String key) {
	        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(key);
	    }
	   
	  
	 /**
	  * Injection d'un objet dans le scope Session
	  * 
	  * @param key		Cl� identifiant l'objet 
	  * @param value	Valeur associ�e � la cl�
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
	  * @param key		Cl� identifiant l'objet 
	  * @param value	Valeur associ�e � la cl� 
	  */
	 public static void setApplicationMapValue(String key, Object value) {
	        FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().put(key, value);
	    }
	 	  
	 
	/**
	 * Recup�ration d'un param�tre dans un objet �v�nement <code>ActionEvent</code>
	 * 
	 * @param event	Ev�nement 
	 * @param name	Nom du param�tre
	 * @return		L'attribut associ�
	 */
	 public static Object getActionAttribute(ActionEvent event, String name) {
		 return event.getComponent().getAttributes().get(name);
	 }
	  
	  
	/**
	 * Recherche et retourne une instance d'un bean manag� � partir de son nom<br>
	 * Si ce dernier n'existe pas, il sera cr��
	 * 
	 * @param beanName	Nom du bean manag�
	 * @param beanClass	Classe du bean manag�
	 * @return			Instance du bean manag� typ�
	 */
	public static <T> T findManagedBean(String beanName, Class<T> beanClass){
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		return beanClass.cast(context.getApplication().evaluateExpressionGet(context, "#{" + beanName + "}", beanClass));
	}
	
	
	/**
	 * Recherche et retourne une instance d'un bean manag� � partir de son nom<br>
	 * Si ce dernier n'existe pas, il sera cr��
	 * 
	 * @param beanName	Nom du bean manag�
	 * @return			Instance du bean manag� non typ�
	 */	
	public static Object findManagedBean(String beanName){
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		return context.getApplication().evaluateExpressionGet(context, "#{" + beanName + "}", Object.class);
	}
	
	
	
	/***
	 * Recherche du nom ou de la cl� d'une instance d'un bean manag� 
	 * 
	 * @param bean	Nom du bean 
	 * @return		Le nom du bean ou <code>null</code> s'il n'existe pas
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
	  * @param summary	Ent�te du message 
	  * @param detail	D�tails du message 
	  * @param severity	S�v�rit� du message
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
	 * Ajout d'un message de s�v�rit� INFO
	 * 
	 * @param id		Id du composant graphique affichant le message  
	 * @param summary	Ent�te du message 
	 * @param detail	D�tails du message 
	 */
	public static void addInfoMessage(String id, String summary,String detail){
        
        addMessage(id, summary, detail, FacesMessage.SEVERITY_INFO);
	}	
	
	/**
	 * Ajout d'un message de s�v�rit� WARNING
	 * 
	 * @param id		Id du composant graphique affichant le message  
	 * @param summary	Ent�te du message 
	 * @param detail	D�tails du message 
	 */
	public static void addWarnMessage(String id, String summary,String detail){
        
        addMessage(id, summary, detail, FacesMessage.SEVERITY_WARN);
	}
	
	/***
	 * Ajout d'un message de s�v�rit� ERROR
	 * 
	 * @param id		Id du composant graphique affichant le message 
	 * @param summary	Ent�te du message 
	 * @param detail	D�tails du message 
	 */
	public static void addErrorMessage(String id, String summary,String detail){
        
        addMessage(id, summary, detail, FacesMessage.SEVERITY_ERROR);
	}	

	/**
	 * Ajout d'un message de s�v�rit� FATAL
	 * 
	 * @param id		Id du composant graphique affichant le message 
	 * @param summary	Ent�te du message 
	 * @param detail	D�tails du message 
	 */
	public static void addFatalMessage(String id, String summary,String detail){
        
        addMessage(id, summary, detail, FacesMessage.SEVERITY_FATAL);
	}
		
}
