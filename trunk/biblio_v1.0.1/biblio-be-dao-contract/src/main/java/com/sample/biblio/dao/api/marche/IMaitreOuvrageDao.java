/*

 */
package com.sample.biblio.dao.api.marche;

import javax.ejb.Local;
import com.sample.biblio.model.marche.TabMoa;
import com.sample.frame.be.dao.generic.IGenericDao;

/**
 *
 * @author ECHOUPE
 */
@Local
public interface IMaitreOuvrageDao extends IGenericDao<TabMoa, String> {

}