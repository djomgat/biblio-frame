package com.sample.biblio.dao.api.securite;

import javax.ejb.Local;

import com.sample.biblio.model.securite.Tabclass;
import com.sample.frame.be.dao.generic.IGenericDao;

@Local
public interface IClassDao extends IGenericDao<Tabclass, String> {

}