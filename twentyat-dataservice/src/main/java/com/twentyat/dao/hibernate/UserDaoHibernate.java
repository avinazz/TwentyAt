package com.twentyat.dao.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.twentyat.dao.UserDao;
import com.twentyat.exception.TwentyAtException;
import com.twentyat.exception.TwentyAtProviderException;
import com.twentyat.model.TwentyAtUser;

/**
 * Hibernate implementation of UserDao interface.
 * 
 * @author Bipin Sutariya
 *
 */
public class UserDaoHibernate extends  GenericDaoHibernate<TwentyAtUser, String> implements UserDao {

	public UserDaoHibernate() {
		super(TwentyAtUser.class);		
	}

	/*
	 * (non-Javadoc)
	 * @see com.twentyat.dao.UserDao#getTwentyAtUserByEmail(java.lang.String)
	 */
	
	public TwentyAtUser getTwentyAtUserByEmail(String email) throws TwentyAtProviderException{
		String query = "from User where email=?";
		
		List<TwentyAtUser> users = getHibernateTemplate().find(query, email);
		
		if(null != users && users.size()>0)
		{
			return users.get(0);
		}
		
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.twentyat.dao.UserDao#getUser(java.lang.String)
	 */
	
	public TwentyAtUser getUser(String id) throws TwentyAtProviderException{
		try
		{
			return super.get(id);
		}
		catch(ObjectRetrievalFailureException e)
		{
			throw new TwentyAtProviderException("User not found with for ID : "+id);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.twentyat.dao.UserDao#saveUser(com.twentyat.model.User)
	 */
	
	public TwentyAtUser saveUser(TwentyAtUser user) throws TwentyAtProviderException {
		return super.save(user);
	}

	/*
	 * (non-Javadoc)
	 * @see com.twentyat.dao.UserDao#updateUser(com.twentyat.model.User)
	 */
	
	public TwentyAtUser updateUser(TwentyAtUser user) throws TwentyAtProviderException {
		return super.save(user);
	}

	/*
	 * (non-Javadoc)
	 * @see com.twentyat.dao.UserDao#deleteUser(com.twentyat.model.User)
	 */
	
	public void deleteUser(TwentyAtUser user) throws TwentyAtProviderException {
		super.remove(user.getTwentyAtUserId());
	}

	public TwentyAtUser getUserByFacebookId(String facebookId)
			throws TwentyAtProviderException {
	
		List<TwentyAtUser> users = getHibernateTemplate().find("from User where facebookId=?", facebookId);
		
		if(users!=null && users.size()>0)
		{
			return users.get(0);
		}
		
		return null;
	}

}
