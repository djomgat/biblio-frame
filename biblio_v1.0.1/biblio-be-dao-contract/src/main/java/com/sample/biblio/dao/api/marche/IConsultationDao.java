/*

 */
package com.sample.biblio.dao.api.marche;

import javax.ejb.Local;
import com.sample.biblio.model.marche.TabConsultation;
import com.sample.frame.be.dao.generic.IGenericDao;

/**
 *
 * @author ECHOUPE
 */
@Local
public interface IConsultationDao extends IGenericDao<TabConsultation, String> {

}