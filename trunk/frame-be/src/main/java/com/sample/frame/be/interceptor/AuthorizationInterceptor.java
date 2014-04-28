package com.sample.frame.be.interceptor;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import com.sample.frame.core.logging.FrameBaseLogger;

/**
 * 
 * @author echoupe
 */
// @Interceptor
// @Log
public class AuthorizationInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final FrameBaseLogger logger = FrameBaseLogger
			.getLogger(AuthorizationInterceptor.class.getName());

	@AroundInvoke
	public Object intercept(InvocationContext ctx) throws Exception {
		logger.debug("AuthorizationInterceptor - before EJB method invoke: "
				+ ctx.getMethod().getName());
		try {
			authorizationCheck();
		} catch (Exception e) {
			logger.debug("Authorization check failed");
			throw e;
		}
		return ctx.proceed();
	}

	private void authorizationCheck() throws Exception {
		// Do some kind of authorization check.
		// Throw exception if user is not authorized
	}
}