/**
 * 
 */
package com.sample.frame.fe.helper;

import java.io.Serializable;
import java.util.Date;

/**
 * Classe de base encapsulant les informations de session d'un utilisateur
 * 
 *
 */
public class UserSessionInfos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * ID de la session
	 */
	private String sessionId;

	/**
	 * Login de l'utilisateur
	 */
	private String login;
	
	/**
	 * Date & heure de connection
	 */
	private Date loginDate;
	
	/**
	 * Date & heure de d�connection
	 */
	private Date logoutDate;

	/**
	 * Adresse IP du poste de connection
	 */
	private String ipAdress;

	/**
	 * Navigateur utilisé (dans le cas des applications web)
	 */
	private String browser;
	
	/**
	 * Constructeur paar défaut
	 */
	public UserSessionInfos(){ 	}
	
	public UserSessionInfos(String login){
		this.setLogin(login);
	}
	
	/**
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the loginDate
	 */
	public Date getLoginDate() {
		return loginDate;
	}

	/**
	 * @param loginDate the loginDate to set
	 */
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	/**
	 * @return the logoutDate
	 */
	public Date getLogoutDate() {
		return logoutDate;
	}

	/**
	 * @param logoutDate the logoutDate to set
	 */
	public void setLogoutDate(Date logoutDate) {
		this.logoutDate = logoutDate;
	}

	/**
	 * @return the ipAdress
	 */
	public String getIpAdress() {
		return ipAdress;
	}

	/**
	 * @param ipAdress the ipAdress to set
	 */
	public void setIpAdress(String ipAdress) {
		this.ipAdress = ipAdress;
	}

	/**
	 * @return the browser
	 */
	public String getBrowser() {
		return browser;
	}

	/**
	 * @param browser the browser to set
	 */
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	
}