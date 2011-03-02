package com.twentyat.dao;

import java.util.List;

import com.twentyat.exception.TwentyAtProviderException;
import com.twentyat.model.Group;

public interface GroupDao {
	
	public List<Group> getGroupByUserId(String userId)  throws TwentyAtProviderException;
	
	public Group saveGroup(Group group) throws TwentyAtProviderException;
	
	public void deleteGroup(int groupId) throws TwentyAtProviderException;
	
	public Group updateGroup(Group group) throws TwentyAtProviderException;
	
	public Group getGroup(int groupId) throws TwentyAtProviderException;
}
