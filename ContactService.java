package com.yaumel.ContactsApp;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
	
	// Map is being used instead of an ArrayList for faster lookup of ID's to avoid duplicate entries
	private Map<String, Contact> contactListMap = new HashMap<>();
	
	/**
	 * Returns a contact in contact list by ID.
	 * 
	 * @param contactId
	 * @return contact matching contact ID
	 */
	public Contact getContact(String contactId) {
		return contactListMap.get(contactId);
	}
	
	/**
	 * Adds contact to contact list.
	 * 
	 * @param contact
	 * @throws IllegalArgumentException when key already exists
	 */
	public void addContact(Contact contact) {
		if(contact == null || contactListMap.containsKey(contact.getId())) {
			throw new IllegalArgumentException("The key already exists or is null!");
		}
		contactListMap.put(contact.getId(), contact);
	}
	
	/**
	 * Updates contact in contact list.
	 * 
	 * @param contact
	 * @throws IllegalArgumentException when key does not exists since there is no contact to be updated
	 */
	public void updateContact(Contact contact) {
		if(contact == null || !contactListMap.containsKey(contact.getId())) {
			throw new IllegalArgumentException("The key does not exists!");
		}
		contactListMap.put(contact.getId(), contact);
	}
	
	/**
	 * Removes a contact from contact list.
	 * 
	 * @param contact
	 */
	public void removeContact(Contact contact) {
		if(contact == null || !contactListMap.containsKey(contact.getId())) { // If contact does not exist then no need to do anything
			return;
		}
		contactListMap.remove(contact.getId());
	}
	
	/**
	 * 
	 * @return the number of contacts in contact list
	 */
	public int getContactsCount() {
		return contactListMap.size();
	}
	
	/**
	 * Clears out the entire contact list.
	 */
	public void clearContacts() {
		contactListMap.clear();
	}
}
