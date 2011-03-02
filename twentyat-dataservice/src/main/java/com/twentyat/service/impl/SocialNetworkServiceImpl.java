package com.twentyat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.log4testng.Logger;

import com.googlecode.janrain4j.api.engage.EngageFailureException;
import com.googlecode.janrain4j.api.engage.EngageService;
import com.googlecode.janrain4j.api.engage.ErrorResponeException;
import com.googlecode.janrain4j.api.engage.response.UserDataResponse;
import com.googlecode.janrain4j.api.engage.response.profile.Address;
import com.googlecode.janrain4j.api.engage.response.profile.Profile;
import com.twentyat.exception.TwentyAtProviderException;
import com.twentyat.model.Group;
import com.twentyat.model.User;
import com.twentyat.service.SocialNetworkService;

/**
 * 
 * @author Bipin Sutariya
 *
 */
public class SocialNetworkServiceImpl implements SocialNetworkService {
	
	Logger log = Logger.getLogger(getClass());
	
	@Autowired
	private EngageService engageService;
	public void setEngageService(EngageService engageService) {
		this.engageService = engageService;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.twentyat.service.FacebookService#getUser(java.lang.String)
	 */
	public User getUser(String token) throws TwentyAtProviderException 
	{
		try {
			UserDataResponse response = engageService.authInfo(token);
			Profile profile = response.getProfile();
			
			Address address  = profile.getAddress();
			com.twentyat.model.Address add = new com.twentyat.model.Address();
			add.setCountry(address.getCountry());
			add.setLocality(address.getLocality());
			add.setPostalCode(address.getPostalCode());
			add.setRegion(address.getRegion());
			add.setStreetAddress(address.getStreetAddress());
						
			User user = new User();
			
			user.setAddress(add);
			user.setEmail(profile.getEmail());
			//user.setFacebookId(profile.)
			user.setFirstName(profile.getName().getGivenName());
			user.setMiddleName(profile.getName().getMiddleName());
			user.setLastName(profile.getName().getFamilyName());
			user.setFriendlyName(profile.getDisplayName());
			user.setMobilePhone(profile.getPhoneNumber());
			user.setPhoto(profile.getPhoto());
			
			return user;
		} catch (EngageFailureException e) {
			throw new TwentyAtProviderException(e.getMessage());
		} catch (ErrorResponeException e) {
			throw new TwentyAtProviderException(e.getMessage());
		}		
	}

}
