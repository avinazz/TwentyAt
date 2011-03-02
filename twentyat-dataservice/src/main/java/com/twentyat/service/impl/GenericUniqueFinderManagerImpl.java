package com.twentyat.service.impl;

import java.io.Serializable;

import com.twentyat.dao.GenericUniqueFinderDao;
import com.twentyat.service.GeneriUniqueFinderManager;

public class GenericUniqueFinderManagerImpl<T, PK extends Serializable, U extends Serializable>
        extends GenericManagerImpl<T, PK> implements
        GeneriUniqueFinderManager<T, PK, U> {

    /**
     * Public constructor for creating a new GenericUniqueFinderManagerImpl.
     * 
     * @param genericUniqueFinderDao
     *            the GenericUniqueFinderDao to use for persistence
     */
    public GenericUniqueFinderManagerImpl(
            final GenericUniqueFinderDao<T, PK, U> genericUniqueFinderDao) {
        super(genericUniqueFinderDao);
    }

    /**
     * {@inheritDoc}
     */
    public T findByUnique(U unique) {
        return ((GenericUniqueFinderDao<T, PK, U>) genericDao).findByUnique(unique);
    }

}
