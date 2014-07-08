package com.sample.frame.be.dao.generic;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import com.sample.frame.core.entity.GenericEntity;
import com.sample.frame.core.exception.GenericDaoException;
import com.sample.frame.core.logging.FrameBaseLogger;

/**
 * 
 * @author echoupe
 * @param <T>
 * @param <PK>
 */
public abstract class GenericDaoJpaImpl<U extends GenericEntity, PK extends Serializable>
		implements IGenericDao<U, PK> {


	protected abstract EntityManager getEntityManager();
	
	protected abstract Class<U> getEntityClass();
	
	protected abstract FrameBaseLogger getLogger();
	


	@Override
	public <T extends U>T create(T entity) throws GenericDaoException {
		getEntityManager().persist(entity);
		return entity;
	}

	@Override
	public <T extends U>void create(Collection<T> entities) {
		for (T entity : entities) {
			getEntityManager().persist(entity);
		}
	}

	@Override
	public <T extends U> T retrieve(PK id) throws GenericDaoException {
		return (T)getEntityManager().find(getEntityClass(), id);
	}

	@Override
	public <T extends U> T update(T entity) throws GenericDaoException {
		return getEntityManager().merge(entity);
	}

	@Override
	public <T extends U> void delete(T entity) throws GenericDaoException {
		getEntityManager().remove(getEntityManager().merge(entity));
	}

	@Override
	public <T extends U> List<T> findAll() throws GenericDaoException {
		CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
		cq.select(cq.from(getEntityClass()));
		return getEntityManager().createQuery(cq).getResultList();
		
	}

	@Override
	public <T extends U> List<T> findRange(int[] range) throws GenericDaoException {
		CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
		cq.select(cq.from(getEntityClass()));
		Query q = getEntityManager().createQuery(cq);
		q.setMaxResults(range[1] - range[0] + 1);
		q.setFirstResult(range[0]);
		return q.getResultList();
	}

	@Override
	public <T extends U> List<T> findByExample(T exampleInstance) throws GenericDaoException {
		
		return findAll();
	}

	@Override
	public int runUpdateQuery(String p$query) throws GenericDaoException {
		return getEntityManager().createNativeQuery(p$query).executeUpdate();
		
	}

}