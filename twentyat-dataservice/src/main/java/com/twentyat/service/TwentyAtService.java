package com.twentyat.service;

import com.twentyat.exception.TwentyAtProviderException;
import com.twentyat.model.User;

/**
 * This class is used to get connect to database and get result
 * 
 * @author Bipin Sutariya
 *
 */
public interface TwentyAtService {
	
	/**
	 * This method is used to get token for registered User based on provided user id
	 * 
	 * @param id
	 * @return token - String
	 */
	public String getToken(String id) throws TwentyAtProviderException;
	
	public User getUser(String id) throws TwentyAtProviderException;
}
