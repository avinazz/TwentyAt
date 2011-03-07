package com.twentyat.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="friends_mapping")
public class FriendsMapping implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="friends_mapping_id")
	private Integer friendsMappingId;
	
	@Column(name="twentyat_group_id")
	private Integer groupId;
	
	@OneToOne(cascade=CascadeType.ALL, targetEntity=com.twentyat.model.TwentyAtUser.class)
	@JoinColumn(name="friends_id") 
	private TwentyAtUser friend;

	public Integer getFriendsMappingId() {
		return friendsMappingId;
	}
	public void setFriendsMappingId(Integer friendsMappingId) {
		this.friendsMappingId = friendsMappingId;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public TwentyAtUser getFriend() {
		return friend;
	}
	public void setFriend(TwentyAtUser friend) {
		this.friend = friend;
	}
	
	
}
