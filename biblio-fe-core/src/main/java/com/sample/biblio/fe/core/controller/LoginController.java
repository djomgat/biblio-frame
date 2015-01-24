/**
 * 
 */
package com.sample.biblio.fe.core.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.sample.frame.fe.controller.AbstractLoginController;
import com.sample.frame.fe.exception.FrontEndException;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
//import javax.servlet.http.HttpSession;


/**
 * Contrôleur en charge de l'authentification
 * 
 */
@ManagedBean
@RequestScoped
public class LoginController extends AbstractLoginController {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur par défaut
	 */
	public LoginController() {
		
	}

	
	@Override
	protected String be_login(String login, String password) throws FrontEndException {

		System.out.println("LoginController.be_login : login = " + login + " & password = " + password);

		// Règle de navigation
		String navigationRule = null;
		
		if(login != null && login.equals(password)) {			
			navigationRule = "home";
		} else {
			this.addErrorMessage("Echec de l'authentification", "login ou mot de passe incorrects");
		} 			
		return navigationRule;
	}

	@Override
	protected void be_logout() throws FrontEndException{
		// TODO Auto-generated method stub
		//HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	    //session.invalidate();
	    //return "/index?faces-redirect=true";

	}

}