/**
 * 
 */
package com.sample.biblio.fe.core.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.sample.frame.fe.controller.AbstractLoginController;
import com.sample.frame.fe.exception.FrontEndException;

/**
 * Contr�leur en charge de l'authentification
 * 
 */
@ManagedBean
@RequestScoped
public class LoginController extends AbstractLoginController {

	private static final long serialVersionUID = 1L;

	
	/**
	 * Constructeur par d�faut
	 */
	public LoginController() {
		
	}

	
	@Override
	protected String be_login(String login, String password) throws FrontEndException {

		System.out.println("LoginController.be_login : login = " + login + " & password = " + password);

		// R�gle de navigation
		String navigationRule = null;
		
		if(login != null && login.equals(password)) {			
			navigationRule = "home";
		} 
		
		else {
			this.addErrorMessage("Echec de l'authentification", "login ou mot de passe incorrects");
		} 
			
		return navigationRule;
	}

	@Override
	protected void be_logout() throws FrontEndException{
		// TODO Auto-generated method stub
	}

}
