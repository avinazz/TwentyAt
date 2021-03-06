package com.twentyat.dao;

import java.io.Serializable;

public interface GenericUniqueFinderDao<T, PK extends Serializable, U extends Serializable>
		extends GenericDao<T, PK> {
	
	/**
	 * Retrieves an object using a unique key or null if the key value is not 
	 * found 
	 * 
	 * @param unique Unique key value to look up object by.
	 * @return Object with the given unique key value, null if key not found. 
	 */
	public T findByUnique(U unique);
}
