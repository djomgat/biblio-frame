package com.sample.arquillian.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import com.sample.biblio.constant.be.BiblioBeConstant;
import com.sample.biblio.exceptions.BiblioDaoException;
import com.sample.biblio.exceptions.BiblioSvcException;
import com.sample.frame.be.dao.generic.IFrameBaseDao;
import com.sample.frame.core.exception.GenericException;
import com.sample.frame.core.logging.FrameBaseLogger;
import com.sample.frame.core.svc.generic.IFrameBaseSvc;

public class BiblioExceptionInterceptor {

	@AroundInvoke
	public Object logInvocation(InvocationContext ctx) throws Exception {

		try {
			Object result = ctx.proceed();
			return result;
		}
		catch (GenericException e) {
			throw e;
		} catch (Exception e) {

			Class targetClass = ctx.getTarget().getClass();
			String messageKey = ctx.getTarget().getClass().getSimpleName() + "_" +  ctx.getMethod().getName();
			if (IFrameBaseDao.class.isInstance(ctx.getTarget())) {
				GenericException ex = new BiblioDaoException(BiblioBeConstant.DAO_MESSAGE_FILE,
						messageKey, null);
				FrameBaseLogger.getLogger(targetClass).error(ex.getMessage(), ex);
				throw ex;
			} 
			else // (IFrameBaseSvc.class.isInstance(ctx.getTarget()))
				{
				GenericException ex =  new BiblioSvcException(BiblioBeConstant.SVC_MESSAGE_FILE,
						messageKey, null);
				FrameBaseLogger.getLogger(targetClass).error(ex.getMessage(), ex);
				
				throw ex;
			}
		}

	}

}
