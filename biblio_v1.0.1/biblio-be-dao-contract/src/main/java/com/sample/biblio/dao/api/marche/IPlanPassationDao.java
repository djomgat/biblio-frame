
package com.sample.biblio.dao.api.marche;

import javax.ejb.Local;
import com.sample.frame.be.dao.generic.IGenericDao;
import com.sample.biblio.model.marche.TabPlanPassation;
/**
 *
 * @author ECHOUPE
 */
@Local
public interface IPlanPassationDao extends IGenericDao<TabPlanPassation, String> {

}