package com.sample.frame.be.interceptor;

import java.io.Serializable;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import com.sample.frame.core.logging.FrameBaseLogger;

/**
 * 
 * @author echoupe
 */
public class LoggingInterceptor implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final FrameBaseLogger logger = FrameBaseLogger
                                .getLogger(LoggingInterceptor.class.getName());

    @AroundInvoke
    public Object logInvocation(InvocationContext ctx) throws Exception {
        logger.debug("LoggingInterceptor - before EJB method invoke: "
			+ ctx.getMethod().getDeclaringClass().getName() + "." 
			+ ctx.getMethod().getName());
        Object result = ctx.proceed();
        logger.debug("LoggingInterceptor - after EJB method invoke: "
			+ ctx.getMethod().getDeclaringClass().getName() + "." 
			+ ctx.getMethod().getName());		
        return result;
    }
}