/*

*/
package com.sample.biblio.dao.api.courrier;

import javax.ejb.Local;
import com.sample.frame.be.dao.generic.IGenericDao;
import com.sample.biblio.model.courrier.TabPieceJointe;

/**
 *
 * @author ECHOUPE
 */
@Local
public interface IPieceJointeDao extends IGenericDao<TabPieceJointe, String> {

}