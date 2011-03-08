package com.twentyat.service.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.twentyat.model.FriendsMapping;
import com.twentyat.model.TwentyatGroup;
import com.twentyat.model.TwentyatUser;

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
	 * TEST: testGetUser purpose: Tests the getUser method in UserDao
	 * 
	 * @param customerId
	 * 
	 */
	//@Test(groups = { "User GET" })
	@Parameters({ "userid_get" })
	public void testGetUser(String userId) throws Exception {
		
		try
		{
			twentyAtService.getUser(userId);			
		}
		catch(Exception e)
		{
			
		}
	}
	
	@Test(groups = { "Group GET" })
	@Parameters({ "userid_get" })
	public void testGetGroup(String userId) throws Exception{
		List<TwentyatGroup> groups = twentyAtService.getGroupByUserId(userId);
		
		System.out.println("======================");
		System.out.println("==========="+groups.size());
		System.out.println("======================");
		for(TwentyatGroup group : groups)
		{
			Set<FriendsMapping> mappings = group.getFriendsMappings();
			System.out.println("======================");
			System.out.println("=========== Users : "+mappings.size());
			System.out.println("======================");
			for(FriendsMapping mapping : mappings)
			{
				System.out.println("====================================");
				System.out.println("===> Friest Name : "+mapping.getTwentyatUser().getFirstName());				
				System.out.println("====================================");
			}
		}
	}
	
	//@Test(groups = { "TwentyatGroup GET" })
	@Parameters({ "group_name", "userid_get" })
	public void testCreateGroup(String groupName, String userId)
	{
		TwentyatGroup groupSave = new TwentyatGroup();
		groupSave.setGroupName(groupName);
		
		try
		{
			TwentyatGroup group = twentyAtService.saveGroup(groupSave);
			System.out.println("=========================");
			System.out.println("===> Returned ID : "+group.getTwentyatGroupId());
			System.out.println("=========================");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//@Test(groups = { "TwentyatGroup Update" })
	@Parameters({ "group_name", "userid_get" })
	public void testUpdateGroup(String groupName, String userId)
	{
		
		try
		{
			TwentyatUser user = twentyAtService.getUser(userId);
			TwentyatGroup groupSave = new TwentyatGroup();
			groupSave.setGroupName(groupName);
			groupSave.setTwentyatUser(user);
			TwentyatGroup group = twentyAtService.saveGroup(groupSave);
			System.out.println("=========================");
			System.out.println("===> Returned ID : "+group.getTwentyatGroupId());
			System.out.println("=========================");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void afterPropertiesSet() throws Exception {

	}

}