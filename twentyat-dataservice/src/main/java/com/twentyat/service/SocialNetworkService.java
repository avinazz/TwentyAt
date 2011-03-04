package com.twentyat.service;

import com.twentyat.exception.TwentyAtProviderException;
import com.twentyat.model.User;

/**
 * This class provide services for social network
 * 
 * @author Bipin Sutariya
 *
 */

public interface SocialNetworkService {

	/**
	 * This method is used to get user information of social network from JanRain
	 * 
	 * @param token
	 * @return User
	 * @throws TwentyAtProviderException
	 */
	public User getUser(String token) throws TwentyAtProviderException;
	
}
