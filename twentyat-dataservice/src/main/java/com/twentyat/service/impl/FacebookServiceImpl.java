package com.twentyat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.googlecode.janrain4j.api.engage.EngageFailureException;
import com.googlecode.janrain4j.api.engage.EngageService;
import com.googlecode.janrain4j.api.engage.ErrorResponeException;
import com.googlecode.janrain4j.api.engage.response.UserDataResponse;
import com.twentyat.exception.SifrProviderException;
import com.twentyat.model.Address;
import com.twentyat.model.TwentyAtUser;
import com.twentyat.model.User;
import com.twentyat.service.FacebookService;

public class FacebookServiceImpl implements FacebookService {
	
	@Autowired
	private EngageService engageService;
	public void setEngageService(EngageService engageService) {
		this.engageService = engageService;
	}
	
	private String token;
	
	public void registerUser(TwentyAtUser user, String token){
		System.out.println("TOKEN : "+token);
		System.out.println("User name : "+user.getUserName());
	}

	public void signout() {

	}

	public User getUser(String token) throws SifrProviderException 
	{
		System.out.println("TOKEN : "+token);
		if(token!=null)
		{
			try 
			{
				
				UserDataResponse response = engageService.authInfo(token);
				
				User user = new User();
				
				Address address = new Address();
				address.setCountry(response.getProfile().getAddress().getCountry());
				address.setLocality(response.getProfile().getAddress().getLocality());
				String postalCode = response.getProfile().getAddress().getPostalCode();
				if(null != postalCode)
				{
					address.setPostalCode(new Integer(postalCode));
				}
				address.setRegion(response.getProfile().getAddress().getRegion());
				address.setStreetAddress(response.getProfile().getAddress().getStreetAddress());
				
				user.setAddress(address);
				
				user.setBrithDate(response.getProfile().getBirthday());
				user.setDisplayName(response.getProfile().getDisplayName());
				user.setFamilyName(response.getProfile().getName().getFamilyName());
				user.setFormattedName(response.getProfile().getName().getFormatted());
				user.setGender(response.getProfile().getGender());
				user.setGivenName(response.getProfile().getName().getGivenName());
				user.setHomePage(response.getProfile().getUrl());
				user.setPrefferedUserName(response.getProfile().getPreferredUsername());
				user.setProfilePhoto(response.getProfile().getPhoto());
				user.setVerifiedEmail(response.getProfile().getVerifiedEmail());
				
				return user;
				
			} catch (EngageFailureException e) {
				throw new SifrProviderException(e);
			} catch (ErrorResponeException e) {
				throw new SifrProviderException(e);
			}
		}
		else
		{
			throw new SifrProviderException("token not found");
		}
	}
}
