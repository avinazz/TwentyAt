package com.twentyat.service;

import java.util.List;

import com.twentyat.exception.TwentyAtProviderException;
import com.twentyat.model.Group;
import com.twentyat.model.User;

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
	 * @param User user
	 * @param String token
	 * @return User
	 * @throws TwentyAtProviderException
	 */
	public User addTwentyAtUser(User user, String token) throws TwentyAtProviderException;
	
	/**
	 * Method used to get User by Id
	 * 
	 * @param String id
	 * @return User
	 * @throws TwentyAtProviderException
	 */
	public User getTwentyAtUserByID(String id) throws TwentyAtProviderException;
	
	/**
	 * Method used to get User by Email
	 * 
	 * @param String email
	 * @return User
	 * @throws TwentyAtProviderException
	 */
	public User getTwentyAtUserByEMail(String email) throws TwentyAtProviderException;
	 
	/** 
	 * This method is used to get token for registered User based on provided user id
	 * 
	 * @param id
	 * @return token - String
	 */
	public String getToken(String id) throws TwentyAtProviderException;
	  
	/**
	 * 
	 * @param id
	 * @return
	 * @throws TwentyAtProviderException
	 */
	         
	public User getUser(String id) throws TwentyAtProviderException;
	
	/**
	 * 
	 * @param userId
	 * @return
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
	
	
}
