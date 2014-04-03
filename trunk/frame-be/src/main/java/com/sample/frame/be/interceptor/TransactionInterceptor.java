package com.sample.frame.be.interceptor;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import com.sample.frame.core.exception.GenericSvcException;

/**
 *
 * @author echoupe
 */
public class TransactionInterceptor {
    
    @Resource
    SessionContext session;    

    @AroundInvoke
    public Object verifyAccess(InvocationContext context) throws Exception {
        Object result = null;
        try {
             result = context.proceed();
        } catch (GenericSvcException sdr) {
             session.setRollbackOnly();  
             throw sdr;
        }
        return result;
    }
} 