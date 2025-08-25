package com.yaumel.ContactsApp.testing;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


import com.yaumel.ContactsApp.Contact;

public class ContactTest {
	
	@Test
	void checkContactId() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        // try to create a Contact with null id
	        new Contact("aFirstName", "ALastName", "1123456789", "100 Main, Murrells Inlet, SC", null);
	    });
	    assertThrows(IllegalArgumentException.class, () -> {
	        // try to create a Contact with id greater than 10 characters
	        new Contact("aFirstName", "aLastName", "1123456789", "100 Main, Murrells Inlet, SC", "idIsTooLong");
	    });
	    
	    String id = "idIs10char";
	    Contact contact = new Contact("aFirstName", "aLastName", "1123456789", "100 Main, Murrells Inlet, SC", id);
	    assertTrue(id == contact.getId(), "Id was not set!");
	}
	
	@Test
	void checkContactFirstName() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        // try to create a Contact with null for firstName
	        new Contact(null, "ALastName", "1123456789", "100 Main, Murrells Inlet, SC", "idis10char");
	    });
	    assertThrows(IllegalArgumentException.class, () -> {
	        // try to create a Contact with firstName greater than 10 characters
	        new Contact("This is longer than 10 characters", "aLastName", "1123456789", "100 Main, Murrells Inlet, SC", "idIs10char");
	    });
	    
	    String firstName = "aFirstName";
	    Contact contact = new Contact(firstName, "aLastName", "1123456789", "100 Main, Murrells Inlet, SC", "idIs10char");
	    assertTrue(firstName == contact.getFirstName(), "First name was not set!");
	}
	
	@Test
	void checkContactLastName() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        // try to create a Contact with null last name
	        new Contact("aFirstName", null, "1123456789", "100 Main, Murrells Inlet, SC", "idis10char");
	    });
	    assertThrows(IllegalArgumentException.class, () -> {
	        // try to create a Contact with last name greater than 10 characters
	        new Contact("aFirstName", "aLastNameTooLong", "1123456789", "100 Main, Murrells Inlet, SC", "idis10char");
	    });
	    
	    String lastName = "aLastName";
	    Contact contact = new Contact("aFirstName", lastName, "1123456789", "100 Main, Murrells Inlet, SC", "idis10char");
	    assertTrue(lastName == contact.getLastName(), "Last name was not set!");
	}
	
	@Test
	void checkContactPhone() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        // try to create a Contact with null phone
	        new Contact("aFirstName", "aLastName", null, "100 Main, Murrells Inlet, SC", "idis10char");
	    });
	    assertThrows(IllegalArgumentException.class, () -> {
	        // try to create a Contact with phone greater than 10 characters
	        new Contact("aFirstName", "aLastName", "1123456789345345", "100 Main, Murrells Inlet, SC", "idis10char");
	    });
	   
	    assertThrows(IllegalArgumentException.class, () -> {
	        // try to create a Contact with phone less than 10 characters
	        new Contact("aFirstName", "aLastName", "123456", "100 Main, Murrells Inlet, SC", "idis10char");
	    });
	    
	    String phone = "1123456789";
	    Contact contact = new Contact("aFirstName", "aLastName", phone, "100 Main, Murrells Inlet, SC", "idis10char");
	    assertTrue(phone == contact.getPhone(), "Phone was not set!");
	}
	
	@Test
	void checkContactAddress() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        // try to create a Contact with null address
	        new Contact("aFirstName", "aLastName", "1123456789", null, "idis10char");
	    });
	    assertThrows(IllegalArgumentException.class, () -> {
	        // try to create a Contact with address greater than 30 characters
	        new Contact("aFirstName", "aLastName", "1123456789", "this address string is way too long", "idis10char");
	    });
	    
	    String address = "100 Main, Murrells Inlet, SC";
	    Contact contact = new Contact("aFirstName", "aLastName", "1123456789", address, "idis10char");
	    assertTrue(address == contact.getAddress(), "Address was not set!");
	}
}
