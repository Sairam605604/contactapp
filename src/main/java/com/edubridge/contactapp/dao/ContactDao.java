package com.edubridge.contactapp.dao;

import java.util.List;

import com.edubridge.contactapp.model.Contact;

public interface ContactDao {
	int addContact(Contact c);
	List<Contact> getAllContacts();
	Contact getContact(String name);
	int updateContact(Contact c);
	int deleteContact(String name);
	void deleteAllContacts();
	Contact searchContacts(String name);
}
