package com.twentyat.dao.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.twentyat.dao.UserDao;
import com.twentyat.exception.TwentyAtException;
import com.twentyat.exception.TwentyAtProviderException;
import com.twentyat.model.User;

/**
 * Hibernate implementation of UserDao interface.
 * 
 * @author Bipin Sutariya
 *
 */
public class UserDaoHibernate extends  GenericDaoHibernate<User, String> implements UserDao {

	public UserDaoHibernate() {
		super(User.class);		
	}

	/*
	 * (non-Javadoc)
	 * @see com.twentyat.dao.UserDao#getTwentyAtUserByEmail(java.lang.String)
	 */
	
	public User getTwentyAtUserByEmail(String email) throws TwentyAtProviderException{
		String query = "from User where email=?";
		
		List<User> users = getHibernateTemplate().find(query, email);
		
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
	
	public User getUser(String id) throws TwentyAtProviderException{
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
	
	public User saveUser(User user) throws TwentyAtProviderException {
		return super.save(user);
	}

	/*
	 * (non-Javadoc)
	 * @see com.twentyat.dao.UserDao#updateUser(com.twentyat.model.User)
	 */
	
	public User updateUser(User user) throws TwentyAtProviderException {
		return super.save(user);
	}

	/*
	 * (non-Javadoc)
	 * @see com.twentyat.dao.UserDao#deleteUser(com.twentyat.model.User)
	 */
	
	public void deleteUser(User user) throws TwentyAtProviderException {
		super.remove(user.getTwentyAtUserId());
	}

}
