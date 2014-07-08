/**
 * 
 */
package com.sample.frame.fe.controller;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ComponentSystemEvent;

import com.sample.frame.fe.exception.FrontEndException;
import com.sample.frame.fe.helper.CoreConstants;
import com.sample.frame.fe.helper.FacesUtil;




/**
 * Classe de base en charge de l'authentification d'un utilisateur <br>
 * Pourrait �tre utilis�e et red�finie par les developpeurs afin d'y impl�menter le m�canisme d'authentification propre � leur application
 * 
 *
 */

public abstract class  AbstractLoginController  extends BaseController {

	private static final long serialVersionUID = 1L;

	/**
	 * user login
	 */
	private String userLogin;
	
	/**
	 * user password
	 */
	private String userPassword;
	
	
	/**
	 * Constructeur par d�faut
	 */
	public AbstractLoginController(){
		super();
	}


	/**
	 * @return the userLogin
	 */
	public String getUserLogin() {
		return userLogin;
	}


	/**
	 * @param userLogin the userLogin to set
	 */
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}


	/**
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}


	/**
	 * @param userPassword the userPassword to set
	 */
	public void setuserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
	
	/**
	 * Authentifie un utilisateur <br>
	 * 
	 * @return	La r�gle de navigation vers la vue appropri�e
	 */
	public String login(){
		
		// R�gle de navigation
		String navigationRule = null;
				
		try {
			
			// Invocation du service d'authentification
			navigationRule = this.be_login(userLogin, userPassword);
			
			// MAJ du contexte d'authentification
			FacesUtil.setSessionMapValue(CoreConstants.IS_LOGGED_IN, true);			

		} 
		catch (FrontEndException e) {
			// Message d'information
			this.addErrorMessage("", e.getMessage());
		}
				
		return navigationRule;
	}
	
	
	/**
	 * Deconnecte un utilisateur
	 * 
	 * @return	La r�gle de navigation vers la vue d'authentification
	 */
	public String logout(){
		
		// R�gle de navigation
		String navigationRule = null;
		
		 try {
			 
			//Invocation du service de deconnexion 
			this.be_logout();
			
			// TODO : Invalidation de la session utilisateur
			
			// Navigation vers la vue d'authentification
			navigationRule = this.getNavigationRuleToLoginView();
		} 
		 catch (FrontEndException e) {
			this.addErrorMessage("", e.getMessage());
		}
		 
		 return navigationRule;
	}
	
	
	/**
	 * V�rifie lors de l'acc�s � une vue (page), si l'utilisateur est authentifi� sinon redirige vers la vue d'authentification <br>
	 * C'est une des impl�mentations pour la v�rification de l'authentification <br>
	 * Afin de v�rifier l'authentification cette m�thode peut �tre exploit�e directement dans les vues � s�curiser comme suit : <br>
	 * <code>f:view</code> Mettre le contenu de la vue dans cette balise <br> 
	 * <code> f:event type="preRenderView" listener="#{loginController.checkLogin}" </code> <br>
	 * <code>...</code> <br>
	 * @param event
	 */
   public void checkLogin(ComponentSystemEvent event) throws AbortProcessingException {   
	   	   
	   // Si l'on se trouve sur une vue son s�curis�e alors pas de cont�le n�cessaire
	   // TODO - Impl�menter ce scenario
	   if(false) return;	
	   
	   // Contr�le
      if (! this.isLoggedIn()) {
         FacesContext context = FacesContext.getCurrentInstance();
         ConfigurableNavigationHandler handler = (ConfigurableNavigationHandler) context.getApplication().getNavigationHandler();
         
         handler.performNavigation(this.getNavigationRuleToLoginView());
      }
   } 
   
   
   /**
    * Indique si un utilisateur est connect� ou authentifi� <br>
    * Recherche la valeur (true, false, null) de la cl� <code> CoreConstants.IS_LOGGED_IN </code> dans le scope session
    * @return
    */
   public boolean isLoggedIn() { 
	   Object o = FacesUtil.getSessionMapValue(CoreConstants.IS_LOGGED_IN);
	   
	   if(o == null) return false;
	   return new Boolean(o.toString());
   }
   
   
   /**
    * D�finit la r�gle de navigation d'acc�s au formulaire d'authentification <br>
    * Peut �tre red�finie par le d�veloppeur si la valeur par d�faut n'est pas convenable
    * 
    * @return <code>login</code> est la valeur retourn�e par d�faut
    */
   protected String getNavigationRuleToLoginView(){
	   return "login";
   }
   
        
   /**
    * M�thode devant invoquer le service de connexion BE
    * 
    * @param login
    * @param password
    * 
    * @return La r�gle de navigation vers la prochaine vue
    */
   protected abstract String be_login(String login, String password) throws FrontEndException ;
   
   
   /**
    * M�thode devant invoquer le service de deconnexion BE
    */
   protected abstract void be_logout() throws FrontEndException ;
			
}
