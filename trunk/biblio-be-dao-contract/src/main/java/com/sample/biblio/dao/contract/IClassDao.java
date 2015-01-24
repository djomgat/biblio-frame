package com.sample.biblio.dao.contract;

import javax.ejb.Local;

import com.sample.biblio.entity.Tabclass;
import com.sample.frame.be.dao.generic.IGenericDao;

@Local
public interface IClassDao extends IGenericDao<Tabclass, String> {

}