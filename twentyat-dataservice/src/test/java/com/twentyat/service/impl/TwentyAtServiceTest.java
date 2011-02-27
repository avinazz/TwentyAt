package com.twentyat.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.twentyat.service.TwentyAtService;

/**
 * 
 * @author Bipin Sutariya
 *
 */
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml" })
public class TwentyAtServiceTest implements InitializingBean {

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
	public void testGetUser(Long userId) throws Exception {
		System.out.println("User ID : " + userId);

	}

	@Override
	public void afterPropertiesSet() throws Exception {

	}

}