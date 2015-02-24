package com.sample.biblio.dao.api.marche;

import javax.ejb.Local;
import com.sample.frame.be.dao.generic.IGenericDao;
import com.sample.biblio.model.marche.TabContrat;
/**
 *
 * @author ECHOUPE
 */
@Local
public interface IContratDao extends IGenericDao<TabContrat, String> {

}