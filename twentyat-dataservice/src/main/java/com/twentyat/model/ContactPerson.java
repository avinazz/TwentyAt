package com.twentyat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;


public class ContactPerson implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id	
	@Column(name = "contact_id")
	private String contactId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mobilephone")
	private String mobilePhone;
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="friendly_name")
	private String friendlyName;
	
	@Column(name="middle_name")
	private String middleName;
	
	@Column(name="faebook_id")
	private String facebookId;
	
	public String getContactId() {
		return contactId;
	}
	public void setContactId(String contactId) {
		this.contactId = contactId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getFriendlyName() {
		return friendlyName;
	}
	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getFacebookId() {
		return facebookId;
	}
	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}
	
	
}
