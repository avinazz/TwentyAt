package com.twentyat.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.twentyat.dao.GenericDao;
import com.twentyat.exception.SifrProviderException;
import com.twentyat.exception.TwentyAtException;
import com.twentyat.model.User;
import com.twentyat.model.UserAuth;
import com.twentyat.service.TwentyAtService;

public class TwentyAtServiceImpl implements TwentyAtService {
	
	private GenericDao<UserAuth, Integer> userAuthDao;

	public void setUserAuthDao(GenericDao<UserAuth, Integer> userAuthDao) {
		this.userAuthDao = userAuthDao;
	}

	private GenericDao<User, Integer> userDao;
	public void setUserDao(GenericDao<User, Integer> userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public String getToken(String id) throws SifrProviderException{
		try
		{
			UserAuth userAuth = userAuthDao.get(new Integer(id));
			return userAuth.getToken();
		}
		catch(Exception e)
		{
			throw new SifrProviderException(e);
		}
	}
	
	public User getUser(String id) throws SifrProviderException
	{
		try
		{
			return userDao.get(new Integer(id));
		}
		catch(Exception e)
		{
			throw new SifrProviderException(e);
		}
	}
}
