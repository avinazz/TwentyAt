package com.twentyat.dao;

import com.twentyat.exception.TwentyAtProviderException;
import com.twentyat.model.TwentyatUser;

/**
 * User DAO (Data Access Object) with common methods to CRUD POJOs.
 * 
 * @author Bipin Sutariya
 *
 */
public interface UserDao {
	
	/**
	 * Method to get User information by Email address
	 * 
	 * @param email
	 * @return User
	 * @throws TwentyAtProviderException
	 */
	public TwentyatUser getTwentyAtUserByEmail(String email) throws TwentyAtProviderException;
	
	/**
	 * Method to get User by Id
	 * 
	 * @param id
	 * @return User
	 * @throws TwentyAtProviderException
	 */
	public TwentyatUser getUser(String id) throws TwentyAtProviderException;
	
	/**
	 * This method is used to get User infomration based on facebookid
	 * 
	 * @param facebookId
	 * @return User
	 * @throws TwentyAtProviderException
	 */
	public TwentyatUser getUserByFacebookId(Long facebookId) throws TwentyAtProviderException;
	/**
	 * Method to save new User 
	 * 
	 * @param user
	 * @return User
	 * @throws TwentyAtProviderException
	 */
	public TwentyatUser saveUser(TwentyatUser user) throws TwentyAtProviderException;
	
	/**
	 * Method to update existing User
	 * 
	 * @param user
	 * @return User
	 * @throws TwentyAtProviderException
	 */
	public TwentyatUser updateUser(TwentyatUser user) throws TwentyAtProviderException;
	
	/**
	 * Method to delete User
	 * 
	 * @param user
	 * @throws TwentyAtProviderException
	 */
	public void deleteUser(TwentyatUser user) throws TwentyAtProviderException;
}
