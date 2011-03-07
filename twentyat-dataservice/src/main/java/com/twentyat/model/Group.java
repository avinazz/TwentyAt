package com.twentyat.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "twentyat_group")
public class Group implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "twentyat_group_id")
	@GeneratedValue
	private Integer groupId;
	
	@Column(name="group_name")
	private String groupName;
	
	@Column(name="twentyat_user_id")
	private String twentyAtUserId;
	
	@OneToMany(cascade=CascadeType.ALL, targetEntity=com.twentyat.model.FriendsMapping.class)	
	@JoinColumn(name="twentyat_group_id")
	private List<FriendsMapping> mapping;
	
	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<FriendsMapping> getMapping() {
		return mapping;
	}

	public void setMapping(List<FriendsMapping> mapping) {
		this.mapping = mapping;
	}

	public String getTwentyAtUserId() {
		return twentyAtUserId;
	}

	public void setTwentyAtUserId(String twentyAtUserId) {
		this.twentyAtUserId = twentyAtUserId;
	}

	
}
