package com.twentyat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity Class for user_auth
 * 
 * @author Bipin Sutariya
 *
 */
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
	
	@Column(name="auth_token")
	private String token;
	
	@Column(name="twentyat_user_id")
	private String twentyAtUserId;
	
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
	public void setTwentyAtUserId(String twentyAtUserId) {
		this.twentyAtUserId = twentyAtUserId;
	}
	public String getTwentyAtUserId() {
		return twentyAtUserId;
	}
}
