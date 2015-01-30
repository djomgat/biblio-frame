package com.sample.biblio.dao.api;

import javax.ejb.Local;

import com.sample.biblio.model.Tabclass;
import com.sample.frame.be.dao.generic.IGenericDao;

@Local
public interface IClassDao extends IGenericDao<Tabclass, String> {

}