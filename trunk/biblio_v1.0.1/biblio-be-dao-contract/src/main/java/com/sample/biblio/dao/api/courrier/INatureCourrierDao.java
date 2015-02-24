/*

*/
package com.sample.biblio.dao.api.courrier;

import javax.ejb.Local;
import com.sample.frame.be.dao.generic.IGenericDao;
import com.sample.biblio.model.courrier.TabNatureCourrier;

/**
 *
 * @author ECHOUPE
 */
@Local
public interface INatureCourrierDao extends IGenericDao<TabNatureCourrier, String> {

}