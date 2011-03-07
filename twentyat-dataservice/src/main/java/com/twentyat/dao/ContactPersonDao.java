package com.twentyat.dao;

import com.twentyat.model.ContactPerson;

public interface ContactPersonDao {

	public ContactPerson getContactPersonByFacebookId(String facebookId);
}
