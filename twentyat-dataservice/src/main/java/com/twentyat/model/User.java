package com.twentyat.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author Bipin Sutariya
 *
 */

@Entity
@Table(name="user")
public class User implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int userId;
	
	@Column(name="display_name")
	private String displayName;
	
	@Column(name="gender")
	private String gender;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	@Column(name="family_name")
	private String familyName;
	
	@Column(name="given_name")
	private String givenName;
	
	@Column(name="formatted_name")
	private String formattedName;
	
	@Column(name="profile_photo")
	private String profilePhoto;
	
	@Column(name="brith_date")
	private Date brithDate;
	
	@Column(name="home_age")
	private String homePage;
	
	@Column(name="preffered_username")
	private String prefferedUserName;
	
	@Column(name="verified_email")
	private String verifiedEmail;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getGivenName() {
		return givenName;
	}
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	public String getFormattedName() {
		return formattedName;
	}
	public void setFormattedName(String formattedName) {
		this.formattedName = formattedName;
	}
	public String getProfilePhoto() {
		return profilePhoto;
	}
	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}
	public Date getBrithDate() {
		return brithDate;
	}
	public void setBrithDate(Date brithDate) {
		this.brithDate = brithDate;
	}
	public String getHomePage() {
		return homePage;
	}
	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}
	public String getPrefferedUserName() {
		return prefferedUserName;
	}
	public void setPrefferedUserName(String prefferedUserName) {
		this.prefferedUserName = prefferedUserName;
	}
	public String getVerifiedEmail() {
		return verifiedEmail;
	}
	public void setVerifiedEmail(String verifiedEmail) {
		this.verifiedEmail = verifiedEmail;
	}
	
	@Override
	public String toString() {
		
		return "UserId : "+userId+"\n"+
		"DisplayName : "+displayName+"\n"+
		"Gender : "+gender+"\n"+
		"Address : "+address.toString()+
		"Family Name : "+familyName+"\n"+
		"Given Name : "+givenName+"\n"+
		"Fomratted Name : "+formattedName+"\n"+
		"Profile Photo : "+profilePhoto+"\n"+
		"BrithDate : "+brithDate.toString()+"\n"+
		"Home Page : "+homePage+"\n"+
		"Preffered Username : "+prefferedUserName+"\n"+
		"Verfiried Email : "+verifiedEmail;
		
	}
}
