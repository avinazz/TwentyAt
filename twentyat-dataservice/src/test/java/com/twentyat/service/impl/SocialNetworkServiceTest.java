package com.twentyat.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.twentyat.model.User;
import com.twentyat.service.SocialNetworkService;

     
/**
 * 
 * @author Mayuri Ruparel 
 *
 */
  
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml" })
public class SocialNetworkServiceTest extends AbstractTransactionalTestNGSpringContextTests implements InitializingBean {
	Logger logger = Logger.getLogger(getClass());	
	public SocialNetworkServiceTest(){
		super();
	}
		
	@Autowired
	@Qualifier("socialNetworkService")
	@Resource(name = "socialNetworkService")
	private SocialNetworkService socialNetworkService = null;
	/**
	 * @param service
	 *            the SocialNetworkService to set
	 */ 
	             
	public void setSocialNetworkService(SocialNetworkService socialNetworkService) {
		this.socialNetworkService = socialNetworkService;
	}
 		
	/**
	 * TEST: testGetUser purpose: Tests the GetUser of SocialNetworkService
	 * 
	 * @param token
	 * 
	 */
 
	 
	@Test(groups = { "User GET" })
	@Parameters({ "token_GetUserByToken","firstName_GetUserByToken","lastName_GetUserByToken","isActive_GetUserByToken","email_GetUserByToken" })
	public void testGetUser(String token_GetUserByToken, String firstName_GetUserByToken, String lastName_GetUserByToken,String isActive_GetUserByToken, String email_GetUserByToken) throws Exception { 
	try	{           
			logger.debug("============Test Case Started For testGetUserof SocialNetwokService ===========");
			logger.debug("============Token:::::"+token_GetUserByToken);
		    
			if(token_GetUserByToken.equals(null)|| token_GetUserByToken.equals("")){
				logger.debug(":::::::::TEST FAILED::::::::::Input Parameter i.e. Token is Null");
				logger.debug("Please Specify the input parameter");
				return;
			}
			
			User user=socialNetworkService.getUser(token_GetUserByToken); 
		 	
			logger.debug("First Name::::: "+user.getFirstName());
			logger.debug("Last NAme::::: "+user.getLastName());
			logger.debug("User Is Active::::: "+user.getIsActive());
			logger.debug("User's Email Id:::::"+user.getEmail());
			logger.debug("User's Friendly Name:::"+user.getFriendlyName()); 
			logger.debug("User's Mobile Phone Number:::"+user.getMobilePhone());
	        
			Assert.assertEquals(user.getFirstName(), firstName_GetUserByToken);
			Assert.assertEquals(user.getLastName(), lastName_GetUserByToken);
			Assert.assertEquals(user.getIsActive(), isActive_GetUserByToken); 
			Assert.assertEquals(user.getEmail(), email_GetUserByToken);
				                                                   
		}
		catch(Exception e) {
			logger.debug("Test Case Failed for the GetUser of SocialNetworkService "+token_GetUserByToken);
			logger.debug("Exception:::: "+e.getMessage());
		}
	
	}	
	///abstract method of
	public void afterPropertiesSet() throws Exception {

	}
}
