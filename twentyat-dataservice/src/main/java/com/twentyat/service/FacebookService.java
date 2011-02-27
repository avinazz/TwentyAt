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

	/**
	 * Method used to get Twentyat User information
	 * 
	 * @param User user
	 * @param String token
	 * @return User
	 * @throws TwentyAtProviderException
	 */
	public User addTwentyAtUser(User user, String token) throws TwentyAtProviderException;
	
	/**
	 * Method used to get User by Id
	 * 
	 * @param String id
	 * @return User
	 * @throws TwentyAtProviderException
	 */
	public User getTwentyAtUserByID(String id) throws TwentyAtProviderException;
		
	public void signout() throws TwentyAtProviderException;
	
	public User getUser(String token) throws TwentyAtProviderException;
}
