package com.twentyat.dao;

import com.twentyat.exception.TwentyAtProviderException;
import com.twentyat.model.TwentyAtUser;

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
	public TwentyAtUser getTwentyAtUserByEmail(String email) throws TwentyAtProviderException;
	
	/**
	 * Method to get User by Id
	 * 
	 * @param id
	 * @return User
	 * @throws TwentyAtProviderException
	 */
	public TwentyAtUser getUser(String id) throws TwentyAtProviderException;
	
	/**
	 * This method is used to get User infomration based on facebookid
	 * 
	 * @param facebookId
	 * @return User
	 * @throws TwentyAtProviderException
	 */
	public TwentyAtUser getUserByFacebookId(String facebookId) throws TwentyAtProviderException;
	/**
	 * Method to save new User 
	 * 
	 * @param user
	 * @return User
	 * @throws TwentyAtProviderException
	 */
	public TwentyAtUser saveUser(TwentyAtUser user) throws TwentyAtProviderException;
	
	/**
	 * Method to update existing User
	 * 
	 * @param user
	 * @return User
	 * @throws TwentyAtProviderException
	 */
	public TwentyAtUser updateUser(TwentyAtUser user) throws TwentyAtProviderException;
	
	/**
	 * Method to delete User
	 * 
	 * @param user
	 * @throws TwentyAtProviderException
	 */
	public void deleteUser(TwentyAtUser user) throws TwentyAtProviderException;
}
