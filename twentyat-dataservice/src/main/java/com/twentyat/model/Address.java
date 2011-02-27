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
	@Column(name="user_id")
	private String addressId;
	
	@Column(name="street_address")
	private String streetAddress;
	
	@Column(name="locality")
	private String locality;
	
	@Column(name="region")
	private String region;
	
	@Column(name="postal_code")
	private int postalCode;
	
	@Column(name="country")
	private String country;
	
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
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "AddressID : "+addressId+"\n"+
		"StreetAddress : "+streetAddress+"\n"+
		"Locality : "+locality+"\n"+
		"Region : "+region+"\n"+
		"Postal Code : "+postalCode+"\n"+
		"Country : "+country;
	}
	
}
