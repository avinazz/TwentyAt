package com.twentyat.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "twentyat_groups")
public class Group implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "twentyat_group_id")	
	private int groupId;
	
	@Column(name="group_name")
	private String groupName;
	
	@Column(name="twentyat_user_id")
	private String twentyAtUserId;
	
	@OneToMany
	@JoinColumn(name="twentyat_group_id") 
	private List<User> friends;

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	public String getTwentyAtUserId() {
		return twentyAtUserId;
	}

	public void setTwentyAtUserId(String twentyAtUserId) {
		this.twentyAtUserId = twentyAtUserId;
	}
	
	
}
