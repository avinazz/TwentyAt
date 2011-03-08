package com.twentyat.service;

import com.twentyat.exception.TwentyAtProviderException;
import com.twentyat.model.TwentyatUser;

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
	 * @return TwentyatUser
	 * @throws TwentyAtProviderException
	 */
	public TwentyatUser getUser(String token) throws TwentyAtProviderException;
	
	/**
	 * This method is used to get user information from facebook based on provided facebookid
	 * 
	 * @param facebookId
	 * @return TwentyatUser
	 * @throws TwentyAtProviderException
	 */
	public TwentyatUser getUserByFacebookId(Long facebookId) throws TwentyAtProviderException;
	
}
