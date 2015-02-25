package com.sample.biblio.fe.core.utils;

import com.sample.biblio.svc.api.courrier.ICourrierSvc;
import com.sample.biblio.svc.api.courrier.ICourrierSvcRemote;
import com.sample.biblio.svc.api.securite.IClassSvc;
import com.sample.biblio.svc.api.securite.IClassSvcRemote;
import com.sample.frame.fe.exception.ServiceLocatorException;

public class BiblioServiceDelegate {
	
    // Service du package Courrier
    public static ICourrierSvc getCourrierSvc() throws ServiceLocatorException{
    	return (ICourrierSvc) BiblioServiceLocator.lookup("CourrierSvc", ICourrierSvcRemote.class);
    }
  
    //Service du package sécurité
    public static IClassSvc getClassSvc() throws ServiceLocatorException{
   	return (IClassSvc) BiblioServiceLocator.lookup("ClassSvc", IClassSvcRemote.class);
    }  
  
}