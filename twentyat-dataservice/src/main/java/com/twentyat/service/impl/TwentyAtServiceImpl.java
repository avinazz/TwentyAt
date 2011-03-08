package com.twentyat.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.log4testng.Logger;

import com.twentyat.dao.ContactPersonDao;
import com.twentyat.dao.GroupDao;
import com.twentyat.dao.UserDao;
import com.twentyat.exception.TwentyAtProviderException;
import com.twentyat.model.ContactPerson;
import com.twentyat.model.TwentyatGroup;
import com.twentyat.model.TwentyatUser;
import com.twentyat.service.SocialNetworkService;
import com.twentyat.service.TwentyAtService;

public class TwentyAtServiceImpl implements TwentyAtService {

	Logger log = Logger.getLogger(getClass());
	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Autowired
	private GroupDao groupDao;

	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
	}

	private ContactPersonDao contactPersonDao;

	public void setContactPersonDao(ContactPersonDao contactPersonDao) {
		this.contactPersonDao = contactPersonDao;
	}

	private SocialNetworkService socialNetworkService;

	public void setSocialNetworkService(
			SocialNetworkService socialNetworkService) {
		this.socialNetworkService = socialNetworkService;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.twentyat.service.TwentyAtService#getUser(java.lang.String)
	 */
	public TwentyatUser getUser(String id) throws TwentyAtProviderException {
		return userDao.getUser(id);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.twentyat.service.TwentyAtService#addTwentyAtUser(com.twentyat.model
	 * .User, java.lang.String)
	 */
	public TwentyatUser addTwentyAtUser(String email, String token, String uuid)
			throws TwentyAtProviderException {
		if (null == uuid || "".equals(uuid) || "null".equals(uuid)) {			
			logger.debug("Add Twenty user called");
			TwentyatUser user = socialNetworkService.getUser(token);
			// if token is valid then check user is already register with
			// twentyat app or not
			UUID generatedUUID = UUID.randomUUID();
			user.setTwentyatUserId(generatedUUID.toString());
			user.setIsActive(true);
			user.setEmail(email);
			// Creating default group for user
			TwentyatGroup group = new TwentyatGroup();
			group.setGroupName("20@ Group");		
			group.setTwentyatUser(user);
			Set<TwentyatGroup> groups = new HashSet<TwentyatGroup>();
			groups.add(group);
			
			user.setTwentyatGroups(groups);			
			user = userDao.saveUser(user);			
			return user;
		} else {
			TwentyatUser user = userDao.getUser(uuid);
			if (true != user.getIsActive()) {
				user.setIsActive(true);				
				// Creating default group for user
				TwentyatGroup group = new TwentyatGroup();
				group.setGroupName("20@ Group");		
				Set<TwentyatGroup> groups = new HashSet<TwentyatGroup>();
				groups.add(group);
				user.setTwentyatGroups(groups);
				
				user = userDao.saveUser(user);				
				return user;
			} else {
				throw new TwentyAtProviderException(uuid+" is already registered");
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.twentyat.service.FacebookService#getTwentyAtUserByID(java.lang.String
	 * )
	 */

	public TwentyatUser getTwentyAtUserByID(String id)
			throws TwentyAtProviderException {
		return userDao.getUser(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.twentyat.service.TwentyAtService#getTwentyAtUserByEMail(java.lang
	 * .String)
	 */

	public TwentyatUser getTwentyAtUserByEMail(String email)
			throws TwentyAtProviderException {
		return userDao.getTwentyAtUserByEmail(email);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.twentyat.service.TwentyAtService#getGroup(java.lang.String)
	 */

	public List<TwentyatGroup> getGroupByUserId(String userId)
			throws TwentyAtProviderException {
		return groupDao.getGroupByUserId(userId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.twentyat.service.TwentyAtService#getGroup(int)
	 */

	public TwentyatGroup getGroup(int id) throws TwentyAtProviderException {
		return groupDao.getGroup(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.twentyat.service.TwentyAtService#saveGroup(com.twentyat.model.Group)
	 */

	public TwentyatGroup saveGroup(TwentyatGroup group) throws TwentyAtProviderException {
		return groupDao.saveGroup(group);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.twentyat.service.TwentyAtService#updateGroup(com.twentyat.model.Group
	 * )
	 */

	public TwentyatGroup updateGroup(TwentyatGroup group) throws TwentyAtProviderException {
		return groupDao.updateGroup(group);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.twentyat.service.TwentyAtService#deleteGroup(int)
	 */

	public void deleteGroup(int id) throws TwentyAtProviderException {
		groupDao.deleteGroup(id);
	}

	public TwentyatUser getUserByFacebookId(Long facebookId)
			throws TwentyAtProviderException {
		return userDao.getUserByFacebookId(facebookId);
	}

	public ContactPerson getContactPersonByFacebookId(Long facebookId)
			throws TwentyAtProviderException {
		return contactPersonDao.getContactPersonByFacebookId(facebookId);
	}
}
