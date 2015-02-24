/*
 * 
 */
package com.sample.biblio.dao.api.securite;

import javax.ejb.Local;
import com.sample.frame.be.dao.generic.IGenericDao;
import com.sample.biblio.model.securite.TabMouchard;

/**
 *
 * @author ECHOUPE
 */
@Local
public interface IMouchardDao extends IGenericDao<TabMouchard, String> {

}