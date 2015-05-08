
package com.sample.biblio.fe.core.filter.shiro;

import com.sample.frame.core.logging.BaseLogger;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.filter.authz.PortFilter;
import org.apache.shiro.web.filter.authz.SslFilter;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;

/**
 * ShiroAuthenticatingFilter permet de rediriger la communication vers le port non sécurisé
 * après connexion.
 * @author ECHOUPE
 */
public class ShiroAuthenticatingFilter extends FormAuthenticationFilter {
    
    private static final BaseLogger logger = BaseLogger.getLogger(ShiroAuthenticatingFilter.class) ;

    private int port = PortFilter.DEFAULT_HTTP_PORT;

    private String indexUrl = "/";

    public void setPort( int port ) {
        this.port = port;
    }

    public void setIndexUrl( String indexUrl ) {
        this.indexUrl = indexUrl;
    }

    @Override
    protected boolean onLoginSuccess( AuthenticationToken token, Subject subject, 
              ServletRequest request, ServletResponse response ) throws Exception {
        boolean result = true;
        String reqScheme = request.getScheme();
        if( SslFilter.HTTPS_SCHEME.equals( reqScheme ) ) {
            HttpServletRequest httpReq = null;
            if( request instanceof HttpServletRequest ) {
                httpReq = WebUtils.toHttp( request );
                String uri;
                String query;
                SavedRequest savedRequest = WebUtils.getSavedRequest( request );
                if( savedRequest == null ) {
                    uri = httpReq.getRequestURI();
                    query = httpReq.getQueryString();
                }
                else {
                    uri = savedRequest.getRequestURI();
                    query = savedRequest.getQueryString();
                }
                String redirectUrl = fromHttps( httpReq, uri, query );
                WebUtils.issueRedirect( request, response, redirectUrl, null, false );
                result = false;
            }
            else {
                logger.warn( "request is not an instance of HttpServletRequest: {}" + request.getClass().toString() );
                result = true;
            }
        }
        else {
            result = super.onLoginSuccess( token, subject, request, response );
        }
        return result;
    }

    private String fromHttps( HttpServletRequest request, String uri, String query ) {
        StringBuilder sb = new StringBuilder();
        try {
            URL originalURL = new URL( request.getRequestURL().toString() );
            sb.append( PortFilter.HTTP_SCHEME );
            sb.append( "://" );
            sb.append( originalURL.getHost() );
            if( originalURL.getPort() != port && port != PortFilter.DEFAULT_HTTP_PORT ) {
                sb.append( ":" );
                sb.append( port );
            }
            String path = originalURL.getPath();
            int semiPos = path.indexOf( ";" ); // if there was pathParameter data it should have been on the original request, it sometimes seems be missing from request.getPathInfo()?
            String pathParameters = "";
            if( semiPos > 0 ) {
                pathParameters = path.substring( semiPos );
            }
            semiPos = uri.indexOf( ";" ); // pathParameter data may be present on uri (from a saved request), if so, throw it away as it may be from a bookmark
            if( semiPos > 0 ) {
                uri = uri.substring( 0, semiPos );
            }
            if( uri.endsWith( getLoginUrl() ) ) {
                int loginPos = uri.indexOf( getLoginUrl() );
                String contextPath = uri.substring( 0, loginPos );
                sb.append( contextPath );
                sb.append( indexUrl );
            }
            else {
                sb.append( uri );
            }
            sb.append( pathParameters );
            if( query != null ) {
                sb.append( "?" ).append( query );
            }
            logger.info( "redirect url is : {}" + sb.toString() );
        }
        catch( MalformedURLException e ) {
            logger.error( "cannot construct request URL", e );
        }
        return sb.toString();
    }

}


