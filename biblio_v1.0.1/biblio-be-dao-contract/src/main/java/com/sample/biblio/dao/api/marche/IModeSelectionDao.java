/*

 */
package com.sample.biblio.dao.api.marche;

import javax.ejb.Local;
import com.sample.biblio.model.marche.TabModeSelection;
import com.sample.frame.be.dao.generic.IGenericDao;

/**
 *
 * @author ECHOUPE
 */
@Local
public interface IModeSelectionDao extends IGenericDao<TabModeSelection, String> {

}