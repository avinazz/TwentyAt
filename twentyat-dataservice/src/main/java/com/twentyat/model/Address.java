package com.twentyat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="address_id")
	private String addressId;
	
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
	
	@Column(name="twentyat_user_id")
	private String twentyAtUserId;
	
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
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
	public void setTwentyAtUserId(String twentyAtUserId) {
		this.twentyAtUserId = twentyAtUserId;
	}
	public String getTwentyAtUserId() {
		return twentyAtUserId;
	}
}
