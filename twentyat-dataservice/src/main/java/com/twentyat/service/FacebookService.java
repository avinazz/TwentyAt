package com.twentyat.service;

import com.twentyat.exception.TwentyAtProviderException;
import com.twentyat.model.TwentyAtUser;
import com.twentyat.model.User;

/**
 * This class provide services for facebook
 * 
 * @author Bipin Sutariya
 *
 */

public interface FacebookService {

	public User addTwentyAtUser(User user, String token) throws TwentyAtProviderException;
	
	public User getTwentyAtUserByUUID(String uuid) throws TwentyAtProviderException;
	
	public void signout() throws TwentyAtProviderException;
	
	public User getUser(String token) throws TwentyAtProviderException;
}
