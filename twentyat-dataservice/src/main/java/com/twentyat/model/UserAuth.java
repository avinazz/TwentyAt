package com.twentyat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_auth")
public class UserAuth implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="user_auth_id")
	private int userAuthId;
	
	@Column(name="token")
	private String token;
	
	@Column(name="user_id")
	private int userId;
	
	public int getUserAuthId() {
		return userAuthId;
	}
	public void setUserAuthId(int userAuthId) {
		this.userAuthId = userAuthId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
