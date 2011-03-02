package com.twentyat.dao.hibernate;

import java.util.List;

import com.twentyat.dao.GroupDao;
import com.twentyat.exception.TwentyAtProviderException;
import com.twentyat.model.Group;
import com.twentyat.model.User;

public class GroupDaoHibernate extends  GenericDaoHibernate<Group, Integer>  implements GroupDao {

	
	public GroupDaoHibernate() {
		super(Group.class);
	}

	
	public List<Group> getGroupByUserId(String userId)  throws TwentyAtProviderException {
		List<Group> groupList = getHibernateTemplate().find("from Group where twentyAtUserId=?", userId);
		
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
