/*
 */
package com.sample.biblio.dao.api.marche;

import javax.ejb.Local;
import com.sample.frame.be.dao.generic.IGenericDao;
import com.sample.biblio.model.marche.TabLot;
/**
 *
 * @author ECHOUPE
 */
@Local
public interface ILotDao extends IGenericDao<TabLot, String> {

}