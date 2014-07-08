package com.sample.arquillian;

import javax.ejb.Local;

import com.sample.biblio.entity.sample.Tabclass;
import com.sample.frame.be.dao.generic.IGenericDao;

@Local
public interface IClassDao extends IGenericDao<Tabclass, String> {

}
