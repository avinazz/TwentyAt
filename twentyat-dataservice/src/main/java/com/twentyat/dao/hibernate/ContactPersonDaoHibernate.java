package com.twentyat.dao.hibernate;

import java.util.List;

import com.twentyat.dao.ContactPersonDao;
import com.twentyat.dao.UserDao;
import com.twentyat.model.ContactPerson;
import com.twentyat.model.TwentyAtUser;

public class ContactPersonDaoHibernate extends GenericDaoHibernate<ContactPerson, String> implements ContactPersonDao {

	public ContactPersonDaoHibernate() {
		super(ContactPerson.class);		
	}

	public ContactPerson getContactPersonByFacebookId(String facebookId) {
		List<ContactPerson> contactPersons = getHibernateTemplate().find("from ContactPerson WHERE facebookId=?", facebookId);
		
		if(null != contactPersons && contactPersons.size()>0)
		{
			return contactPersons.get(0);
		}
		
		return null;
	}

}
