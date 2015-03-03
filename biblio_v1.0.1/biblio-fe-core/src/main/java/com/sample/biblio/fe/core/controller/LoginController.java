/**
 * 
 */
package com.sample.biblio.fe.core.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.sample.frame.fe.controller.AbstractLoginController;
import com.sample.frame.fe.exception.FrontEndException;
import javax.faces.context.FacesContext;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * Contrôleur en charge de l'authentification
 * 
 */
@ManagedBean
@RequestScoped
public class LoginController extends AbstractLoginController {

	private static final long serialVersionUID = 1L;
        
/**
        Realm realm = 
        //instantiate or acquire a Realm instance.  We'll discuss Realms later.
        SecurityManager securityManager = new DefaultSecurityManager(realm);
        //Make the SecurityManager instance available to the entire application via static memory:
        SecurityUtils.setSecurityManager(securityManager);
**/        
        
        
        //-- récupération du subject de Shiro l user après déclaration dans web.xml-->
        Subject currentUser = SecurityUtils.getSubject();

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
            //HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	    //session.invalidate();
	    //return "/index?faces-redirect=true";
	}        

       
	protected String be_login_shiro(String login, String password) throws FrontEndException {

            //  Récupérer de la session de l'utilisateur 
            Session session = currentUser.getSession();
            session.setAttribute( "someKey", "aValue" );
            
            // Règle de navigation
            String navigationRule = null;
        
            if ( !currentUser.isAuthenticated() ) {
                UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
                //this is all you have to do to support 'remember me' (no config - built in!):
                token.setRememberMe(true);
                try {
                    currentUser.login( token );
                    //if no exception, that's it, we're done!
                    //print their identifying principal (in this case, a username):
                    //log.info( "User [" + currentUser.getPrincipal() + "] logged in successfully." );
                    if ( currentUser.hasRole( "schwartz" ) ) {
                        //log.info("May the Schwartz be with you!" );
                    } else {
                            //log.info( "Hello, mere mortal." );
                    }
                    
                    navigationRule = "home";
                    return navigationRule;

                } catch ( UnknownAccountException uae ) {
                //username wasn't in the system, show them an error message?
                } catch ( IncorrectCredentialsException ice ) {
                //password didn't match, try again?
                } catch ( AuthenticationException ae ) {
                    //unexpected condition - error?
                }
            }
            return navigationRule;
        }
        
        //@Override
	protected void be_logout_shiro() throws FrontEndException{
            //Shiro removes all identifying information and invalidates their session too.
            currentUser.logout();
	}


}