package com.twentyat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.log4testng.Logger;

import com.twentyat.dao.GenericDao;
import com.twentyat.dao.GroupDao;
import com.twentyat.dao.UserDao;
import com.twentyat.exception.TwentyAtProviderException;
import com.twentyat.model.Group;
import com.twentyat.model.User;
import com.twentyat.model.UserAuth;
import com.twentyat.service.TwentyAtService;

public class TwentyAtServiceImpl implements TwentyAtService {
	
	Logger log = Logger.getLogger(getClass());
	
	@Autowired
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Autowired
	private GenericDao<UserAuth, Integer> userAuthDao;
	public void setUserAuthDao(GenericDao<UserAuth, Integer> userAuthDao) {
		this.userAuthDao = userAuthDao;
	}
	
	@Autowired
	private GroupDao groupDao;
	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
	}
	/*
	 * (non-Javadoc)
	 * @see com.twentyat.service.TwentyAtService#getToken(java.lang.String)
	 */
	
	public String getToken(String id) throws TwentyAtProviderException{
		try
		{
			UserAuth userAuth = userAuthDao.get(new Integer(id));
			return userAuth.getToken();
		}
		catch(Exception e)
		{
			throw new TwentyAtProviderException(e);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.twentyat.service.TwentyAtService#getUser(java.lang.String)
	 */
	public User getUser(String id) throws TwentyAtProviderException
	{
		try
		{
			return userDao.getUser(id);
		}
		catch(Exception e)
		{
			throw new TwentyAtProviderException(e);
		}
	}
	/*
	 * (non-Javadoc)
	 * @see com.twentyat.service.TwentyAtService#addTwentyAtUser(com.twentyat.model.User, java.lang.String)
	 */
	public User addTwentyAtUser(User user, String token) throws TwentyAtProviderException{	
		
		UserAuth auth = new UserAuth();
		auth.setToken(token);
		auth.setTwentyAtUserId(user.getTwentyAtUserId());	
		
		auth = userAuthDao.save(auth);			
		user = userDao.saveUser(user);			
		return user;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.twentyat.service.FacebookService#getTwentyAtUserByID(java.lang.String)
	 */
	
	public User getTwentyAtUserByID(String id) throws TwentyAtProviderException{
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.twentyat.service.TwentyAtService#getTwentyAtUserByEMail(java.lang.String)
	 */
	
	public User getTwentyAtUserByEMail(String email)
			throws TwentyAtProviderException {
		return userDao.getTwentyAtUserByEmail(email);		
	}	
	
	
	/*
	 * (non-Javadoc)
	 * @see com.twentyat.service.TwentyAtService#getGroup(java.lang.String)
	 */
	
	public List<Group> getGroupByUserId(String userId) throws TwentyAtProviderException {
		return groupDao.getGroupByUserId(userId);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.twentyat.service.TwentyAtService#getGroup(int)
	 */
	
	public Group getGroup(int id) throws TwentyAtProviderException {
		return groupDao.getGroup(id);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.twentyat.service.TwentyAtService#saveGroup(com.twentyat.model.Group)
	 */
	
	public Group saveGroup(Group group) throws TwentyAtProviderException {
		return groupDao.saveGroup(group);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.twentyat.service.TwentyAtService#updateGroup(com.twentyat.model.Group)
	 */
	
	public Group updateGroup(Group group) throws TwentyAtProviderException {
		return groupDao.updateGroup(group);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.twentyat.service.TwentyAtService#deleteGroup(int)
	 */
	
	public void deleteGroup(int id) throws TwentyAtProviderException {
		groupDao.deleteGroup(id);
	}
}
