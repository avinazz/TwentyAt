package com.twentyat.service.impl;

import java.util.List;

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

import com.twentyat.model.Group;
import com.twentyat.model.User;
import com.twentyat.service.TwentyAtService;

/**
 * 
 * @author Bipin Sutariya
 *
 */
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml" })
public class TwentyAtServiceTest extends AbstractTransactionalTestNGSpringContextTests implements InitializingBean {

	Logger logger = Logger.getLogger(getClass());

	public TwentyAtServiceTest() {
		super();
	}
	@Autowired
	@Qualifier("twentyAtService")
	@Resource(name = "twentyAtService")
	private TwentyAtService twentyAtService = null;

	/**
	 * @param service
	 *            the twentyAtService to set
	 */
	public void setTwentyAtService(TwentyAtService twentyAtService) {
		this.twentyAtService = twentyAtService;
	}

	// =======================================================================//
	// ===== Start the Unit Tests ============================================//
	// =======================================================================//

	/**
	 * TEST: testAddTwentyAtUser purpose: Tests the addTwentyAtUser method
	 * 
	 * @param User user, String token
	 * 
	 */
	  
	@Test(groups = { "User Add" }) 
	@Parameters({ "userIdAdd","tokenAdd","firstNameAdd","lastNameAdd","isActiveAdd","emailAdd" })
	public void testAddTwentyAtUser(String userIdAdd,String tokenAdd,String firstNameAdd, String lastNameAdd, Boolean isActiveAdd, String emailAdd ) throws Exception { 
	try	{
			logger.debug("============Test Case Started For testAddTwentyAtUser ===========");
			User userAdd = new User(); 
			userAdd.setTwentyAtUserId(userIdAdd);
			userAdd.setIsActive(isActiveAdd);
			userAdd.setEmail(emailAdd);
			userAdd.setFirstName(firstNameAdd);
			userAdd.setLastName(lastNameAdd);
			
			User user=twentyAtService.addTwentyAtUser(userAdd,tokenAdd);
			
			logger.debug("First Name::::: "+user.getFirstName());
			logger.debug("Last NAme::::: "+user.getLastName());
			logger.debug("User Is Active::::: "+user.getIsActive());
			logger.debug("User's Email Id:::::"+user.getEmail());
						
			Assert.assertEquals(user.getFirstName(), firstNameAdd);
			Assert.assertEquals(user.getLastName(), lastNameAdd);
			Assert.assertEquals(user.getIsActive(), isActiveAdd);
			Assert.assertEquals(user.getEmail(), emailAdd);			
			
			logger.debug("============Test Case Started For testAddTwentyAtUser Null===========");
				
			User userNull = twentyAtService.addTwentyAtUser(null, null);			
			
			
		}
		catch(Exception e) {
			logger.debug("Test Case Failed for the testAddTwentyAtUser");
			logger.debug("Exception:::: "+e.getMessage());
		}	
	}
	
	
	
	/**
	 * TEST: testGetUser purpose: Tests the getUser method in UserDao
	 * 
	 * @param customerId
	 * 
	 */ 
	
