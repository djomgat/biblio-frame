package com.sample.frame.be.dao.generic;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.sample.frame.core.entity.GenericEntity;
import com.sample.frame.core.exception.GenericDaoException;

/**
 * le Dao avec JPA permet de:
 - découplage JPA api et code client;
 - regroupe tout le code spécifique au JPA
 - implémentation facile de transaction, logging, etc
 * @param <T>
 * @param <PK>
 */
public interface IGenericDao<U extends GenericEntity, PK extends Serializable> {

    /**
     * insert an entity
     *
     * @param entity : the entity to be insert
     * @return the inserted entity
     * @throws GenericDaoException
     */
    <T extends U> T create(T entity) throws GenericDaoException;
    
    
    <T extends U> void create(Collection<T> entities) throws GenericDaoException ;
        
    /**
     * retrieve an entity
     *
     * @param id
     * @return the entity foundBy id
     * @throws GenericDaoException
     */    
    <T extends U>T retrieve(PK id) throws GenericDaoException;
    

    /**
     * Update an entity : it can be use either for UPDATE and INSERT
     *
     * @param entity : the entity to be save
     * @return the saved entity
     * @throws GenericDaoException
     */
    <T extends U>T update(T entity) throws GenericDaoException;
    

    /**
     * *
     * Delete an entity from the database
     *
     * @param entity : The entity to be delete
     * @throws GenericDaoException
     */
    <T extends U>void delete(T entity) throws GenericDaoException;


    <T extends U>List<T> findAll() throws GenericDaoException;    
    
    /**
     * Find entities based on an example.
     *
     * @param exampleInstance the example
     * @return the list of entities
     * @throws GenericDaoException
     */
    <T extends U>List<T> findByExample(final T exampleInstance) throws GenericDaoException;
  
    /**
     * *
     * Count all entities that match with de model
     *
     * @param range
     * @return The number of entities found
     * @throws GenericDaoException
     */
    <T extends U>List<T> findRange(int[] range) throws GenericDaoException;

    /**
     * *
     * Count all entities that match with de model
     *
     * @param p$query
     * @return The number of entities found
     * @throws GenericDaoException
     */
    int runUpdateQuery(String p$query) throws GenericDaoException;

}