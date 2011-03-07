package com.twentyat.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.log4testng.Logger;

import com.googlecode.janrain4j.api.engage.EngageFailureException;
import com.googlecode.janrain4j.api.engage.EngageService;
import com.googlecode.janrain4j.api.engage.ErrorResponeException;
import com.googlecode.janrain4j.api.engage.response.ContactsResponse;
import com.googlecode.janrain4j.api.engage.response.UserDataResponse;
import com.googlecode.janrain4j.api.engage.response.poco.Contact;
import com.googlecode.janrain4j.api.engage.response.profile.Address;
import com.googlecode.janrain4j.api.engage.response.profile.Profile;
import com.twentyat.exception.TwentyAtProviderException;
import com.twentyat.model.ContactPerson;
import com.twentyat.model.TwentyAtUser;
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
	public TwentyAtUser getUser(String token) throws TwentyAtProviderException 
	{
		
		try {
			UserDataResponse response = engageService.authInfo(token,true);
			Profile profile = response.getProfile();
			
			TwentyAtUser user = new TwentyAtUser();
			
			String profileUrl = profile.getIdentifier();
			String[] profileSplit = profileUrl.split("=");
		
			String facebookId = profileSplit[1];
			user.setFacebookId(facebookId);
			user.setFirstName(profile.getName().getGivenName());
			user.setMiddleName(profile.getName().getMiddleName());
			user.setLastName(profile.getName().getFamilyName());
			user.setFriendlyName(profile.getDisplayName());
			user.setMobilePhone(profile.getPhoneNumber());
			user.setPhoto(profile.getPhoto());
			user.setCountry(profile.getAddress().getCountry());
			user.setLocality(profile.getAddress().getLocality());
			user.setPostalCode(profile.getAddress().getPostalCode());
			user.setRegion(profile.getAddress().getRegion());
			user.setStreetAddress(profile.getAddress().getStreetAddress());
			
//			ContactsResponse contactsResponse = engageService.getContacts(facebookId);
//			List<Contact> contactList = contactsResponse.getContacts();
//			List<ContactPerson> contactPersonList = new ArrayList<ContactPerson>();
//			
//			for(Contact contact : contactList)
//			{
//				ContactPerson contactPerson = new ContactPerson();
//				//contactPerson.setCountry(contact.getBirthday());
//				
//				contactPersonList.add(contactPerson);
//				
//			}
//			user.setContactPerson(contactPersonList);	
			
			return user;
		} catch (EngageFailureException e) {
			throw new TwentyAtProviderException(e.getMessage());
		} catch (ErrorResponeException e) {
			throw new TwentyAtProviderException(e.getMessage());
		}		
	}

	public TwentyAtUser getUserByFacebookId(String facebookId)	throws TwentyAtProviderException {
		
		try {
			UserDataResponse response = engageService.getUserData(facebookId);
			Profile profile = response.getProfile();
			
			Address address  = profile.getAddress();
//			com.twentyat.model.Address add = new com.twentyat.model.Address();
//			add.setCountry(address.getCountry());
//			add.setLocality(address.getLocality());
//			add.setPostalCode(address.getPostalCode());
//			add.setRegion(address.getRegion());
//			add.setStreetAddress(address.getStreetAddress());
						
			TwentyAtUser user = new TwentyAtUser();
			
			//user.setAddress(add);
			user.setEmail(profile.getEmail());
			
			user.setFacebookId(facebookId);
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
