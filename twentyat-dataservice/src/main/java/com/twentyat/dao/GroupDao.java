package com.twentyat.dao;

import java.util.List;

import com.twentyat.exception.TwentyAtProviderException;
import com.twentyat.model.TwentyatGroup;

public interface GroupDao {
	
	public List<TwentyatGroup> getGroupByUserId(String userId)  throws TwentyAtProviderException;
	
	public TwentyatGroup saveGroup(TwentyatGroup group) throws TwentyAtProviderException;
	
	public void deleteGroup(int groupId) throws TwentyAtProviderException;
	
	public TwentyatGroup updateGroup(TwentyatGroup group) throws TwentyAtProviderException;
	
	public TwentyatGroup getGroup(int groupId) throws TwentyAtProviderException;
}
