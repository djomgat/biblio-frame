package com.sample.biblio.dao.api.marche;

import javax.ejb.Local;
import com.sample.frame.be.dao.generic.IGenericDao;
import com.sample.biblio.model.marche.TabOperation;
/**
 *
 * @author ECHOUPE
 */
@Local
public interface IOperationDao extends IGenericDao<TabOperation, String> {

}