	@Test(groups = { "User GET" })
	@Parameters({ "userGet","firstNameGet","lastNameGet","isActiveGet","emailGet" })
	public void testGetUser(String userGet, String firstNameGet, String lastNameGet, Boolean isActiveGet, String emailGet) throws Exception { 
	try	{
			logger.debug("============Test Case Started For testGetUser ===========");
			logger.debug("============User Id:::::"+userGet);		
			User user=twentyAtService.getUser(userGet);			
			logger.debug("First Name::::: "+user.getFirstName());
			logger.debug("Last NAme::::: "+user.getLastName());
			logger.debug("User Is Active::::: "+user.getIsActive());
			logger.debug("User's Email Id:::::"+user.getEmail());
			logger.debug("User's Friendly Name"+user.getFriendlyName()); 
			logger.debug("User's Mobile Phone Number"+user.getMobilePhone());
			
			Assert.assertEquals(user.getFirstName(), firstNameGet);
			Assert.assertEquals(user.getLastName(), lastNameGet);
			System.out.println("user.getIsActive()====>"+user.getIsActive());
			Assert.assertEquals(user.getIsActive(), isActiveGet);
			Assert.assertEquals(user.getEmail(), emailGet);
	 
			
		}
		catch(Exception e) {
			logger.debug("Test Case Failed for the GetUser"+userGet);
			logger.debug("Exception:::: "+e.getMessage());
		}
	
	}
	
	 
//	/**
//	 * TEST: testGetTwentyAtUserByID purpose: Tests the getTwentyAtUserByID
//	 * 
//	 * @param twentyat userId
//	 * 
//	 */
//	         
//	@Test(groups = { "User GET" }) 
//	@Parameters({ "twUserGet","twFirstNameGet","twLastNameGet","twIsActiveGet","twEmailGet" })
//	public void testGetTwentyAtUserByID(String twUserGet, String twFirstNameGet, String twLastNameGet, String twIsActiveGet,String twEmailGet) throws Exception { 
//	try	{
//			logger.debug("============Test Case Started For getTwentyAtUser ===========");
//			logger.debug("============Twentyat User Id:::::"+twUserGet);
//		               
//			User user=twentyAtService.getTwentyAtUserByID(twUserGet);
//		             	   
//			logger.debug("TwentyAt User First Name::::: "+user.getFirstName());
//			logger.debug("TwentyAt User Last NAme::::: "+user.getLastName());
//			logger.debug("TwentyAt User User Is Active::::: "+user.getIsActive());
//			logger.debug("TwentyAt User User's Email Id:::::"+user.getEmail());
//	            
//			Assert.assertEquals(user.getFirstName(), twFirstNameGet);
//			Assert.assertEquals(user.getLastName(), twLastNameGet);
//			Assert.assertEquals(user.getIsActive(), twIsActiveGet);
//			Assert.assertEquals(user.getEmail(), twEmailGet);
//	        
//		}
//		catch(Exception e) {
//			logger.debug("Test Case Failed for the testGetTwentyAtUserByID"+twUserGet);
//			logger.debug("Exception:::: "+e.getMessage());
//		}	
//	}
//	
//	
//	/**
//	 * TEST: testGetTwentyAtUserByEMail purpose: Tests the getTwentyAtUserByEMail
//	 * 
//	 * @param email
//	 * 
//	 */	 
//	@Test(groups = { "User GET" })
//	@Parameters({ "twFirstNameGetByemail","twLastNameGetByemail","twIsActiveGetByemail","twEmailGetByemail" })
//	public void testGetTwentyAtUserByEMail(String twFirstNameGetByemail, String twLastNameGetByemail, String twIsActiveGetByemail,String twEmailGetByemail) throws Exception {
//	try	{
//			logger.debug("============Test Case Started For getTwentyAtUserByEMail ===========");
//			logger.debug("============Twentyat Email id:::::"+twEmailGetByemail);		 
//			User user=twentyAtService.getTwentyAtUserByEMail(twEmailGetByemail);			  
//			logger.debug("TwentyAt User First Name::::: "+user.getFirstName());
//			logger.debug("TwentyAt User Last Name::::: "+user.getLastName());
//			logger.debug("TwentyAt User User Is Active::::: "+user.getIsActive());
//			
//	   
//			Assert.assertEquals(user.getFirstName(), twFirstNameGetByemail);
//			Assert.assertEquals(user.getLastName(), twLastNameGetByemail);
//			Assert.assertEquals(user.getIsActive(), twIsActiveGetByemail);
//			
//	    } 
//		catch(Exception e) {
//			logger.debug("Test Case Failed for the getTwentyAtUserByEMail"+twEmailGetByemail);
//			logger.debug("Exception:::: "+e.getMessage());
//		}
//	}
//
//	
//	/**
//	 * TEST: testGetToken purpose: Tests the getToken
//	 * 
//	 * @param userId
//	 * 
//	 */
//	   
//	@Test(groups = { "User GET" }) 
//	@Parameters({ "userIdGetToken","tokenGetToken" })
//	public void testGetToken(String userIdGetToken,String tokenGetToken) throws Exception { 
//	try	{
//			logger.debug("============Test Case Started For GetToken ===========");
//			logger.debug("============User Id:::::"+userIdGetToken);		 
//			String token=twentyAtService.getToken(tokenGetToken);			
//			logger.debug("Token::::: "+token);		
//			Assert.assertEquals(token, "tokentest");	
//	   } 
//		catch(Exception e) {
//			logger.debug("Test Case Failed for the testGetToken"+userIdGetToken);
//			logger.debug("Exception:::: "+e.getMessage());
//		}
//	}           
//                                 	  
//	              
//	/**
//	 * TEST: testGetGroup purpose: Tests the getGroup
//	 * 
//	 * @param groupid
//	 * 
//	 */
//	 
//	@Test(groups = { "User GET" })    
//	@Parameters({ "groupIdGetGroup" })  
//	public void testGetGroup(int groupIdGetGroup) throws Exception { 
//	try	{
//			logger.debug("============Test Case Started For testGetGroup ===========");
//			logger.debug("============Group ID:::::"+groupIdGetGroup); 
//		    Group group=twentyAtService.getGroup(groupIdGetGroup);			
//			logger.debug("Group Name::::: "+group.getGroupName());	  
//			Assert.assertEquals(group.getGroupName(), "groupnametest");
//			List<User> users = group.getFriends();
//			logger.debug("======================");
//			logger.debug("=========== Users : "+users.size());
//			logger.debug("======================");
//			for(User user : users) {
//				logger.debug("====================================");
//				logger.debug("===> Id : "+user.getTwentyAtUserId());
//				logger.debug("===> Is Active : "+user.getIsActive());				
//				logger.debug("====================================");
//			}	
//	    } 
//		catch(Exception e) {
//			logger.debug("Test Case Failed for the testGetGroup"+groupIdGetGroup);
//			logger.debug("Exception:::: "+e.getMessage());
//		}
//	}
//              
//	
//	/**
//	 * TEST: testSaveGroup purpose: Tests the saveGroup
//	 * 
//	 * @param Group group
//	 * 
//	 */   
//	@Test(groups = { "User GET" })   
//	@Parameters({ "groupSaveGroup" })  
//	public void testSaveGroup(String groupName_SaveGroup) throws Exception { 
//	try	{
//		
//			logger.debug("============Test Case Started For testSaveGroup ===========");
//			Group groupSaveGroup=new Group();
//			groupSaveGroup.setGroupName(groupName_SaveGroup);
//						 
//		    Group group=twentyAtService.saveGroup(groupSaveGroup);			
//			logger.debug("Group Name::::: "+group.getGroupName());	  
//			
//			Assert.assertEquals(group.getGroupName(), groupName_SaveGroup);
//			
//			/*
//			List<User> users = group.getFriends();
//			logger.debug("======================");
//			logger.debug("=========== Users : "+users.size());
//			logger.debug("======================");
//			for(User user : users) {
//				logger.debug("====================================");
//				logger.debug("===> Id : "+user.getTwentyAtUserId());
//				logger.debug("===> Is Active : "+user.getIsActive());				
//				logger.debug("====================================");
//			}	
//			*/
//			
//	    }  
//		catch(Exception e) {
//			logger.debug("Test Case Failed for the testSaveGroup");
//			logger.debug("Exception:::: "+e.getMessage());
//		}
//	} 
//	 
//	
//	/**
//	 * TEST: testUpdateGroup purpose: Tests the updateGroup
//	 * 
//	 * @param Group group
//	 *  
//	 */   
//	@Test(groups = { "User GET" })   
//	@Parameters({ "groupName_updateGroup","groupId_updateGroup" })  
//	public void testUpdateGroup(String groupName_updateGroup, int groupId_updateGroup) throws Exception { 
//	try	{
//			logger.debug("============Test Case Started For testUpdateGroup ===========");
//						
//			Group groupUpdateGroup=new Group();
//			groupUpdateGroup.setGroupId(groupId_updateGroup);
//			groupUpdateGroup.setGroupName(groupName_updateGroup);
//			          
//		    Group group=twentyAtService.updateGroup(groupUpdateGroup);			
//			logger.debug("Group Name::::: "+group.getGroupName());	  
//			Assert.assertEquals(group.getGroupName(), "groupnametest");
//			
//			/*List<User> users = group.getFriends();
//			logger.debug("======================");
//			logger.debug("=========== Users : "+users.size());
//			logger.debug("======================");
//			for(User user : users) {
//				logger.debug("====================================");
//				logger.debug("===> Id : "+user.getTwentyAtUserId());
//				logger.debug("===> Is Active : "+user.getIsActive());				
//				logger.debug("====================================");
//			}*/
//			
//			
//	    }  
//		catch(Exception e) {
//			logger.debug("Test Case Failed for the testSaveGroup");
//			logger.debug("Exception:::: "+e.getMessage());
//		}
//	}
//	 
//	   
//	@Test(groups = { "Group GET" })
//	@Parameters({ "userId_GetGroupByUserId" })
//	public void testGetGroupByUserId(String userId_GetGroupByUserId) throws Exception {
//		List<Group> groups = twentyAtService.getGroupByUserId(userId_GetGroupByUserId);          		 
//		logger.debug("======================");
//		logger.debug("===========Groups : "+groups.size());
//		logger.debug("======================");
//		for(Group group : groups) {
//			List<User> users = group.getFriends();
//			logger.debug("======================");
//			logger.debug("=========== Users : "+users.size());
//			logger.debug("======================");
//			for(User user : users) {
//				logger.debug("====================================");
//				logger.debug("===> Id : "+user.getTwentyAtUserId());
//				logger.debug("===> Is Active : "+user.getIsActive());				
//				logger.debug("====================================");
//			}
//		}
//	}
	
	
	 
	public void afterPropertiesSet() throws Exception {

	}

}