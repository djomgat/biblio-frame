package com.sample.biblio.svc.impl.interceptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import com.sample.biblio.dao.api.securite.IMouchardDao;
import com.sample.biblio.model.core.BiblioBaseEntity;
import com.sample.biblio.model.core.BiblioTicket;
import com.sample.biblio.model.securite.TabMouchard;
import com.sample.frame.be.interceptor.AuditTraceInterceptor;
import com.sample.frame.core.exception.GenericException;
import com.sample.frame.core.logging.BaseLogger;
import com.sample.frame.core.utils.DateTools;

public class BibliomouchardInterceptor {
	
	 private static final BaseLogger logger = BaseLogger.getLogger(BibliomouchardInterceptor.class.getName());
	 
	 @Inject
	 IMouchardDao mouchardDao;
	 
	 @AroundInvoke
	 public Object auditInvocation(InvocationContext ctx) throws Exception {
				
		Object result = null;
		
		try {
			
			_registerMouchard(ctx);

			logger.debug("BibliomouchardInterceptor - before EJB method invoke: "
			+ ctx.getMethod().getDeclaringClass().getName() + "." 
			+ ctx.getMethod().getName());
			
			result = ctx.proceed();
	
			logger.debug("BibliomouchardInterceptor - After EJB method invoke: "
			+ ctx.getMethod().getDeclaringClass().getName() + "." 
			+ ctx.getMethod().getName());
			
		} catch (GenericException sdr) {
		
		}
		return result;
	}
		
	private void _registerMouchard(InvocationContext ctx) throws Exception {
	 
		BiblioTicket ticket = _getTicket(ctx.getParameters());
		TabMouchard mouchard = new TabMouchard();
		
		mouchard.setCodeCommande(ctx.getMethod().getDeclaringClass().getName());
		mouchard.setCodeFonction(ctx.getMethod().getName());
		mouchard.setDateOperation(DateTools.formatDate(new Date()));
		//mouchard.setCodeTable(codeTable);
		//mouchard.setLogDetails(logDetails);
		if(ticket != null){
			mouchard.setHostName(ticket.getHostname());
			mouchard.setUserName(ticket.getUserName());
		}
		
		mouchardDao.create(mouchard);
	}
	
	private BiblioTicket _getTicket(Object[] p$params){
		if (p$params != null && p$params.length > 0) {
			for (Object v$t : p$params) {
				if (v$t instanceof BiblioBaseEntity) {
					
					BiblioBaseEntity entity = (BiblioBaseEntity)v$t;
					
					if(entity != null && entity.getTicket() != null)
						return entity.getTicket();					
				}				
			}
		}			
		return null;		 
	 }
}
