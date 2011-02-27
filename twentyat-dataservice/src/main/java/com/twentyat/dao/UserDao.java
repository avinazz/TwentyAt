package com.twentyat.dao;

import com.twentyat.exception.TwentyAtProviderException;
import com.twentyat.model.User;

/**
 * User DAO (Data Access Object) with common methods to CRUD POJOs.
 *
 * <p>Extend this interface if you want typesafe (no casting necessary) DAO's for your
 * domain objects.
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
	public User getTwentyAtUserByEmail(String email) throws TwentyAtProviderException;
	
	/**
	 * Method to get User by Id
	 * 
	 * @param id
	 * @return User
	 * @throws TwentyAtProviderException
	 */
	public User getUser(String id) throws TwentyAtProviderException;
	
	/**
	 * Method to save new User 
	 * 
	 * @param user
	 * @return User
	 * @throws TwentyAtProviderException
	 */
	public User saveUser(User user) throws TwentyAtProviderException;
	
	/**
	 * Method to update existing User
	 * 
	 * @param user
	 * @return User
	 * @throws TwentyAtProviderException
	 */
	public User updateUser(User user) throws TwentyAtProviderException;
	
	/**
	 * Method to delete User
	 * 
	 * @param user
	 * @throws TwentyAtProviderException
	 */
	public void deleteUser(User user) throws TwentyAtProviderException;
}
