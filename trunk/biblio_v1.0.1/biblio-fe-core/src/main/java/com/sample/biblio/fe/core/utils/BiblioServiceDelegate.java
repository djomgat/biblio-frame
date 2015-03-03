package com.sample.biblio.fe.core.utils;

import com.sample.biblio.svc.api.courrier.ICourrierSvc;
import com.sample.biblio.svc.api.courrier.ICourrierSvcRemote;
import com.sample.biblio.svc.api.courrier.INatureCourrierSvc;
import com.sample.biblio.svc.api.courrier.INatureCourrierSvcRemote;
import com.sample.biblio.svc.api.courrier.IPersonneSvc;
import com.sample.biblio.svc.api.courrier.IPersonneSvcRemote;
import com.sample.biblio.svc.api.courrier.IServiceSvc;
import com.sample.biblio.svc.api.courrier.IServiceSvcRemote;
import com.sample.biblio.svc.api.securite.IClassSvc;
import com.sample.biblio.svc.api.securite.IClassSvcRemote;
import com.sample.frame.fe.exception.ServiceLocatorException;

public class BiblioServiceDelegate {
	
    // Service du package Courrier
    public static ICourrierSvc getCourrierSvc() throws ServiceLocatorException{
    	return (ICourrierSvc) BiblioServiceLocator.lookup("CourrierSvc", ICourrierSvcRemote.class);
    }
    
    public static INatureCourrierSvc getNatureCourrierSvc() throws ServiceLocatorException{
    	return (INatureCourrierSvc) BiblioServiceLocator.lookup("NatureCourrierSvc", INatureCourrierSvcRemote.class);
    }
    
    public static IServiceSvc getServiceSvc() throws ServiceLocatorException{
    	return (IServiceSvc) BiblioServiceLocator.lookup("ServiceSvc", IServiceSvcRemote.class);
    }
    
    public static IPersonneSvc getPersonneSvc() throws ServiceLocatorException{
    	return (IPersonneSvc) BiblioServiceLocator.lookup("PersonneSvc", IPersonneSvcRemote.class);
    }
    
    //Service du package sécurité
    public static IClassSvc getClassSvc() throws ServiceLocatorException{
   	return (IClassSvc) BiblioServiceLocator.lookup("ClassSvc", IClassSvcRemote.class);
    }  
  
}