package com.twentyat.service;

import java.util.List;

import com.twentyat.exception.TwentyAtProviderException;
import com.twentyat.model.ContactPerson;
import com.twentyat.model.TwentyatGroup;
import com.twentyat.model.TwentyatUser;

/**
 * This class is used to get connect to database and get result
 * 
 * @author Bipin Sutariya
 *
 */
public interface TwentyAtService {
	
	/**
	 * Method used to get Twentyat User information
	 * 
	 * @param TwentyatUser user
	 *
	 * @return TwentyatUser
	 * @throws TwentyAtProviderException
	 */
	public TwentyatUser addTwentyAtUser(String email,String token,String uuid) throws TwentyAtProviderException;
	
	/**
	 * Method used to get User by Id
	 * 
	 * @param String id
	 * @return TwentyatUser
	 * @throws TwentyAtProviderException
	 */
	public TwentyatUser getTwentyAtUserByID(String id) throws TwentyAtProviderException;
	
	/**
	 * Method used to get User by Email
	 * 
	 * @param String email
	 * @return TwentyatUser
	 * @throws TwentyAtProviderException
	 */
	public TwentyatUser getTwentyAtUserByEMail(String email) throws TwentyAtProviderException;
	
	/**
	 * 
	 * @param id
	 * @return TwentyatUser
	 * @throws TwentyAtProviderException
	 */
	public TwentyatUser getUser(String id) throws TwentyAtProviderException;
	
	/**
	 * This method is used to get User information based on facebookId
	 * 
	 * @param facebookId
	 * @return TwentyatUser
	 * @throws TwentyAtProviderException
	 */
	public TwentyatUser getUserByFacebookId(Long facebookId) throws TwentyAtProviderException;
	/**
	 * 
	 * @param userId
	 * @return List of TwentyatGroup
	 * @throws TwentyAtProviderException
	 */
	public List<TwentyatGroup> getGroupByUserId(String userId) throws TwentyAtProviderException;
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws TwentyAtProviderException
	 */
	public TwentyatGroup getGroup(int id) throws TwentyAtProviderException;
	
	/**
	 * 
	 * @param TwentyatGroup
	 * @return
	 * @throws TwentyAtProviderException
	 */
	public TwentyatGroup saveGroup(TwentyatGroup group) throws TwentyAtProviderException;
	
	/**
	 * 
	 * @param TwentyatGroup
	 * @return
	 * @throws TwentyAtProviderException
	 */
	public TwentyatGroup updateGroup(TwentyatGroup group) throws TwentyAtProviderException;
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws TwentyAtProviderException
	 */
	public void deleteGroup(int id) throws TwentyAtProviderException;
	
	/**
	 * This method is used to get ContactPerson by facebookid
	 * 
	 * @param facebookId
	 * @return ContactPerson
	 * @throws TwentyAtProviderException
	 */
	public ContactPerson getContactPersonByFacebookId(Long facebookId) throws TwentyAtProviderException;
}
