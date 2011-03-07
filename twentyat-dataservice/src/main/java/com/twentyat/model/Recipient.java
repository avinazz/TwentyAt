package com.twentyat.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recipient") 

public class Recipient implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id	
	@Column(name = "id")
	@GeneratedValue
	private String id;
	
	@Column(name="recipient_id")
	private String recipientId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}
	
	
	
}
