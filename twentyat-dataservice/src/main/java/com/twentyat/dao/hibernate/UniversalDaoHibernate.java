package com.twentyat.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.twentyat.dao.UniversalDao;

/**
 * This class serves as the a class that can CRUD any object witout any
 * Spring configuration. The only downside is it does require casting
 * from Object to the object class.
 *
 * @author Bryan Noll
 */
public class UniversalDaoHibernate extends HibernateDaoSupport implements UniversalDao {
    /**
     * Log variable for all child classes. Uses LogFactory.getLog(getClass()) from Commons Logging
     */
    protected final Log log = LogFactory.getLog(getClass());

    /**
     * {@inheritDoc}
     */
    public Object save(Object o) {
        return getHibernateTemplate().merge(o);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public Object get(Class clazz, Serializable id) {
        Object o = getHibernateTemplate().get(clazz, id);

        if (o == null) {
            throw new ObjectRetrievalFailureException(clazz, id);
        }

        return o;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List getAll(Class clazz) {
        return getHibernateTemplate().loadAll(clazz);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public void remove(Class clazz, Serializable id) {
        getHibernateTemplate().delete(get(clazz, id));
    }
}
