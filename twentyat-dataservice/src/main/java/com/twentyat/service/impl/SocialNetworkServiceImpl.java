package com.twentyat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.log4testng.Logger;

import com.googlecode.janrain4j.api.engage.EngageFailureException;
import com.googlecode.janrain4j.api.engage.EngageService;
import com.googlecode.janrain4j.api.engage.ErrorResponeException;
import com.googlecode.janrain4j.api.engage.response.UserDataResponse;
import com.googlecode.janrain4j.api.engage.response.profile.Profile;
import com.twentyat.exception.TwentyAtProviderException;
import com.twentyat.model.TwentyatUser;
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
	public TwentyatUser getUser(String token) throws TwentyAtProviderException 
	{
		
		try {
			UserDataResponse response = engageService.authInfo(token,true);
			Profile profile = response.getProfile();
			
			TwentyatUser user = new TwentyatUser();
			
			String profileUrl = profile.getIdentifier();
			String[] profileSplit = profileUrl.split("=");
		
			String facebookId = profileSplit[1];
			user.setFacebookId(new Long(facebookId));
			user.setFirstName(profile.getName().getGivenName());
			user.setMiddleName(profile.getName().getMiddleName());
			user.setLastName(profile.getName().getFamilyName());
			user.setFriendlyName(profile.getDisplayName());
			user.setMobilePhone(profile.getPhoneNumber());
			user.setPhoto(profile.getPhoto());
			user.setCountry(profile.getAddress().getCountry());
			user.setLocality(profile.getAddress().getLocality());
			String postalCodeStr = profile.getAddress().getPostalCode();
			if(null != postalCodeStr){
				user.setPostalCode(new Integer(postalCodeStr));
			}
			
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

	public TwentyatUser getUserByFacebookId(Long facebookId)	throws TwentyAtProviderException {
		
		try {
			UserDataResponse response = engageService.getUserData(facebookId+"");
			Profile profile = response.getProfile();
			
//			Address address  = profile.getAddress();
//			com.twentyat.model.Address add = new com.twentyat.model.Address();
//			add.setCountry(address.getCountry());
//			add.setLocality(address.getLocality());
//			add.setPostalCode(address.getPostalCode());
//			add.setRegion(address.getRegion());
//			add.setStreetAddress(address.getStreetAddress());
						
			TwentyatUser user = new TwentyatUser();
			
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
