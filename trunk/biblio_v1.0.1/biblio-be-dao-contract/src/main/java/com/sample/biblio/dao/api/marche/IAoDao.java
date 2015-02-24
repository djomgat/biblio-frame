/*
 */
package com.sample.biblio.dao.api.marche;

import com.sample.biblio.model.marche.TabAo;
import javax.ejb.Local;

import com.sample.frame.be.dao.generic.IGenericDao;
/**
 *
 * @author ECHOUPE
 */
@Local
public interface IAoDao extends IGenericDao<TabAo, String> {

}