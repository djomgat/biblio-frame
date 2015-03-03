/*
 */
package com.sample.biblio.dao.impl.generic;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.sample.frame.be.dao.generic.GenericDaoJpaImpl;
import com.sample.frame.core.entity.GenericEntity;
import java.io.Serializable;

/**
 * Réalise la factorisation de getEntityMAnager qui sera utilisé par les classes DAO
 * @author ECHOUPE
 */

public abstract class BiblioGenericDao<U extends GenericEntity, PK extends Serializable>
                extends GenericDaoJpaImpl<U, PK> {
    
    @Inject
    private EntityManager em;
       
    @Override
    protected EntityManager getEntityManager() {
	return em;
    }
}