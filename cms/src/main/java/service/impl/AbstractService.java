package service.impl;

import exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.GenericRepository;
import service.GenericService;

import java.io.Serializable;
import java.util.List;

/**
 * @author v.bublik.
 * Abstact generalized class for all services.
 */
@Service
public abstract class AbstractService<E,K extends Serializable> implements GenericService<E,K> {

    private static final Logger logger = Logger.getLogger(AbstractService.class);

    private GenericRepository<E,K> genericRepository;

    @Transactional
    public E createOrUpdate(E element) throws ServiceException {
        return genericRepository.save(isNull(element));
    }

    @Transactional(readOnly = true)
    public E get(K primaryKey) throws ServiceException {
        return genericRepository.findOne(isNull(primaryKey));
    }

    @Transactional(readOnly = true)
    public boolean delete(K primaryKey) throws ServiceException {
        return genericRepository.exists(isNull(primaryKey));
    }

    @Transactional(readOnly = true)
    public boolean isExists(K primaryKey) throws ServiceException {
        return genericRepository.exists(isNull(primaryKey));
    }

    @Transactional
    public List<E> getAll() {
        return genericRepository.findAll();
    }

    private E isNull(E element) throws ServiceException {
        if(element == null) {
            logger.info("Element not initialized");
            throw new ServiceException("Element is null");
        } else {
            return element;
        }
    }

    private K isNull(K primaryKey) throws ServiceException {
        if (primaryKey == null) {
            logger.info("Identifier not initialized");
            throw new ServiceException("Identifier is null");
        } else {
            return primaryKey;
        }
    }

    @Autowired
    public void setGenericRepository(GenericRepository<E, K> genericRepository) {
        this.genericRepository = genericRepository;
    }

}
