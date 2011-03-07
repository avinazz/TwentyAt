package com.twentyat.service;

import com.twentyat.exception.TwentyAtProviderException;
import com.twentyat.model.TwentyAtUser;

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
	 * @return TwentyAtUser
	 * @throws TwentyAtProviderException
	 */
	public TwentyAtUser getUser(String token) throws TwentyAtProviderException;
	
	/**
	 * This method is used to get user information from facebook based on provided facebookid
	 * 
	 * @param facebookId
	 * @return TwentyAtUser
	 * @throws TwentyAtProviderException
	 */
	public TwentyAtUser getUserByFacebookId(String facebookId) throws TwentyAtProviderException;
	
}
