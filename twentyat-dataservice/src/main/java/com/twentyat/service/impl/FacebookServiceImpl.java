package com.twentyat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.testng.log4testng.Logger;

import com.googlecode.janrain4j.api.engage.EngageFailureException;
import com.googlecode.janrain4j.api.engage.EngageService;
import com.googlecode.janrain4j.api.engage.ErrorResponeException;
import com.googlecode.janrain4j.api.engage.response.UserDataResponse;
import com.twentyat.dao.GenericDao;
import com.twentyat.dao.UserDao;
import com.twentyat.exception.TwentyAtProviderException;
import com.twentyat.model.Address;
import com.twentyat.model.TwentyAtUser;
import com.twentyat.model.User;
import com.twentyat.model.UserAuth;
import com.twentyat.service.FacebookService;

/**
 * 
 * @author Bipin Sutariya
 *
 */
public class FacebookServiceImpl implements FacebookService {
	
	Logger log = Logger.getLogger(getClass());
	
	@Autowired
	private EngageService engageService;
	public void setEngageService(EngageService engageService) {
		this.engageService = engageService;
	}
	
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
	
	private String token;
	
	/*
	 * (non-Javadoc)
	 * @see com.twentyat.service.FacebookService#addTwentyAtUser(com.twentyat.model.User, java.lang.String)
	 */
	public User addTwentyAtUser(User user, String token) throws TwentyAtProviderException{
		User retriveUser = null;
		try
		{
			retriveUser = userDao.getTwentyAtUserByEmail(user.getEmail());
		}
		catch(Exception e)
		{
			log.info(user.getEmail()+" is new user, go ahead and register it");
		}
		
		if(null == retriveUser)
		{
			UserAuth auth = new UserAuth();
			auth.setToken(token);
			auth.setTwentyAtUserId(user.getTwentyAtUserId());
				
			log.info("Saving user auth : ");
			auth = userAuthDao.save(auth);
			log.info("Saved user auth : ");
			user = userDao.saveUser(user);
			log.info("Saved user : ");
			return user;
		}
		
		throw new TwentyAtProviderException(user.getEmail()+" is already registered");
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.twentyat.service.FacebookService#getTwentyAtUserByID(java.lang.String)
	 */
	@Override
	public User getTwentyAtUserByID(String id) throws TwentyAtProviderException{
		// TODO Auto-generated method stub
		return null;
	}
	

	public void signout() throws TwentyAtProviderException{

	}

	public User getUser(String token) throws TwentyAtProviderException 
	{
		return null;
	}
}
