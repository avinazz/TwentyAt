package com.twentyat.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import com.twentyat.dao.GroupDao;
import com.twentyat.exception.TwentyAtProviderException;
import com.twentyat.model.Group;

public class GroupDaoHibernate extends  GenericDaoHibernate<Group, Integer>  implements GroupDao {

	
	public GroupDaoHibernate() {
		super(Group.class);
	}

	
	public List<Group> getGroupByUserId(String userId)  throws TwentyAtProviderException {
		List<Group> groupList = getHibernateTemplate().find("from Group where twentyAtUserId=?", userId);
//		List<TwentyAtUser> userList = getHibernateTemplate().find("from User");
//		for(Group group : groupList)
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

	
	public Group saveGroup(Group group) throws TwentyAtProviderException {
		return super.save(group);
	}

	
	public void deleteGroup(int groupId) throws TwentyAtProviderException {
		super.remove(groupId);
	}

	
	public Group updateGroup(Group group) throws TwentyAtProviderException {
		return super.save(group);
	}

	
	public Group getGroup(int groupId) throws TwentyAtProviderException {
		return super.get(groupId);
	}

}
