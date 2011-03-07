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

import com.twentyat.model.FriendsMapping;
import com.twentyat.model.Group;
import com.twentyat.model.TwentyAtUser;

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
		List<Group> groups = twentyAtService.getGroupByUserId(userId);
		
		System.out.println("======================");
		System.out.println("==========="+groups.size());
		System.out.println("======================");
		for(Group group : groups)
		{
			List<FriendsMapping> mappings = group.getMapping();
			System.out.println("======================");
			System.out.println("=========== Users : "+mappings.size());
			System.out.println("======================");
			for(FriendsMapping mapping : mappings)
			{
				System.out.println("====================================");
				System.out.println("===> Friest Name : "+mapping.getFriend().getFirstName());				
				System.out.println("====================================");
			}
		}
	}
	
	//@Test(groups = { "Group GET" })
	@Parameters({ "group_name", "userid_get" })
	public void testCreateGroup(String groupName, String userId)
	{
		Group groupSave = new Group();
		groupSave.setGroupName(groupName);
		
		try
		{
			Group group = twentyAtService.saveGroup(groupSave);
			System.out.println("=========================");
			System.out.println("===> Returned ID : "+group.getGroupId());
			System.out.println("=========================");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//@Test(groups = { "Group Update" })
	@Parameters({ "group_name", "userid_get" })
	public void testUpdateGroup(String groupName, String userId)
	{
		Group groupSave = new Group();
		groupSave.setGroupName(groupName);
		groupSave.setTwentyAtUserId(userId);
		
		try
		{
			Group group = twentyAtService.saveGroup(groupSave);
			System.out.println("=========================");
			System.out.println("===> Returned ID : "+group.getGroupId());
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