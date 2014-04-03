package com.sample.arquillian;

import javax.ejb.Local;

import com.sample.biblio.entity.sample.Tabuser;
import com.sample.frame.be.dao.generic.IGenericDao;

@Local
public interface IUserDao extends IGenericDao<Tabuser, String> {

}
