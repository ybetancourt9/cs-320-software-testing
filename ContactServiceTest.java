package com.yaumel.ContactsApp.testing;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import com.yaumel.ContactsApp.Contact;
import com.yaumel.ContactsApp.ContactService;

public class ContactServiceTest {
	
	private ContactService contactService;
	private Contact contact1;
	private Contact contact2;
	private Contact contact3;

	@BeforeEach
	void setUp() {
		// primer that creates three contacts and adds them to the contact list via the service
		contact1 = new Contact("firstName1", "lastName1", "1123456789", "100 Main, Murrells Inlet, SC", "contact1");
		contact2 = new Contact("firstName2", "lastName2", "1123456789", "100 Main, Murrells Inlet, SC", "contact2");
		contact3 = new Contact("firstName3", "lastName3", "1123456789", "100 Main, Murrells Inlet, SC", "contact3");
		contactService = new ContactService();
		contactService.addContact(contact1);
		contactService.addContact(contact2);
		contactService.addContact(contact3);
	}
	
	@Test
	void checkAddContact() {
		assertThrows(IllegalArgumentException.class, () -> {
	        Contact newContact = null;
	        contactService.addContact(newContact);
	    });
		assertThrows(IllegalArgumentException.class, () -> {
	        Contact newContact = new Contact("firstName", "lastName", "9876543210", "Some new address", "contact3"); // a contact with this id already exists
	        contactService.addContact(newContact);
	    });
		
		Contact newContact = new Contact("firstName", "lastName", "9876543210", "Some new address", "contact4");
		contactService.addContact(newContact);
		assertTrue(contactService.getContactsCount() == 4, "Contact was no added!"); // confirms a contact was added
		
	}
	
	@Test
	void checkUpdateContact() {
		assertThrows(IllegalArgumentException.class, () -> {
	        Contact newContact = null;
	        contactService.updateContact(newContact);
	    });
		assertThrows(IllegalArgumentException.class, () -> {
	        Contact newContact = new Contact("firstName", "lastName", "9876543210", "Some new address", "invalid");
	        contactService.updateContact(newContact);
	    });
		
		String newFirstName = "newFirst";
		String newLastName = "newLast";
		String newPhone = "1236547890";
		String newAddress= "New Address";
		contact1.setFirstName(newFirstName);
		contact1.setLastName(newLastName);
		contact1.setPhone(newPhone);
		contact1.setAddress(newAddress);
		contactService.updateContact(contact1);
		
		// verifies fields were updated for contact
		assertTrue(contactService.getContact(contact1.getId()).getFirstName() == newFirstName);
		assertTrue(contactService.getContact(contact1.getId()).getLastName() == newLastName);
		assertTrue(contactService.getContact(contact1.getId()).getPhone() == newPhone);
		assertTrue(contactService.getContact(contact1.getId()).getAddress() == newAddress);
		
		assertTrue(contactService.getContactsCount() == 3); // confirms that a contact was updated and not added
	}
	
	@Test
	void checkRemoveContact() {
		contactService.removeContact(contact1);
		assertTrue(contactService.getContactsCount() == 2); // confirms that a contact was removed
	}
	
	@Test
	void checkClearContacts() {
		contactService.clearContacts();
		assertTrue(contactService.getContactsCount() == 0); // confirms that all contacts were removed
	}
}
