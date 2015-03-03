package com.sample.frame.be.interceptor;

import com.sample.frame.core.exception.GenericException;
import com.sample.frame.core.logging.BaseLogger;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author ECHOUPE
 */
public class AuditTraceInterceptor {
    
    private static final BaseLogger logger = BaseLogger
                                .getLogger(AuditTraceInterceptor.class.getName());    
    
    @AroundInvoke
    public Object auditInvocation(InvocationContext ctx) throws Exception {
        
        Object result = null;
        try {
            logger.debug("AuditTraceInterceptor - before EJB method invoke: "
		+ ctx.getMethod().getDeclaringClass().getName() + "." 
		+ ctx.getMethod().getName());
             result = ctx.proceed();
             registerTrace();
            /** 
            e.setCreatedBy(SecurityUtil.getCurrentUser());
            e.setCreatedBy(context.getCallerPrincipal().getName());
            e.setCreatedDate(new DateTime());
            registerTrace(e);
            */ 
            logger.debug("AuditTraceInterceptor - After EJB method invoke: "
		+ ctx.getMethod().getDeclaringClass().getName() + "." 
		+ ctx.getMethod().getName());
            
        } catch (GenericException sdr) {

        }
        return result;
    }
    
    private void registerTrace() throws Exception {
        // Do some kind of authorization check.
        // Throw exception if user is not authorized
    }
}