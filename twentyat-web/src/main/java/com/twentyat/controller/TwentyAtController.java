package com.twentyat.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.googlecode.janrain4j.json.JSONObject;
import com.twentyat.exception.TwentyAtProviderException;
import com.twentyat.model.Address;
import com.twentyat.model.User;
import com.twentyat.service.SocialNetworkService;
import com.twentyat.service.TwentyAtService;

/**
 * Sample controller whose response it rendered to the browser as JSON
 * @author Bipin Sutariya
 */
@Controller
public class TwentyAtController
{
	private static Logger logger = Logger.getLogger(TwentyAtController.class);
	
	private SocialNetworkService socialNetworkService;
	public void setSocialNetworkService(
			SocialNetworkService socialNetworkService) {
		this.socialNetworkService = socialNetworkService;
	}
	
	private TwentyAtService twentyAtService;
	public void setTwentyAtService(TwentyAtService twentyAtService) {
		this.twentyAtService = twentyAtService;
	}
	
	/**
	 * Method to register new user 
	 * Access this method by http://localhost:8080/twentyat-web/register/{token}
	 *
	 * @param String token (JanRain auth_token from callback url)
	 * 
	 * @return List of Object as JSON	
	 */
    @RequestMapping( value = "/register/{token}", method = RequestMethod.GET)
    @ResponseBody    
    public List<Object> addTwentyAtUser(@PathVariable String token)
    {
    	String email = null;
    	User user = null;
    	
    	logger.debug("Add Twenty user called");
    	List<Object> returnObj = new ArrayList<Object>();
    	
    	Status status = new Status();
    	
    	//Checking passed token is valid or not
    	try {
    		user = socialNetworkService.getUser(token);
    	}
    	catch(Exception e)
    	{
    		if(e.getMessage().contains("No Data found"))
    		{
    			status.setCode(0);
    			status.setMessage("auth_token is expired");
    			returnObj.add(status);
    			return returnObj;
    		}
    		
    		status.setCode(0);
    		status.setMessage(e.getMessage());
    		returnObj.add(status);
			return returnObj;
    	}
    	
    	//if token is valid then check user is already register with twentyat app or not
    	try
    	{
    		email = user.getEmail();
    		User dbUser = twentyAtService.getTwentyAtUserByEMail(email);
    		
        	if(null == dbUser)
        	{
        		
        		
	        	UUID uuid = UUID.randomUUID();
	        	
	        	user.setTwentyAtUserId(uuid.toString());
	        	Address address = user.getAddress();
	        	address.setTwentyAtUserId(uuid.toString());
	        	user.setAddress(address);
	        	
				user = twentyAtService.addTwentyAtUser(user, token);
				
				//Call method to create XMPP account
				
				returnObj.add(user);
				status.setCode(0);
				status.setMessage("success");
				returnObj.add(status);				
        	}
        	else
        	{
        		logger.debug(email+" is already registered");
        		status.setCode(0);
    			status.setMessage(email+" is already registered");
        	}
		} catch (TwentyAtProviderException e) {
			logger.error(e);
			status.setCode(1);
			status.setMessage(e.getMessage());
			
		} catch(Exception e) {
			logger.error(e);
			status.setCode(1);
			status.setMessage(e.getMessage());
		}
    	
		returnObj.add(status);
		logger.info("Add TwentyAt user ends");
		return returnObj;
    }
    
    /**
	 * Method to register new user 
	 * Access this method by http://localhost:8080/twentyat-web/register/{token}
	 *
	 * @param String token (JanRain auth_token from callback url)
	 * 
	 * @return List of Object as JSON	
	 */
    @RequestMapping( value = "/login/{token}", method = RequestMethod.GET)
    @ResponseBody    
    public List<Object> login(@PathVariable String token)
    {
    	String email = null;
    	User user = null;
    	
    	logger.debug("Login Twenty user called");
    	List<Object> returnObj = new ArrayList<Object>();
    	
    	Status status = new Status();
    	
    	//Checking passed token is valid or not
    	try {
    		user = socialNetworkService.getUser(token);
    	}
    	catch(Exception e)
    	{
    		if(e.getMessage().contains("No Data found"))
    		{
    			status.setCode(0);
    			status.setMessage("auth_token is expired");
    			returnObj.add(status);
    			return returnObj;
    		}
    		
    		status.setCode(0);
    		status.setMessage(e.getMessage());
    		returnObj.add(status);
			return returnObj;
    	}
    	
    	//if token is valid then check user is already register with twentyat app or not
    	try
    	{
    		email = user.getEmail();
    		User dbUser = twentyAtService.getTwentyAtUserByEMail(email);
    		
    	}catch (TwentyAtProviderException e) {
			logger.error(e);
			status.setCode(1);
			status.setMessage(e.getMessage());
			
		} catch(Exception e) {
			logger.error(e);
			status.setCode(1);
			status.setMessage(e.getMessage());
		}
    	
		returnObj.add(status);
		return returnObj;
    	
    }
}