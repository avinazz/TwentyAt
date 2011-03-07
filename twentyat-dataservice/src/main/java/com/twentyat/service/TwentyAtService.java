package com.twentyat.service;

import java.util.List;

import com.twentyat.exception.TwentyAtProviderException;
import com.twentyat.model.ContactPerson;
import com.twentyat.model.Group;
import com.twentyat.model.TwentyAtUser;

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
	 * @param TwentyAtUser user
	 *
	 * @return TwentyAtUser
	 * @throws TwentyAtProviderException
	 */
	public TwentyAtUser addTwentyAtUser(String email,String token,String uuid) throws TwentyAtProviderException;
	
	/**
	 * Method used to get User by Id
	 * 
	 * @param String id
	 * @return TwentyAtUser
	 * @throws TwentyAtProviderException
	 */
	public TwentyAtUser getTwentyAtUserByID(String id) throws TwentyAtProviderException;
	
	/**
	 * Method used to get User by Email
	 * 
	 * @param String email
	 * @return TwentyAtUser
	 * @throws TwentyAtProviderException
	 */
	public TwentyAtUser getTwentyAtUserByEMail(String email) throws TwentyAtProviderException;
	
	/**
	 * 
	 * @param id
	 * @return TwentyAtUser
	 * @throws TwentyAtProviderException
	 */
	public TwentyAtUser getUser(String id) throws TwentyAtProviderException;
	
	/**
	 * This method is used to get User information based on facebookId
	 * 
	 * @param facebookId
	 * @return TwentyAtUser
	 * @throws TwentyAtProviderException
	 */
	public TwentyAtUser getUserByFacebookId(String facebookId) throws TwentyAtProviderException;
	/**
	 * 
	 * @param userId
	 * @return List of Group
	 * @throws TwentyAtProviderException
	 */
	public List<Group> getGroupByUserId(String userId) throws TwentyAtProviderException;
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws TwentyAtProviderException
	 */
	public Group getGroup(int id) throws TwentyAtProviderException;
	
	/**
	 * 
	 * @param group
	 * @return
	 * @throws TwentyAtProviderException
	 */
	public Group saveGroup(Group group) throws TwentyAtProviderException;
	
	/**
	 * 
	 * @param group
	 * @return
	 * @throws TwentyAtProviderException
	 */
	public Group updateGroup(Group group) throws TwentyAtProviderException;
	
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
	public ContactPerson getContactPersonByFacebookId(String facebookId) throws TwentyAtProviderException;
}
