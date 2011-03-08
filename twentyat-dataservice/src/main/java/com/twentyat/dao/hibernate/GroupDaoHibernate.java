package com.twentyat.dao.hibernate;

import java.util.List;

import com.twentyat.dao.GroupDao;
import com.twentyat.exception.TwentyAtProviderException;
import com.twentyat.model.TwentyatGroup;

public class GroupDaoHibernate extends  GenericDaoHibernate<TwentyatGroup, Integer>  implements GroupDao {

	
	public GroupDaoHibernate() {
		super(TwentyatGroup.class);
	}

	public List<TwentyatGroup> getGroupByUserId(String userId)  throws TwentyAtProviderException {
		List<TwentyatGroup> groupList = getHibernateTemplate().find("from TwentyatGroup where twentyatUser.twentyatUserId=?", userId);
//		List<TwentyAtUser> userList = getHibernateTemplate().find("from User");
//		for(TwentyatGroup group : groupList)
//		{		
//			List<TwentyAtUser> users = new ArrayList<User>();
//			for(TwentyAtUser user : userList)
//			{
//				String groupIdFromUser = user.getGroupId();
//				Integer groupId = group.getGroupId();
//				if(null != groupIdFromUser && !"".equals(groupIdFromUser))
//				{
//					String[] ids = groupIdFromUser.split(",");
//					
//					for(String id : ids)
//					{						
//						if(id.equals(groupId))
//						{
//							users.add(user);
//						}
//					}
//				}
//			}
//			group.setFriends(users);
//		}		
		return groupList;
	}

	
	public TwentyatGroup saveGroup(TwentyatGroup group) throws TwentyAtProviderException {
		return super.save(group);
	}

	
	public void deleteGroup(int groupId) throws TwentyAtProviderException {
		super.remove(groupId);
	}

	
	public TwentyatGroup updateGroup(TwentyatGroup group) throws TwentyAtProviderException {
		return super.save(group);
	}

	
	public TwentyatGroup getGroup(int groupId) throws TwentyAtProviderException {
		return super.get(groupId);
	}

}
