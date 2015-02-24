/*
 */
package com.sample.biblio.svc.api.courrier;

import java.util.List;
import com.sample.biblio.model.courrier.TabCourrier;
import com.sample.biblio.model.courrier.TabPersonne;
import com.sample.frame.core.exception.GenericDaoException;
import com.sample.frame.core.svc.generic.IGenericSvc;

/**
 *
 * @author ECHOUPE
 */
public interface ICourrierSvc extends IGenericSvc<TabCourrier, String>{
    /*
    TabCourrier creationPourTestRollbackTransac(TabCourrier p$class,
			List<TabPersonne> p$listUser) throws GenericDaoException;

    TabCourrier creationPourTestCommitTransac(TabCourrier p$class,
			List<TabPersonne> p$listUser) throws GenericDaoException;

    TabCourrier creationPourTestExceptionInterceptor(TabCourrier p$class,
			List<TabPersonne> p$listUser) throws GenericDaoException, Exception;
    */
}