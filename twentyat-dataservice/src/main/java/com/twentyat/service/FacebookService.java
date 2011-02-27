package com.twentyat.service;

import com.twentyat.exception.SifrProviderException;
import com.twentyat.model.TwentyAtUser;
import com.twentyat.model.User;

/**
 * This class provide services for facebook
 * 
 * @author Bipin Sutariya
 *
 */

public interface FacebookService {

	public void registerUser(TwentyAtUser user, String token);
	
	public void signout();
	
	public User getUser(String token) throws SifrProviderException;
}
