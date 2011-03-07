package com.twentyat.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity class for twentyst_user
 * 
 * @author Bipin Sutariya
 * 
 */

@Entity
@Table(name = "twentyat_user")
public class TwentyAtUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id	
	@Column(name = "twentyat_user_id")
	private String twentyAtUserId;

	@Column(name="friendly_name")
	private String friendlyName;
			
	@Column(name = "first_name")
	private String firstName;

	@Column(name="middle_name")
	private String middleName;
	
	@Column(name="facebook_id")
	private String facebookId;
	
	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "mobile_phone")
	private String mobilePhone;

	@Column(name = "photo")
	private String photo;

	@OneToOne(cascade=CascadeType.ALL, targetEntity=com.twentyat.model.Group.class)
	@JoinColumn(name="twentyat_user_id", insertable=true, updatable=true) 
	private Group group;
	
	@Column(name="is_active")
	private Boolean isActive;
	
	@OneToOne(cascade=CascadeType.ALL, targetEntity=com.twentyat.model.ContactPerson.class)
	@JoinColumn(name="twentyat_user_id", insertable=true, updatable=true)
	private List<ContactPerson> contactPerson;
	
	@Column(name="street_address")
	private String streetAddress;
	
	@Column(name="locality")
	private String locality;
	
	@Column(name="region")
	private String region;
	
	@Column(name="postal_code")
	private String postalCode;
	
	@Column(name="country")
	private String country;	
		
	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTwentyAtUserId() {
		return twentyAtUserId;
	}

	public void setTwentyAtUserId(String twentyAtUserId) {
		this.twentyAtUserId = twentyAtUserId;
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

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public List<ContactPerson> getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(List<ContactPerson> contactPerson) {
		this.contactPerson = contactPerson;
	}
	
}
