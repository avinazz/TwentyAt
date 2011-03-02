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
	 * TEST: testGetUser purpose: Tests the getUser method in UserDao
	 * 
	 * @param customerId
	 * 
	 */
	@Test(groups = { "User GET" })
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
		
		logger.debug("======================");
		logger.debug("==========="+groups.size());
		logger.debug("======================");
		for(Group group : groups)
		{
			List<User> users = group.getFriends();
			logger.debug("======================");
			logger.debug("=========== Users : "+users.size());
			logger.debug("======================");
			for(User user : users)
			{
				logger.debug("====================================");
				logger.debug("===> Id : "+user.getTwentyAtUserId());
				logger.debug("===> Is Active : "+user.getIsActive());
				logger.debug("====================================");
			}
		}
	}
	
	public void afterPropertiesSet() throws Exception {

	}

}