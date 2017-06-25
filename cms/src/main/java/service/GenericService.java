package service;

import exception.ServiceException;

import java.io.Serializable;
import java.util.List;

/**
 * @author v.bublik.
 * Generalized interface for all services.
 */
public interface GenericService<E,K extends Serializable> {

    /**
     * Method for creating or updating models. One of CRUD operations.
     * @param element model with which we work.
     * @return model, after saving to the database.
     * The model is taking from the cache.
     */
    public E createOrUpdate(E element) throws ServiceException;

    /**
     * Method for creating or updating models data.
     * @param element model with which we work.
     * @return model, after saving to the database.
     * The difference from the usual save is that
     * saveAndFlush terminates the transaction immediately after saving to the database.
     * Allows you to save only one object per database.
     */
    public E saveAndFlush(E element);

    /**
     * One of the CRUD operation. Needed for obtain model data.
     * @param primaryKey model identifier.
     * @return The model in which the identifier corresponds to the primary key.
     */
    public E get(K primaryKey) throws ServiceException;

    /**
     * One of the CRUD operations. Needed for deleting model from the database.
     * @param primaryKey model identifier.
     * @return Result of deleting.
     * Predicate, which returns true if the model is removed from the database.
     */
    public boolean delete(K primaryKey) throws ServiceException;

    /**
     * Checking that model exists in database.
     * @param primaryKey model identifier.
     * @return Result of checking existence.
     */
    public boolean isExists(K primaryKey) throws ServiceException;

    /**
     * Gets the list of entities of the specified model.
     * @return list of element entities.
     * Costly operation, if the lazy-initialization in hibernate is not enabled.
     */
    public List<E> getAll();

}
