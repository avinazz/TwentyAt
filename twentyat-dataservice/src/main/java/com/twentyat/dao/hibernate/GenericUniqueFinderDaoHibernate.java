package com.twentyat.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import com.twentyat.dao.GenericUniqueFinderDao;
import com.twentyat.exception.TwentyAtIllegalArgumentException;

public class GenericUniqueFinderDaoHibernate<T, PK extends Serializable, U extends Serializable>
		extends GenericDaoHibernate<T, PK> implements
		GenericUniqueFinderDao<T, PK, U> {

	private String uniqueFieldName;

	public GenericUniqueFinderDaoHibernate(final Class<T> persistentClass,
			String uniqueFieldName) throws TwentyAtIllegalArgumentException {
		super(persistentClass);
		try {
			if (persistentClass.getDeclaredField(uniqueFieldName) == null) {
				throw (new TwentyAtIllegalArgumentException("Class "
						+ persistentClass.getName() + "doesn't have a '"
						+ uniqueFieldName + "' field"));
			}
		} catch (NoSuchFieldException e) {
			throw (new TwentyAtIllegalArgumentException("Class "
					+ persistentClass.getName() + "doesn't have a '"
					+ uniqueFieldName + "' field", e));
		}
		this.uniqueFieldName = uniqueFieldName; 
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public T findByUnique(U unique) {
        String queryStr = "from " + persistentClass.getName() + " where "
                + uniqueFieldName + " = ?";
//		System.out.println(queryStr);
		List<T> entities = super.getHibernateTemplate().find(queryStr, unique);
		if (entities == null) {
			log.warn("Uh oh, '" + this.persistentClass + "' object with '"
					+ uniqueFieldName + " = " + unique + "' not found...");
			// throw new ObjectRetrievalFailureException(this.persistentClass,
			// unique);
		} else if (entities.size() > 0) {
			return entities.get(0);
		}
		return null;
	}
}
